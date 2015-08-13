package org.demo.testng;

import java.lang.reflect.Field;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class UserDefineListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		WebDriver d=null;
		super.onTestFailure(tr);
		//这边TakeScreenShot的takeScreenShot方法需要传递一个WebDriver参数
		//方法一：可用单例模式，将driver变成一个全局静态变量，但是这样的话对于多线程运行，启动多个driver实例就不行了；
		//方法二：tr.getInstance()获取运行当前测试方法的实例即类实例
		Class<? extends Object> tc=tr.getInstance().getClass();//Class泛型Object以及Object的所有子类。
			try {
				Field f=tc.getDeclaredField("driver");
				f.setAccessible(true);
				try {
					d=(WebDriver) f.get(tr.getInstance());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			//Method method=tc.getMethod("getWebDriver");
			//d=(WebDriver) method.invoke(tr.getInstance());
	
		TakeScreenShot ts = new TakeScreenShot();
		String filePath = ts.takeScreenShot(d);

		String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
		String TITLE="org.uncommons.reportng.title";
		System.setProperty(ESCAPE_PROPERTY, "false"); // Reportng中不设置该属性则不显示图片而显示一串字符串
		System.setProperty(TITLE, "DefineListener!"); 
		//报告中添加截图并为图片添加超链接
		Reporter.log("<a href=\"../../" + filePath + "\" target=\"_blank\">"
				+ "<img width='50' height='50' src=\"../../" + filePath
				+ "\"/>" + "</a>", true);
	}
}
