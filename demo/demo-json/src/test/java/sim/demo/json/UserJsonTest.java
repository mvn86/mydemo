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

package sim.demo.json;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sim.demo.json.User;

/**
 * 
 * @CreateTime 2015年5月6日 上午9:20:11
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class UserJsonTest {

	@Test
	public void jsonTest() throws JsonProcessingException {

		User user = new User();
		user.setName("chris");
		user.setAdress("shanghai");
		user.setAge("20");
		user.setSax("2");

		ObjectMapper mapper = new ObjectMapper();

		System.out.println(mapper.writeValueAsString(user));

		// {'name':'chris','adress':'shanghai','age':'20','sax':'2'}

	}

	@Test
	public void jsonTest01() throws JsonParseException, JsonMappingException,
			IOException {
		String str = "{\"name\":\"chris\",\"adress\":\"shanghai\"}";

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(str, User.class);

		System.out.println(user.toString());
		
		
		Map<String, String> map= mapper.readValue(str, Map.class);
		
		for (Map.Entry<String, String> data :map.entrySet()) {
			System.out.println(data.getKey()+"  "+data.getValue());
		}

	}
}
