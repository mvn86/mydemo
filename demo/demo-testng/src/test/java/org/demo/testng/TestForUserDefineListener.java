package org.demo.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(UserDefineListener.class)
public class TestForUserDefineListener {
	private WebDriver driver;
	private String baseUrl = "";
	private BaiDuFirstPage bdfp = null;

	@Test
	public void f1() {
		bdfp.open(driver, baseUrl);
		bdfp.navigateToNews();
		driver.findElement(By.id("zxm"));
	}

	@Test
	public void f2() throws InterruptedException {
		bdfp.open(driver, baseUrl);
		bdfp.searchSomething("Selenium");
		Thread.sleep(3000);
		BaiDuSearchView bdsv = PageFactory.initElements(driver,
				BaiDuSearchView.class);
		bdsv.scrollPage(null);
		Thread.sleep(3000);
		driver.findElement(By.id("zxm"));
	}

	@Test
	public void f3() {
		System.out.print("Test success!");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://www.baidu.com/";
		bdfp = PageFactory.initElements(driver, BaiDuFirstPage.class);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}

}
