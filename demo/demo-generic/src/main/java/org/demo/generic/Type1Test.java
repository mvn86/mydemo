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

package org.demo.generic;

/**
 * 
 * @CreateTime 2015年5月11日 上午11:33:31
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class Type1Test implements Info<String> {
	private String var;

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public static void main(String[] args) {
		Type1Test test = new Type1Test();
		test.setVar("like");
		System.out.println(test.getVar());
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
