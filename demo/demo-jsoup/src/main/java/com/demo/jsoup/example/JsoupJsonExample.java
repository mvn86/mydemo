/**
 * 
 */
package com.demo.jsoup.example;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author chao.yu
 *
 */
public class JsoupJsonExample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String str = "http://180.166.211.218/dong-payServer/weixinpay/ordstatus";
		Connection conn = Jsoup.connect(str);

		conn.data("out_trade_no", "20150624213414387120");

		String str1 = conn.ignoreContentType(true).execute().body();

		System.out.println(str1);

		ObjectMapper mapper = new ObjectMapper();

		Map<String, Object> map = mapper.readValue(str1, Map.class);
		
		System.out.println(map.size());
		
		
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}

	}

}
