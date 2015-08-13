package org.demo.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaiDuSearchView {
	private WebDriver driver;
	private JavascriptExecutor jse;
	private WebDriverWait wait;
	@FindBy(css = "#u > a.toindex")
	private WebElement backToFirstPageLink;
	@FindBy(css = "#u > a.lb")
	private WebElement loginLink;
	@FindBy(css = "#page > a.n")
	private WebElement nextPageButton;

	public BaiDuSearchView(WebDriver d) {
		this.driver = d;
		wait = new WebDriverWait(driver, 10);
	}

	// 如果没有传入特定的WebElement，传入null，则滚动至页面底部；否则滚动至某具体元素位置
	public void scrollPage(WebElement e) {
		WebElement element = (e == null) ? nextPageButton : e;
		int desPosition = element.getLocation().y;
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,arguments[0])", desPosition);
	}

	public void getInNextPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector("#page > a.n")));
		nextPageButton.click();
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor jse = (JavascriptExecutor) d;
				String state = (String) jse
						.executeScript("return document.readyState");
				return state.equals("complete");
			}
		});
	}

	public void backToFirstPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector("#u > a.toindex")));
		backToFirstPageLink.click();
	}

	public void navigateToLoginPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector("#u > a.lb")));
		loginLink.click();
	}

}
