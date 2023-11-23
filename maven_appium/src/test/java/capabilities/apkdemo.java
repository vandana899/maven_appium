package capabilities;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.time.Duration.ofSeconds;
import java.time.Duration;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.touch.TapOptions;

import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.TapOptions.tapOptions;

public class apkdemo {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "7D8HMRDITGEAQ89D");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	@Test(priority = 0,enabled = false)
	public void tc() throws InterruptedException
{
	System.out.print("true");
	driver.findElement(MobileBy.id("com.android.permissioncontroller:id/continue_button")).click();
	Thread.sleep(5000);
	//driver.findElement(MobileBy.id("android:id/text1")).click();
	//driver.findElement(MobileBy.AccessibilityId("Animation")).click();
  //  driver.findElementByAccessibilityId("Animation").click();
	//driver.findElements(MobileBy.className("android.widget.TextView")).get(5).click();
	//driver.findElement(MobileBy.className("android.widget.TextView").click();
	driver.findElementByAccessibilityId("Text").click();
	Thread.sleep(5000);
	driver.findElementByAccessibilityId("4. Default values").click();
	Thread.sleep(5000);
	driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
	Thread.sleep(5000);
	driver.findElement(MobileBy.id("android:id/edit")).sendKeys("vandana");
	Thread.sleep(5000);
	driver.findElement(MobileBy.id("android:id/button2")).click();
	driver.navigate().back();
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Reversing\")")).click();

	Thread.sleep(5000);
}


	@Test(priority = 1,enabled = false)
	public void notifications() throws InterruptedException{
	driver.openNotifications();
	//driver.openNotifications();
	Thread.sleep(5000);
	//for auto rotate
	driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
	Thread.sleep(5000);
	System.out.println("auto rotate happened");
	//for wifi
	driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Wi-Fi,Off.,,Button\"]/android.widget.ImageView")).click();
	Thread.sleep(5000);
	//for bluetooth
	//driver.findElement(MobileBy.id("android:id/icon")).click();
	}
	@Test(enabled = false)
	public void tapnlongpress()
	{
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		AndroidElement tp= driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
		TouchAction ta= new TouchAction(driver);
		ta.tap(tapOptions().withElement(element(tp))).perform();
		
		AndroidElement lp= driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
		ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		
		
		
	}
	
	@Test(enabled = false)
	public void scroll()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElementByAccessibilityId("new Uiscrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
	}
	@Test(enabled = false)
	public void swipeactions()
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		driver.findElement(MobileBy.AccessibilityId("12")).click();
	AndroidElement ele1=	driver.findElement(MobileBy.AccessibilityId("15"));
	AndroidElement ele2=	driver.findElement(MobileBy.AccessibilityId("5"));
	TouchAction ta= new TouchAction(driver);
	ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	
	}
		
	@Test(enabled = true)
	public void draganddrop() throws InterruptedException
	{	//driver.findElement(MobileBy.id("com.android.permissioncontroller:id/continue_button")).click();
	   // Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		Thread.sleep(5000);
		AndroidElement ele1= driver.findElements(MobileBy.className("android.view.View")).get(0);
		AndroidElement ele2= driver.findElements(MobileBy.className("android.view.View")).get(1);
		TouchAction ta= new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	}
		
	@Test(enabled = false)
	public void  accessibility() throws InterruptedException{
		driver.findElement(MobileBy.id("com.android.permissioncontroller:id/continue_button")).click();
	    Thread.sleep(5000);
	    driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
	    Thread.sleep(5000);
	    driver.findElements(MobileBy.className("android.widget.TextView")).get(1).click();
	    Thread.sleep(5000);
	    driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
	    Thread.sleep(5000);
	  //android.widget.TextView[@content-desc="Accessibility Service"]
	    
	    driver.findElement(MobileBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility Service\"]")).click();
	    Thread.sleep(5000);
	    
	    driver.findElements(MobileBy.className("android.widget.CheckBox")).get(2).click();
	    Thread.sleep(5000);
	    driver.findElements(MobileBy.className("android.widget.CheckBox")).get(4).click();
	    Thread.sleep(5000);
	    driver.findElements(MobileBy.className("android.widget.CheckBox")).get(2).click();
	    Thread.sleep(5000);
	    driver.findElements(MobileBy.className("android.widget.CheckBox")).get(4).click();
	    Thread.sleep(5000);
	    driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
	    Thread.sleep(5000);
	    
	    driver.findElement(MobileBy.AccessibilityId("Accessibility Service")).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(MobileBy.id("android:id/content")).click();
		Thread.sleep(5000);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
	    
		driver.findElement(MobileBy.AccessibilityId("Custom View")).click();
	    Thread.sleep(5000);
	    
	    driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
	    
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
	}
	
	
	@Test(enabled = false)
	public void  animation() throws InterruptedException{
		 driver.findElement(MobileBy.id("com.android.permissioncontroller:id/continue_button")).click();
	     Thread.sleep(5000);
		 driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.AccessibilityId("Bouncing Balls")).click();
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View")).click();
		 Thread.sleep(5000);
		 driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.AccessibilityId("Cloning")).click();
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View")).click();
		 Thread.sleep(5000);
		 driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.AccessibilityId("Hide-Show Animations")).click();
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]")).click();
		 Thread.sleep(5000);
		 driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.AccessibilityId("Seeking")).click();
		 Thread.sleep(5000);
		
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

