package org.demo.testng.dataprovider;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 * @author chao.yu
 *
 */
public class TestParameterDataProviderITestContext {

	@Test(dataProvider = "dataProvider", groups = { "groupA" })
	public void test1(int number) {
		Assert.assertEquals(number, 1);
	}

	@Test(dataProvider = "dataProvider", groups = "groupB")
	public void test2(int number) {
		Assert.assertEquals(number, 2);
	}

	@DataProvider(name = "dataProvider")
	public Object[][] provideData(ITestContext context) {

		Object[][] result = null;

		// get test name
		System.out.println(context.getName());

		for (String group : context.getIncludedGroups()) {

			System.out.println("group : " + group);

			if ("groupA".equals(group)) {
				result = new Object[][] { { 1 } };
				break;
			}

		}

		if (result == null) {
			result = new Object[][] { { 2 } };
		}
		return result;

	}

}
