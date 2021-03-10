package Projects;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;

import pageObjects.PracticePage1;
import pageObjects.PracticePage2;
import pageObjects.PracticePage3;
import pageObjects.PracticePage5;

public class validateFrame extends base {

	public WebDriver driver;
	public PracticePage5 pg5;

	private static Logger Log = LogManager.getLogger(validateFrame.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		pg5 = new PracticePage5(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized for 'validateRadioButtons' class");

	}

	@Test

	// Validates WebTable title
	public void checkFrameText() throws IOException {

		String FrameText = pg5.getFrameExample().getText();
		Assert.assertEquals("iFrame Example", FrameText);
		Log.info("Frame text is validated successfully");

	}

	@Test

	// Validates Frames
	public void checkFrames() throws IOException, InterruptedException {

		driver.switchTo().frame("courses-iframe");
		Thread.sleep(4000L);

		try {
			Assert.assertEquals(true, pg5.getText().isDisplayed());
		} catch (NoSuchElementException e) {
			System.out.println("Element is not present");
		}
		WebElement ele = pg5.getPracticeProject();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
		Assert.assertTrue(pg5.getText().isDisplayed(), "Element is present");

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
