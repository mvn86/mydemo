package com.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class MD5 {

	/**
	 * 生成MD5加密的字符串
	 * 
	 * @author yongda.chen
	 * @createTime 2015年7月9日 下午6:31:22
	 * 
	 * @param str
	 *            需要加密的字符串
	 * @return 32位大写MD5
	 */
	public String getMD5(String str) {
		String reStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(str.getBytes());
			StringBuffer stringBuffer = new StringBuffer();
			for (byte b : bytes) {
				int bt = b & 0xff;
				if (bt < 16) {
					stringBuffer.append(0);
				}
				stringBuffer.append(Integer.toHexString(bt));
			}
			reStr = stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return reStr.toUpperCase();
	}

	public static void main(String[] args) throws JsonProcessingException {
		MD5 ap = new MD5();
		
		ExamplePo examplePo=new ExamplePo();
		String date=DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd");
		
		examplePo.setDate(date);
		examplePo.setItemStatus("1");
		examplePo.setRefItemId("102");
		examplePo.setRemainCount("202");
		
		List<ExamplePo> list=new ArrayList<ExamplePo>();
		list.add(examplePo);
		
		ObjectMapper mapper = new ObjectMapper();	
		//对象
		System.out.println(mapper.writeValueAsString(examplePo));
		//
		System.out.println(mapper.writeValueAsString(list));	
		
		
//		
//		String md5 = ap
//				.getMD5("methodputktvproductrealtimepartnerId1003realTimeInfo[{\"refItemId\":\"102\",\"date\":\"2015-07-09\",\"remainCount\":202,\"itemStatus\":1}]70626922BFE81BERA6B38D5534CBU706");
//		System.out.println(md5);
	}
}
