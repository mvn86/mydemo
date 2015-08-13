/*
 * Copyright 2002-2101 SIM group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demo.selenium.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * 
 * @CreateTime 2015年5月15日 上午10:40:22
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class GridExampleTest {

	@Test
	public void GridTwoNodeTest() throws MalformedURLException,
			InterruptedException {

		DesiredCapabilities aDesiredcap = DesiredCapabilities.chrome();
		WebDriver dr = new RemoteWebDriver(new URL(
				"http://172.19.6.46:5555/wd/hub"), aDesiredcap);
		dr.get("http://www.baidu.com");
		dr.manage().window().maximize();

		String str[] = new String[] { "java", "selenium", "spring", "mybatis",
				"jps", "grid", "mysql", "iphone" };
		for (String string : str) {
			WebElement element = dr.findElement(By.xpath(".//*[@id='kw']"));
			element.clear();
			element.sendKeys(string);

			Thread.sleep(1000);

			WebElement buttons = dr.findElement(By.xpath(".//*[@id='su']"));

			System.out.println(buttons.getTagName());

			buttons.click();
		}

		Thread.sleep(2000);

		dr.close();

	}
}
