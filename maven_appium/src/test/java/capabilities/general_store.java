package capabilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class general_store {
AndroidDriver<AndroidElement>driver;
@BeforeTest
public void bt() throws MalformedURLException {
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8TA00DGFT");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C://Users//hp//Downloads//chromedriver.exe");
	//dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
	driver =new AndroidDriver<AndroidElement>(new URL ("https://0.0.0.0:4723"),dc);
	
	
}



















}
