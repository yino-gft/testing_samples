package com.santander.globilehub.mobileapp.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium_Grid_MultiDevices extends Edition054_Selenium_Grid{
	//protected RemoteWebDriver driver;
	//static String HUB_URL = "http://localhost:4444/wd/hub";
	
	@Before
	public void setUp() throws MalformedURLException {
		
	}	
	
	@Test
	public void testIOS() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "11.4");
		caps.setCapability("deviceName", "iPhone 8");
		caps.setCapability("browserName", "Safari");
	
		driver = new RemoteWebDriver(new URL(HUB_URL), caps);
		//actualTest(driver);
	}	
	
	@Test
	public void testAndroid() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Android Emulator");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("browserName", "Chrome");
	
		driver = new RemoteWebDriver(new URL(HUB_URL), caps);
		//actualTest(driver);
	}
	
	@Test
	public void testDesktopChrome() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "chrome");
		//caps.setCapability("browserVersion", "71");
		//caps.setCapability("platformName", "MAC");
	
		driver = new RemoteWebDriver(new URL(HUB_URL), caps);
		actualTest(driver);
	}	
	
	@Test
	public void testDesktopFirefox() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "firefox");
		//caps.setCapability("browserVersion", "71");
		//caps.setCapability("platformName", "MAC");
	
		driver = new RemoteWebDriver(new URL(HUB_URL), caps);
		actualTest(driver);
	}	

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
