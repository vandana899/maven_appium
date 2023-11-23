package hybrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class settings {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
		DesiredCapabilities dc =  new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.homepage.SettingsHomepageActivity");
		driver =  new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
	}
	
	@Test(enabled=true)
	public void testcase1() throws InterruptedException
	{
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Advanced features\"))").click();
	    Thread.sleep(5000);
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Game Launcher\"))").click();
	    Thread.sleep(5000);
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Game Launcher\"))").click();
	    Thread.sleep(5000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(5000);
	   // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"User Manual\"))");
	    //Thread.sleep(5000);
	    
	    driver.findElement(MobileBy.AccessibilityId("Search settings")).click();
	    
	    Thread.sleep(5000);
	    driver.findElement(MobileBy.id("com.android.settings.intelligence:id/search_src_text")).sendKeys("Battery");
	    Thread.sleep(5000);
	   // driver.findElementByAndroidUIAutomator("text(\"Battery\")").click();
       // driver.findElement(MobileBy.AccessibilityId("Power saving")).click();
	    
	    //Thread.sleep(5000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(2000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(2000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(2000);
	    //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().class(\"android.widget.RelativeLayout\")).scrollIntoView(new UiSelector().text(\"Developer options\"))");
		//Thread.sleep(8000);
		int size=driver.findElements(MobileBy.className("android.widget.RelativeLayout")).size();
		Thread.sleep(3000);
	    System.out.println(size);
	    
	    
	    for (int i =0;i<size;i++)
		{
			
		String van=driver.findElements(MobileBy.className("android.widget.TextView")).get(i).getText();
		System.out.println(van);
		Thread.sleep(3000);
		System.out.println(van);
//		if(van.equalsIgnoreCase("Jordan Lift Off"))
//		{Thread.sleep(3000);
//			driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//			Thread.sleep(3000);
//			break;
//		}
			
	}
	
	    
	    
	    
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}