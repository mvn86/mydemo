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

package org.demo.show.providers;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

/**
 * 
 * @CreateTime 2015年4月24日 下午5:57:09
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class ShowProviders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final Provider[] providers = Security.getProviders();
		for (final Provider p : providers) {
			System.out.format("%s %s%s", p.getName(), p.getVersion(),
					System.getProperty("line.separator"));
			for (final Object o : p.keySet()) {
				if (Arrays.asList(args).contains("-v")) {
					System.out.format("\t%s : %s%s", o,
							p.getProperty((String) o),
							System.getProperty("line.separator"));
				}
			}
		}
	}

}
