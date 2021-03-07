package Projects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.PracticePage2;

public class ValidateScroll extends base {

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
	public void checkScrollWindow() throws InterruptedException {

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(3000L);
		js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=5000");
	}

}
