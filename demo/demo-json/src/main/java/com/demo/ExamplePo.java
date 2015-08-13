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

package com.demo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @CreateTime 2015年7月10日 下午1:59:20
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class ExamplePo {

	// {\"refItemId\":\"102\",\"date\":\"2015-07-09\",\"remainCount\":202,\"itemStatus\":1}]

	private String refItemId;
	private String date;
	private String remainCount;
	private String itemStatus;

	/**
	 * @return the refItemId
	 */
	public String getRefItemId() {
		return refItemId;
	}

	/**
	 * @param refItemId
	 *            the refItemId to set
	 */
	public void setRefItemId(String refItemId) {
		this.refItemId = refItemId;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the remainCount
	 */
	public String getRemainCount() {
		return remainCount;
	}

	/**
	 * @param remainCount
	 *            the remainCount to set
	 */
	public void setRemainCount(String remainCount) {
		this.remainCount = remainCount;
	}

	/**
	 * @return the itemStatus
	 */
	public String getItemStatus() {
		return itemStatus;
	}

	/**
	 * @param itemStatus
	 *            the itemStatus to set
	 */
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	/**
	 * 
	 */
	public ExamplePo() {
	}

	/**
	 * @param refItemId
	 * @param date
	 * @param remainCount
	 * @param itemStatus
	 */
	public ExamplePo(String refItemId, String date, String remainCount,
			String itemStatus) {
		this.refItemId = refItemId;
		this.date = date;
		this.remainCount = remainCount;
		this.itemStatus = itemStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("refItemId", refItemId)
				.append("date", date).append("remainCount", remainCount)
				.append("itemStatus", itemStatus).toString();
	}

}
