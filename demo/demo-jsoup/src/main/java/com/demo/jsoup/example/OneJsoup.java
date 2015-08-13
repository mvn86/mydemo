/*
 * Copyright 2002-2101 SIM group.
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

package com.demo.jsoup.example;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 
 * @CreateTime 2015年5月14日 下午3:57:55
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class OneJsoup {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		Connection connection = Jsoup.connect("http://www.baidu.com");
		//提供接口参数
		connection.data("a", "b");
		//get 方式请求
		Document document=  connection.get();
		//post 方式请求
		//Document document1=  connection.post();
		//抓到所有html代码
		System.out.println(document.html());
		
		document.body();

	}

}
