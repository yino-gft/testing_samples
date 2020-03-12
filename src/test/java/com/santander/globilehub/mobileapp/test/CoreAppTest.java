package com.santander.globilehub.mobileapp.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CoreAppTest {
	private AndroidDriver<WebElement> driver;
	private final String PACKAGE = "com.santander.globile.coreapp";
	private final String SEARCH_ACTIVITY = ".Login";
	
	@Before
	public void setUp() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "8");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		capabilities.setCapability("appPackage", PACKAGE);
		capabilities.setCapability("appActivity", ".MainActivity");
		//capabilities.setCapability("appWaitPackage", PACKAGE); 
		//capabilities.setCapability("appWaitActivity", ".view.TestFields");
		 
		capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ynavarro\\Downloads\\coreapp.apk");
		
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
	}	
	
    @Test()
    public void testSendKeys() {
    	//Sdriver.startActivity(new Activity(PACKAGE, SEARCH_ACTIVITY));
    	
    	
    	driver.findElementById("com.santander.globile.coreapp:id/userField").sendKeys("Hanna");
    	driver.findElementById("com.santander.globile.coreapp:id/test").sendKeys("111111");
    	driver.findElementById("com.santander.globile.coreapp:id/loginButton").click();
    	
    	AndroidElement titleText = (AndroidElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.santander.globile.coreapp:id/globalPositionHelloField")));
    	
    	System.out.println("title: "+titleText.getText());
    	
    	Assert.assertEquals(titleText.getText(), "Hello Hanna");
    	
    	driver.findElementById("com.santander.globile.coreapp:id/global_position").click();
    	
    	AndroidElement globalPositionText = (AndroidElement) new WebDriverWait(driver, 30)
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.TextView")));

    	System.out.println("title: "+globalPositionText.getText());
    	
    	Assert.assertEquals(globalPositionText.getText(), "Manage what to show on your Global Position");
    	
    	
    	driver.findElementById("com.santander.globile.coreapp:id/menu_transactions").click();
    	
    }
	
	
	@After
	public void tearDown() {
		driver.close();
	}
		
	
}
