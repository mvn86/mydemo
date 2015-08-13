package com.demo;

import java.io.IOException;

import org.jsoup.Jsoup;

public class JsoupUtils {

	/**
	 * 获取发送json格式请求的响应
	 * 
	 * @author yongda.chen
	 * @createTime 2015年7月9日 下午7:17:10
	 * 
	 * @param url 请求URL
	 * @return 返回的响应
	 * @throws IOException
	 */
	public String getJsonResponse(String url) throws IOException {
		String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
		return json;
	}

	public static void main(String[] args) throws IOException {
		JsoupUtils jsoup = new JsoupUtils();
		String url = "http://192.168.76.36/funpartner/putktvproductrealtime?";
		String response = jsoup.getJsonResponse(url);
		System.out.println(response);
	}

}
