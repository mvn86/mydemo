package org.demo.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaiDuFirstPage {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy(css = "#u1 > a:nth-child(1)")
	private WebElement news;
	@FindBy(css = "#u1 > a.lb")
	private WebElement loginLink;
	@FindBy(id = "kw")
	private WebElement searchInput;
	@FindBy(id = "su")
	private WebElement searchNowButton;
	@FindBy(css="#s_username_top > span.user-name")
	private WebElement userNameAfterLogin;
	
	public BaiDuFirstPage(WebDriver d){
		this.driver=d;
		this.wait=new WebDriverWait(driver,10);
	}
	
	/*
	 * public BaiDuFirstPage(WebDriver d){ 
	 * this.driver=d;
	 * news=driver.findElement(By.cssSelector("#u1 > a:nth-child(1)"));
	 * loginLink=driver.findElement(By.cssSelector("#u1 > a.lb"));
	 * searchInput=driver.findElement(By.id("kw"));
	 * searchNowButton=driver.findElement(By.id("su")); }
	 */

	public void open(WebDriver driver, String baseUrl) {
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	public void searchSomething(String str) {
		//WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kw")));
		searchInput.sendKeys(str);
		searchNowButton.click();
	}
	
	public void login(String uName,String uPwd){
		//WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector( "#u1 > a.lb")));
		loginLink.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TANGRAM__PSP_8__userName")));
		BaiDuLoginPage bdlp=PageFactory.initElements(driver, BaiDuLoginPage.class);
		bdlp.loginOption(uName, uPwd);
	}
	
	public void navigateToNews(){
		//WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#u1 > a:nth-child(1)")));
		news.click();
	}
	
	public WebElement getUnameAfterLogin(){
		return userNameAfterLogin;
	}
}
