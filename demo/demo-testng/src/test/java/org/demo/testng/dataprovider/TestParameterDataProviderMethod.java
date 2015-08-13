/**
 * 
 */
package org.demo.testng.dataprovider;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author chao.yu
 *
 */
public class TestParameterDataProviderMethod {

	@Test(dataProvider = "dataProvider")
	public void test1(int number, int expected) {
		Assert.assertEquals(number, expected);
	}

	@Test(dataProvider = "dataProvider")
	public void test2(String email, String expected) {
		Assert.assertEquals(email, expected);
	}

	/**
	 * 根据不同的方法名提供不同的数据
	 * 
	 * @param method
	 * @return
	 */
	@DataProvider(name = "dataProvider")
	public Object[][] provideData(Method method) {

		Object[][] result = null;

		if (method.getName().equals("test1")) {
			result = new Object[][] { { 1, 1 }, { 200, 200 } };
		} else if (method.getName().equals("test2")) {
			result = new Object[][] { { "test@gmail.com", "test@gmail.com" },
					{ "test@yahoo.com", "test@yahoo.com" } };
		}

		return result;

	}
}
