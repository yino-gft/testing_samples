package com.santander.globilehub.mobileapp.test;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edition054_Selenium_Grid {
	protected RemoteWebDriver driver;
	
	static String HUB_URL = "http://localhost:4444/wd/hub";
	
	private static By loginBtn = By.tagName("button");
	private static By username = By.id("username");
	private static By password = By.id("password");
	private static By message = By.id("flash");
	
	//private static String LOGIN_URL = "https://the-internet.herokuapp.com/login";
	private static String LOGIN_URL = "http://www.google.com";
	private static String ERR_MSG = "Your username is invalid!";
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	protected void actualTest(RemoteWebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.navigate().to(LOGIN_URL);
		WebElement findElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		findElement.sendKeys("Monorepo");
		
		Assert.assertEquals("Google", driver.getTitle());
	}
}
