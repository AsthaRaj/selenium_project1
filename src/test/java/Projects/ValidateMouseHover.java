package Projects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.PracticePage1;
import pageObjects.PracticePage2;
import pageObjects.PracticePage4;

public class ValidateMouseHover extends base {

	public WebDriver driver;
	public PracticePage4 pg4;
	private static Logger Log = LogManager.getLogger(ValidateDropDownExample.class.getName());

	@BeforeTest
	//Initializing driver
	public void startup() throws IOException {
		driver = initializeDriver();
		pg4 = new PracticePage4(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized for 'ValidateSuggestionClass' class");

	}

	@Test
    //Validate Mouse Hover Text
	public void checkMouseHoverText() throws IOException {

		String MouseHoverText = pg4.getMouseHoverExample().getText();
		Assert.assertEquals("Mouse Hover Example", MouseHoverText);
		Log.info("Mouse Hover text is validated successfully");

	}

	@Test
    //Validate Mouse Hover Button and it's both options(Top and Reload)
	public void checkMouseHoverButton() throws IOException, InterruptedException {

		Actions a = new Actions(driver);
		a.moveToElement(pg4.getMouseHoverButton()).click().build().perform();
		pg4.getMouseHoverButtonContentTop().click();
		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("top"));
		a.moveToElement(pg4.getMouseHoverButton()).click().build().perform();
		pg4.getMouseHoverButtonContentReload().click();
		String URL1 = driver.getCurrentUrl();
		Assert.assertFalse(URL1.contains("top"));

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
