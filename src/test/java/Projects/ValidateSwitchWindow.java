package Projects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.PracticePage2;

public class ValidateSwitchWindow extends base {

	public WebDriver driver;
	public PracticePage2 pg2;

	private static Logger Log = LogManager.getLogger(ValidateDropDownExample.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		pg2 = new PracticePage2(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized for 'ValidateSuggestionClass' class");

	}

	@Test

	public void checkswitchWindowText() throws IOException {
		
		
		String SwitchWindowText = pg2.getSwitchWindowExample().getText();
		Assert.assertEquals("Switch Window Example", SwitchWindowText);
		Log.info("Switch Window text is validated successfully");

	}

	@Test

	public void checkSwitchWindow() throws IOException {
		
		

		pg2.getOpenWindow().click();

		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		String ParentURL = driver.getCurrentUrl();
		System.out.println(ParentURL);
		driver.switchTo().window(ChildID);
		String ChildURL = driver.getCurrentUrl();
		System.out.println(ChildURL);
		driver.switchTo().window(ParentID);
		Assert.assertTrue(ParentURL.equalsIgnoreCase("https://rahulshettyacademy.com/AutomationPractice/")
				&& ChildURL.equalsIgnoreCase("http://www.qaclickacademy.com/"));

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
