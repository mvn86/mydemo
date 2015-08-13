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

package org.demo.xmemcached.example2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.KeyIterator;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.transcoders.StringTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * 
 * @CreateTime 2015年4月17日 下午5:39:59
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class Exmple2 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws MemcachedException
	 * @throws InterruptedException
	 * @throws TimeoutException
	 */
	public static void main(String[] args) throws IOException,
			TimeoutException, InterruptedException, MemcachedException {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("172.19.2.7:11211"));
		MemcachedClient client = builder.build();
		client.flushAll();
		if (!client.set("hello", 0, "world")) {
			System.err.println("set error");
		}
		if (client.add("hello", 0, "dennis")) {
			System.err.println("Add error,key is existed");
		}
		if (!client.replace("hello", 0, "dennis")) {
			System.err.println("replace error");
		}
		client.append("hello", " good");
		client.prepend("hello", "hello ");
		String name = client.get("hello", new StringTranscoder());
		System.out.println(name);
		client.deleteWithNoReply("hello");

		getIteratorMemcached(client);

		client.shutdown();
	}

	public static void getIteratorMemcached(MemcachedClient client)
			throws MemcachedException, InterruptedException, TimeoutException {
		KeyIterator it = client.getKeyIterator(AddrUtil
				.getOneAddress("172.19.2.7:11211"));
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}

}
