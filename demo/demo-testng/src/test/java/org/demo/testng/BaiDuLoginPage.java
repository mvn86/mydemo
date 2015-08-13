package org.demo.testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaiDuLoginPage {

	@FindBy(id = "TANGRAM__PSP_8__userName")
	private WebElement userName;
	@FindBy(id = "TANGRAM__PSP_8__password")
	private WebElement userPwd;
	@FindBy(id = "TANGRAM__PSP_8__memberPass")
	private WebElement rememberChexBox;
	@FindBy(id = "TANGRAM__PSP_8__submit")
	private WebElement loginButton;

	public void loginOption(String uName, String uPwd) {
		userName.clear();
		userName.sendKeys(uName);
		userPwd.sendKeys(uPwd);
		rememberChexBox.click();
		loginButton.click();
	}
}
