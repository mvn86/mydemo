/**
 * 
 */
package org.demo.testng.dataprovider;

import org.demo.testng.Employee;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author chao.yu
 *
 */
public class TestDataProviderParametersObject {

	@Test(dataProvider="employeeData")
	public void empTest(Employee employee) {
		System.out.println("Employee testing: Data(" + employee + ")");
	}	
	
	
	@DataProvider(name="employeeData") 
	public Object[][] getEmployeeData() {
		return new Object[][]{{new Employee("Joe")}, {new Employee("Sam")}};
	}
}
