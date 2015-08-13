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
package com.sim.demo.gen;

import java.io.Serializable;

/**
 * 
 * 
 * @author Chris Yu
 *
 * @CreateTime 2015年4月10日 下午4:55:35
 * 
 */
public class Gen<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T param;

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

	/**
	 * 
	 */
	public Gen() {
		System.out.println();
	}

	public static void main(String[] args) {
		Gen<String> gen1 = new Gen<String>();
		gen1.setParam("abc");

		System.out.println("gen1 = " + gen1.getParam());

		Gen<Integer> gen2 = new Gen<Integer>();
		gen2.setParam(10);

		System.out.println("gen2 = " + gen2.getParam());

	}
}
