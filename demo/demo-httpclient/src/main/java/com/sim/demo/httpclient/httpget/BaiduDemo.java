/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sim.demo.httpclient.httpget;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 
 * @author Chris Yu
 *
 * @CreateTime 2015年4月14日 下午3:07:17
 * 
 */
public class BaiduDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient=HttpClients.createDefault();
		
		HttpGet httpGet=new HttpGet("http://www.baidu.com");
		
		System.out.println(httpGet.getURI().toString());
		
		CloseableHttpResponse response= httpClient.execute(httpGet);
		
		int statusCode=response.getStatusLine().getStatusCode();
		if (statusCode==200) {
			HttpEntity entity= response.getEntity();
			
			String context= EntityUtils.toString(entity, "UTF-8");
			
			System.out.println("context : "+context);
		}
		
		httpClient.close();
		
		
	}

}
