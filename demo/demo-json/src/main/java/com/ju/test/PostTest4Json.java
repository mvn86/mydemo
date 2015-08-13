package com.ju.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ju.util.HttpPost;
import com.ju.utils.EncryptUtils;

public class PostTest4Json {
	public static void main(String[] args) {
		
		String signature = "";
		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		HttpPost post = new HttpPost();
		Map<String, String> map = new HashMap<String, String>();
		String pubKeyUrl = "F:/lunaWorkspace/demo/demo-json/src/main/resources/public.key";
		String agencyNo = "00000000";
		
		//开户交易 
		String tradeCode = "100101";
		String msgInfo = "|"+sdf1.format(date)+"|洪岩|00|130727198408052394|18606078710|";
		//绑卡短信请求交易
//		String tradeCode = "100201";
//		String msgInfo = "|"+sdf1.format(date)+"|000000000000000004|12345678|6225882145221419|18606078710|";
		//解绑卡短信请求交易
//		String tradeCode = "100202";
//		String msgInfo = "|"+sdf1.format(date)+"|000000000000000004|78897467|";
		//充值交易短信请求
//		String tradeCode = "100301";
//		String msgInfo = "|"+sdf1.format(date)+"|000000000000000004|50592499|000000100000050|000000000000010|";
		//提现交易短信请求
//		String tradeCode = "100302";
//		String msgInfo = "|"+sdf1.format(date)+"|000000000000000005|43089306|000000000000100|000000000000010|";
		//个人会员查询
//		String tradeCode = "100401";
//		String msgInfo = "|"+sdf1.format(date)+"|000000000000000005|";
		//会员余额查询
//		String tradeCode = "100402";
//		String msgInfo = "|"+sdf1.format(date)+"|000000000000000005|";
		//对账文件下载
//		String tradeCode = "109801";
//		String msgInfo = "|"+sdf1.format(date)+"|20150323|02|";
		//发标请求
//		String tradeCode = "300101";
//		String msgInfo = "|"+sdf1.format(date)+"|sdx132|施东旭借款测试标的|20150510235959|000000000000000005|000000000100000|1000|000000000001000|30|0||||";
		//投标请求
//		String tradeCode = "300201";
//		String msgInfo = "|"+sdf1.format(date)+"|20150412000000000020|000000000000000006|000000000050000|";
		//满标放款
//		String tradeCode = "300301";
//		String msgInfo = "|"+sdf1.format(date)+"|20150412000000000020|000000000000000005|";
		//流标
//		String tradeCode = "300401";
//		String msgInfo = "|"+sdf1.format(date)+"|20150403000000000015|000000000000000005|";
		//标的终结
//		String tradeCode = "300601";
//		String msgInfo = "|"+sdf1.format(date)+"|20150405000000000019|000000000000000005|";
		//标的还款
//		String tradeCode = "300501";
//		String msgInfo = "|"+sdf1.format(date)+"|20150405000000000019|000000000000000005|000000000049000|000000000001000|*0000000000000019,000000000025000,000000000000000*0000000000000020,000000000024000,000000000001000*|";
		//短信验证交易
//		String tradeCode = "109901";
		//开户
//		String msgInfo = "|"+sdf1.format(date)+"|100101|20150411000000000108|904560|";
		//绑卡
//		String msgInfo = "|"+sdf1.format(date)+"|100201|20150411000000000109|593021|";
		//解绑卡
//		String msgInfo = "|"+sdf1.format(date)+"|100202|20150412000000000113|702159|";
		//充值
//		String msgInfo = "|"+sdf1.format(date)+"|100301|20150411000000000111|487931|";
		//提现
//		String msgInfo = "|"+sdf1.format(date)+"|100302|20150405000000000072|795448|";
		//投标
//		String msgInfo = "|"+sdf1.format(date)+"|300201|20150412000000000115|675904|";
		//交易查询 
//		String tradeCode = "100403";
//		String msgInfo = "|"+sdf1.format(date)+"|00000020150413001508|";
		
		String orderId = "000000"+sdf1.format(date);
		
		try {
			msgInfo = EncryptUtils.encrypt(msgInfo, pubKeyUrl);
			signature = EncryptUtils.juSignature(agencyNo+tradeCode+msgInfo, pubKeyUrl);
			
		} catch (Exception e1) {
			System.out.println("报文拼接失败");
			e1.printStackTrace();
			return;
		}
		
		map.put("agencyNo", agencyNo);
		map.put("tradeCode", tradeCode);
		map.put("orderId",orderId);	
		map.put("msg", msgInfo);
		map.put("signature", signature);
		
		String responts = "";
		try {
			long a = System.currentTimeMillis();
			responts = post.http("http://192.168.10.41:8001/ju-bussiness/p2p/p2pInterface!p2pTransaction.do",map);
//			responts = post.http("http://localhost:7025/ju-bussiness-webapp/p2p/p2pInterface!p2pTransaction.do",map);
			//获取signature 并通过调用EncryptUtils.juValidateSignature(agencyNo, tradeCode, msg, publicKeyFileUrl, ciphertext)判断signature是否正确
			if(EncryptUtils.juValidateSignature(responts, pubKeyUrl)){
				System.out.println(responts);
				System.out.println("耗时"+(System.currentTimeMillis()- a));
			}else{
				System.out.println("校验失败");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		System.exit(0);
	
	}
	
}
