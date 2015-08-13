package sim.demo.example;

import org.apache.commons.lang3.math.NumberUtils;

public class DemoExample {

	public static void main(String[] args) {

		String a = "1.0";
		NumberUtils.createInteger(a);
		System.out.println(NumberUtils.createDouble(a));
		Double d = NumberUtils.createDouble(a);
		
		
		System.out.println(d.intValue());


	}
}
