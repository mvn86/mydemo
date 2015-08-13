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
package com.sim.demo.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 
 * @author Chris Yu
 *
 * @CreateTime 2015年4月10日 下午5:37:04
 * 
 */
public class DemoJson {

	public static void main(String[] args) throws JsonProcessingException {
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("A");
		list2.add("B");
		list2.add("C");
		list2.add("D");
		list2.add("E");
		list2.add("F");
		list2.add("H");
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.add("E");
		list1.add("F");
		list1.add("H");
		
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(list1);
		list.add(list2);
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.convertValue(list, List.class);

		System.out.println(mapper.toString());

		System.out.println(mapper.writeValueAsString(list));

		try {
			ArrayList<String> arraylist=mapper.readValue("[\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"H\"]", ArrayList.class);
			
			for (String string : arraylist) {
				System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
