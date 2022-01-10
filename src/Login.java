import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Login {

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
		
		
	}

}
