 package testng;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo {
@BeforeSuite
public void beforesuite() {
	System.out.println("before setup if i want to run anything then i can use beforesuite if required");
}
@BeforeTest
public void beforetest() {
	///System.out.println("this is sunil");
}
@Test(priority = 0, enabled = true)
public void apple() {
	String expectedresult="sunil";
	String actualresult="sunil";
//	if (expectedresult.equalsIgnoreCase(actualresult))
//	{
//		System.out.println("pass");
//	}
	Assert.assertEquals(expectedresult, actualresult);
	System.out.println("this is sunil");
}
@Test(priority = 1, dependsOnMethods = "apple", alwaysRun = true)//enabled true
public void cherry() {
	System.out.println("this is vidya");
}
@Test(priority = 2, enabled = true)
public void mango() {
	System.out.println("this is vandana");
}
@AfterTest
public void aftertest() {
	//System.out.println("this is vandana");
}
}
