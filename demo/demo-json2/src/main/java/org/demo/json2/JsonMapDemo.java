/**
 * 
 */
package org.demo.json2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author chao.yu
 *
 */
public class JsonMapDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		//String str = "{[{\"partnerId\":116,\"refItemId\":\"132\",\"beginDate\":\"2015-07-22T18:12:22.272+08:00\",\"endDate\":\"2015-07-30T18:12:22.272+08:00\",\"refPoiId\":\"3\"},{\"partnerId\":117,\"refItemId\":\"133\",\"beginDate\":\"2015-07-22T18:12:22.272+08:00\",\"endDate\":\"2015-07-30T18:12:22.272+08:00\",\"refPoiId\":\"3\"}]}";
		String str = "{\"partnerId\":116,\"refItemId\":\"132\",\"beginDate\":\"2015-07-22T18:12:22.272+08:00\",\"endDate\":\"2015-07-30T18:12:22.272+08:00\",\"refPoiId\":\"3\"}";

		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		Map<String, String> map = mapper.readValue(str, Map.class);

		System.out.println(map.size());
		
		toArrayList();

	}
	
	
	public static  void toArrayList() throws JsonParseException, JsonMappingException, IOException{
		
		String str ="[[\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"H\"],[\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"H\"]]";
		
		ObjectMapper mapper = new ObjectMapper();

		List<List<String>>  list = mapper.readValue(str, List.class);
	
		for (List<String> list2 : list) {
			for (String string : list2) {
				System.out.print(string+"\t");
			}
			System.out.println();
		}
	}

}
