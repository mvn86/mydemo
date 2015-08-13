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
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 
 * @author Chris Yu
 *
 * @CreateTime 2015年4月14日 下午2:17:38
 * 
 */
public class SinaDemo {
	
	public static void main(String[] args) throws IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建HttpGet
		HttpGet httpGet = new HttpGet("http://www.sina.com");
		System.out.println("executing request " + httpGet.getURI());
		// 执行get请求
		HttpResponse response = httpClient.execute(httpGet);
		// 获取响应实体
		HttpEntity entity = response.getEntity();
		// 打印响应状态
		System.out.println(response.getStatusLine());
		if (entity != null) {
			// 打印响应内容的长度
			System.out.println("Response content lenght:"
					+ entity.getContentLength());
			String content = EntityUtils.toString(entity, "UTF-8").trim();
			// 解决HttpClient获取中文乱码 ，用String对象进行转码
			System.out.println("Response content:" + content);
		}
		// 关闭连接，释放资源
		httpClient.close();
	}
}
