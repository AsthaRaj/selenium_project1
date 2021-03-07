package Projects;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;

import pageObjects.PracticePage1;
import pageObjects.PracticePage2;
import pageObjects.PracticePage3;

public class validateElementsDisplayed extends base {

	public WebDriver driver;
	public PracticePage3 pg3;

	private static Logger Log = LogManager.getLogger(validateElementsDisplayed.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		pg3 = new PracticePage3(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized for 'validateRadioButtons' class");

	}

	@Test

	// Validates ElementDiaplayed Example Text
	public void checkElementDisplayedText() throws IOException {

		String ElementDisplayedText = pg3.getElementDisplayedExample().getText();
		Assert.assertEquals("Element Displayed Example", ElementDisplayedText);
		Log.info("Element Displayed Example  text is validated successfully");

	}

	@Test

	// Validates hide button
	public void validateHideButton() {

		pg3.getHide().click();
		Assert.assertFalse(pg3.getDisplayedTextBox().isDisplayed());

	}

	@Test

	// Validates show button
	public void validateShowButton() {

		pg3.getShow().click();
		Assert.assertTrue(pg3.getDisplayedTextBox().isDisplayed());
		pg3.getDisplayedTextBox().sendKeys("Astha");
		String textValue = pg3.getDisplayedTextBox().getAttribute("value");
		Assert.assertEquals(textValue, "Astha");

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
