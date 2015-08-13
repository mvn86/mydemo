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

package com.sim.demo.json;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @CreateTime 2015年5月6日 上午9:18:18
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class User {

	private String name;
	private String adress;
	private String age;
	private String sax;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress
	 *            the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the sax
	 */
	public String getSax() {
		return sax;
	}

	/**
	 * @param sax
	 *            the sax to set
	 */
	public void setSax(String sax) {
		this.sax = sax;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param name
	 * @param adress
	 * @param age
	 * @param sax
	 */
	public User(String name, String adress, String age, String sax) {
		this.name = name;
		this.adress = adress;
		this.age = age;
		this.sax = sax;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(getClass()).append("name", this.name)
				.append("age", this.age).append("adress", this.adress)
				.append("sax", this.sax).toString();
	}

}
