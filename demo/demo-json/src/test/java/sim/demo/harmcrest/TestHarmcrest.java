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

package sim.demo.harmcrest;


import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import static  org.hamcrest.core.Is.*;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @CreateTime  2015年7月10日 下午3:35:28
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class TestHarmcrest {
	
	@Test
	public void isnumber(){
		
		String nu="12345678901";
		assertThat(nu, is(internationNumber()));
	}


	//判断有11位手机号码的扩展匹配器
	public Matcher<String> internationNumber(){
		
		return new BaseMatcher<String>() {

			@Override
			public boolean matches(Object candidata) {
				if (!(candidata instanceof String)) {
					return false;
				}
				return candidata.toString().matches("^1[0-9]{10}$");
			}

			@Override
			public void describeTo(Description description) {
				description.appendValue("compliant internation phone number!");
			}

		};
		
	}
	
}
