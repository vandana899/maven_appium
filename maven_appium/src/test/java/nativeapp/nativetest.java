 package nativeapp;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
//static for time
import static java.time.Duration.ofSeconds;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;

//add an import
import static io.appium.java_client.touch.TapOptions.tapOptions;
//add import for elements
import static io.appium.java_client.touch.offset.ElementOption.element;
// for longpress
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
public class nativetest extends capability {
	//if i want the driver in the class level then it will be applicable for all the methods within the class
	//remember android driver is a class and android element is also a class for the  specific element
	// driver is a variable which knows that he has to interact with the android driver and android element
	// we will use driver in the codes which will define that by the use of android driver we'll click on android element 
AndroidDriver<AndroidElement> driver;
@BeforeTest
public void bt() throws MalformedURLException {
	
	driver= capabilities();
	//if u want to wait for any particular element then u can apply wait there
	//basically in my test method if any line is taking time to click then we use this because app can take time to open that particular element
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
@Test
public void test() {
	//System.out.println("opened");
	// first we'll work with preference element: we'll perform, some actions on this element.
	// i want to click on this element
	driver.findElement(MobileBy.AccessibilityId("Preference")).click();
	driver.findElement(MobileBy.AccessibilityId("Preference dependencies")).click();
	//locator id belongs to selenium webdriver
	driver.findElement(By.id("android.idcheckbox")).click();
	driver.findElement(By.xpath("*//[@text='Wifi Settings']")).click();
	//another way of using text which you can follow easily is 
	//if you are using android UIAutomator to identify an element using an attribute ,then you can
	//use the UiSelector method for selecting the attribute
	driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi Settings\")")).click();
	//when you have edit field then use sendkeys
	driver.findElement(MobileBy.className("")).sendKeys("Sunil");
	driver.hideKeyboard();
	//when you have two elements with same class name then you have to use index values and use elements
	//when you want to click on first element...then we use particular index value
	driver.findElements(By.className("")).get(0).click();
	//if you want to go back to the previous screen
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	//again if you want to go back then again use this line of code
	driver.pressKey(new KeyEvent(AndroidKey.BACK));	
}

@Test
public void testcase3() {
	// if you want to open the notifications then
	driver.openNotifications();
	//task for you is to click on battery saver...first enable battery saver and then disable battery saver 
	System.out.println("task done");
	//driver.pressKey(new KeyEvent(AndroidKey.BACK));
}

@Test
public void testcase4() {
	//what we will do here is scrolling in the mobile application
	//first go to the views and click on views
	driver.findElement(MobileBy.AccessibilityId("views")).click();
	//now you have to scroll you need three things
	//UIAutomator//UiSelector//UiScrollable
	// if u want to scroll to a particular element then u use scrollIntoView
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");	
}

@Test
public void testcase5() {
	driver.findElement(MobileBy.AccessibilityId("views")).click();
	//to check that the elements are present and clickable we will store into an android element if someone asks u then u need to write just clickable true
	 AndroidElement clickable= driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
	 //Similarly if u want to get the size then i will use dimension
	org.openqa.selenium.Dimension count= clickable.getSize();
	System.out.println(count);
}

@Test
public void testcase6() { //tap  //gestures
	//you can also write code like this
	driver.findElementByAndroidUIAutomator("text(\"Views\")");
	// gestures
	AndroidElement el=driver.findElement(MobileBy.AccessibilityId("Expandable Lists"));
	//here i am trying to identify an element and storing it in a variable
	
	TouchAction ta= new TouchAction(driver);
	// you have to import the tapoption and 
	ta.tap(tapOptions().withElement(element(el))).perform();
	 driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
    AndroidElement lp= driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
	//ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
    //import static
	ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
	
	
}
@Test
public void scroll()
{
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	driver.findElementByAccessibilityId("new Uiscrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
	driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.BACK));
}
@Test(enabled = false)
public void swipeactions()            //task
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
public void draganddrop() throws InterruptedException          //task print custom sample menu and sample action
{	driver.findElement(MobileBy.id("com.android.permissioncontroller:id/continue_button")).click();
    Thread.sleep(5000);
	driver.findElement(MobileBy.AccessibilityId("Views")).click();
	Thread.sleep(5000);
	driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
	Thread.sleep(5000);
	AndroidElement ele1= driver.findElements(MobileBy.className("android.view.View")).get(0);
	System.out.println(ele1);
	AndroidElement ele2= driver.findElements(MobileBy.className("android.view.View")).get(1);
	System.out.println(ele2);
	TouchAction ta= new TouchAction(driver);
	ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	
	 //task print custom sample menu and sample action
//	driver.findElement(MobileBy.AccessibilityId("Views")).click();
//	Thread.sleep(5000);
//	driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
//	Thread.sleep(5000);
//	String ele4= driver.findElements(MobileBy.className("android.view.View")).get(0).getText();
//	System.out.println(ele4);
//	String ele5= driver.findElements(MobileBy.className("android.view.View")).get(1).getText();
//	System.out.println(ele5);
}
@Test(enabled = true)
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
	
	 
}//in real time if i am working in one application and i want to switch to the other application to copy some data and come back here
//how can i do this
@Test
public void oneapptoanother() throws InterruptedException {
	driver.findElement(MobileBy.AccessibilityId("OS")).click();
	driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
	driver.findElement(MobileBy.AccessibilityId("Enable SMS Broadcast receiver")).click();
	driver.findElement(By.id("gcuhwdukch")).sendKeys("recepient number(555)521-5554");
	driver.findElement(By.id("gcuhwdukch")).sendKeys("send message");
	driver.hideKeyboard();
	driver.findElement(MobileBy.AccessibilityId("Send")).click();
//	driver.openNotifications();
//	String text=driver.findElement(By.id("fytfh")).getText();
//	System.out.println(text);
	// best way of doing is switching to the app
	//activate other app by giving that particular app package name
	Thread.sleep(9000);
	driver.activateApp("com.google.android.apps.messaging");
	//instead of going inside the message take text directly
	//for getting the text there use id and store it in a string to print the value
	String msgtext=driver.findElement(By.id("gcuhwdukch")).getText();
	System.out.println(msgtext);
	Thread.sleep(9000);
	//again switching back to api demos...use app package
	driver.activateApp("com.google.android.apps");
	//i want all of u to explore it...what is this app swtich
	driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}