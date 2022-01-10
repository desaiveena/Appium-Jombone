import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class JMB_017 {

	public static void main(String[] args) throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("Automation_Name", "Appium");
		dc.setCapability("Platform_Name","Android");
		dc.setCapability("Platform_Version", 12.0);
		dc.setCapability("Device_Name", "Android Emulator");
		dc.setCapability("app","/Users/veenadesai/Desktop/BusyQA/Co-op-week-3-Dec13/jombone-debug.apk");
		dc.setCapability("appPackage", "com.jombone.jombone");
		dc.setCapability("appActivity", "com.jombone.jombone.activities.SplashActivity");
		URL url = new URL("http://localhost:4723/wd/hub");
		

		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
		driver.installApp("/Users/veenadesai/Desktop/BusyQA/Co-op-week-3-Dec13/jombone-debug.apk");

		driver.launchApp();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Login
		
		driver.findElement(By.id("com.jombone.jombone:id/tvLoginSignUp")).click();
		driver.findElement(By.id("com.jombone.jombone:id/edLoginEmail")).sendKeys("iteach.veena@gmail.com");
		
		driver.findElement(By.id("com.jombone.jombone:id/edLoginPassword")).sendKeys("Bananamuffin123");
		driver.findElement(By.id("com.jombone.jombone:id/email_sign_in_button")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//After logging in
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[3]")).click();
		
		//click on the profile picture
		driver.findElement(By.id("com.jombone.jombone:id/profile_image")).click();
		
		//click on the edit icon
		
		driver.findElement(By.id("com.jombone.jombone:id/editPersonalDetails")).click();
		
		// find the dropdown using xpath
		WebElement dropdownElement = driver.findElement(By.id("com.jombone.jombone:id/highestEducation"));
				
		// create object for Select class
		Select dropdown = new Select(dropdownElement);
		
		// select 1st option from the dropdown options
		dropdown.selectByValue("primary school");
		dropdown.equals("primary school");
	}
}

