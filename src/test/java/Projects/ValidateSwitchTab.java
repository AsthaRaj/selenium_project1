package Projects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.graph.ElementOrder.Type;

import Resources.base;
import pageObjects.PracticePage2;

public class ValidateSwitchTab extends base {

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
	// Validates Switch Window text displayed correctly or not
	public void checkswitchWindowText() throws IOException {

		String SwitchTabText = pg2.getSwitchTabExample().getText();
		System.out.println(SwitchTabText);
		Assert.assertEquals("Switch Tab Example", SwitchTabText);
		Log.info("Switch Tab text is validated successfully");

	}

	@Test
	// Validates if Switch Tab button working properly or not
	public void checkSwitchTab() throws IOException, InterruptedException {

		pg2.getOpenTab().click();

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
				&& ChildURL.equalsIgnoreCase("https://www.rahulshettyacademy.com/#/index"));

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
