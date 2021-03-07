package Projects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.PracticePage1;
import pageObjects.PracticePage2;

public class ValidateDropDownExample extends base {

	public WebDriver driver;
	public PracticePage1 pg1;

	private static Logger Log = LogManager.getLogger(ValidateDropDownExample.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		pg1 = new PracticePage1(driver);
		Log.info("Driver is initialized for 'ValidateSuggestionClass' class");

	}

	@Test
	// Validates DropDown Title
	public void checkDropDownText() throws IOException {

		driver.get(prop.getProperty("url"));
		pg1 = new PracticePage1(driver);

		String DropDownText = pg1.getDropDownExample().getText();

		System.out.println(DropDownText);

	}

	@Test
	// Validates if dropdowns are getting sellected correctly
	public void checkDropDown() throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		pg1 = new PracticePage1(driver);

		Select s = new Select(pg1.getSelectDropDown());

		s.selectByVisibleText("Option2");

		WebElement option = s.getFirstSelectedOption();
		String selectedName = option.getText();

		Assert.assertTrue(selectedName.equalsIgnoreCase("Option2"));

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
