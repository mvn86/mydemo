package org.demo.testng;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {

	private String filePath = "";

	public String takeScreenShot(WebDriver driver) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String mDateTime = formatter.format(new Date());
		// 截图存放于target/screenshot目录下并以截图时间命名
		filePath = "screenshot/" + mDateTime + ".png";
		File screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

}
