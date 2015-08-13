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

package sim.demo.timeout;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

/**
 * 
 * @CreateTime  2015年7月10日 下午4:34:53
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class GlobalTimeoutTest {

	//timeout 构造函数以毫秒为单位
	@Rule
	public TestRule globalTimeout= new Timeout(1000);
	
	@Test
	public void infiniteLoop1(){
		
		System.out.println(new Date());
		while (true) {
			System.out.println("infiniteLoop1");
		}
	}
	@Test
	public void infiniteLoop2(){
		System.out.println(new Date());
		while (true) {
			System.out.println("infiniteLoop2");			
		}
	}
	
}
