package hybrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.ClickAndHoldAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class generalstore {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
		DesiredCapabilities dc =  new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		driver =  new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
	}
	
	@Test(enabled=true)
	public void testcase1() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
	    Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("vandana");
		
	
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(5000);
		//toast message
	    //System.out.println(driver.findElement(MobileBy.xpath("//android.widget.toast[1]")).getText());
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(5000);
		//after adding one product to add to cart then ,second one will become first product and still it will be zero
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(5000);
		// i want u to scroll till converse all star and add the product to the cart
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		String product1=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		Thread.sleep(5000);
		String product2=  driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		Thread.sleep(5000);
		String totalprice=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		product1=product1.substring(1);
		product2=product2.substring(1);
		totalprice=totalprice.substring(1);   
		Double firstproduct=Double.parseDouble(product1);
		Double secondproduct=Double.parseDouble(product2);
		Double totalprice1=Double.parseDouble(totalprice);
		Double total = firstproduct+ secondproduct ;
		  if(totalprice1.equals(total))
		  {
			  System.out.println("cost matching");
		  }
		 else {
				  System.out.println("cost not matching");
			  }
		  
		//Assert.assertEquals(totalprice1, total);
		 System.out.println(firstproduct+secondproduct);
		 driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		 Thread.sleep(5000);
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		  
		  
	   }
	@Test (enabled = false)
	public void shoes() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
	    Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("vandana");
		
	
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(5000);
		 String shoe=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").getText();
        Thread.sleep(3000);
        driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String product= driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        Thread.sleep(3000);
        product=product.substring(1);
        Thread.sleep(3000);
        System.out.println(product);
        Thread.sleep(2000);
        String product1= driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productName")).get(0).getText();
        Thread.sleep(2000);


        
        System.out.println(product1);
        Thread.sleep(2000);
        driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		 Thread.sleep(3000);
		driver.getTitle();
		Thread.sleep(3000);
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        
        
        
        
	}
	
	@Test(enabled=true)
	public void count() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
	    Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("vandana");
		
	
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan Lift Off\"))");
		Thread.sleep(10000);
		int size=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/rvProductList")).size();
		Thread.sleep(3000);
		System.out.println(size);
		for (int i =0;i<size;i++)
		{
			
		String van=driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		System.out.println(van);
		Thread.sleep(3000);
		System.out.println(van);
		if(van.equalsIgnoreCase("Jordan Lift Off"))
		{Thread.sleep(3000);
			driver.findElementByAndroidUIAutomator("text(\"Face recognition • Fingerprints\")").click();
			Thread.sleep(3000);
			break;
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
