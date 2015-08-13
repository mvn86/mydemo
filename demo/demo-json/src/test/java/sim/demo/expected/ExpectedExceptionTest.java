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

package sim.demo.expected;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * @CreateTime  2015年7月10日 下午5:27:39
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class ExpectedExceptionTest {

	@Rule
	public ExpectedException thrown=ExpectedException.none();
	
	@Test
	public void thisTestPasses(){
		
	}
	@Test
	public void thowExceptionAsExpected(){
		thrown.expect(NullPointerException.class);
		throw new NullPointerException();
	}
	
	@Test
	public void throwsExceptionWithCorrentMessage(){
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("boom");
		throw new NullPointerException("Ka-Boom");
		
	}
	
}
