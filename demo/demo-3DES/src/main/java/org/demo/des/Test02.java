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

package org.demo.des;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Iterator;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/**
 * 
 * @CreateTime 2015年4月24日 下午5:51:18
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class Test02 {

	public static void main(final String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {
		final Provider[] providers = Security.getProviders();
		for (int i = 0; i < providers.length; i++) {
			final String name = providers[i].getName();
			final double version = providers[i].getVersion();
			System.out.println("Provider[" + i + "]:: " + name + " " + version);
			if (args.length > 0) {
				final Iterator it = providers[i].keySet().iterator();
				while (it.hasNext()) {
					final String element = (String) it.next();
					if (element.toLowerCase().startsWith(args[0].toLowerCase())
							|| args[0].equals("-all"))
						System.out.println("\t" + element);
				}
			}
		}
		System.out.println(Cipher.getMaxAllowedKeyLength("AES"));
		System.out.println(Cipher.getMaxAllowedKeyLength("DESede"));
		
	}
}
