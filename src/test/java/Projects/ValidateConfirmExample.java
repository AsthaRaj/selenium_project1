package Projects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.PracticePage2;

public class ValidateConfirmExample extends base {

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
	// Validating alert getting accepted successfully or not
	public void checkConfirmAccept() {

		pg2.getConfirmButton().click();
		String ConfirmText = driver.switchTo().alert().getText();

		Assert.assertEquals("Hello , Are you sure you want to confirm?", ConfirmText);
		driver.switchTo().alert().accept();

		try {
			driver.switchTo().alert();
			System.out.println("Alert is not accepted successfully");
		} catch (NoAlertPresentException ex) {
			System.out.println("Alert is accepted successfully");
		}
	}

	@Test
	// Validating alert getting accepted successfully or not
	public void checkConfirmDismiss() {

		pg2.getConfirmButton().click();
		String ConfirmText = driver.switchTo().alert().getText();

		Assert.assertEquals("Hello , Are you sure you want to confirm?", ConfirmText);
		driver.switchTo().alert().dismiss();

		try {
			driver.switchTo().alert();
			System.out.println("Alert is not dismissed successfully");
		} catch (NoAlertPresentException ex) {
			System.out.println("Alert is dismissed successfully");
		}
	}


	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
