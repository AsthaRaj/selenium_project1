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

public class validateWebTableFixedHeader extends base {

	public WebDriver driver;
	public PracticePage3 pg3;

	private static Logger Log = LogManager.getLogger(validateWebTableFixedHeader.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		pg3 = new PracticePage3(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized for 'validateRadioButtons' class");

	}

	@Test

	// Validates WebTableFixedHeader title
	public void checkWebTableFixedHeaderText() throws IOException {

		String WebTableFixedHeaderText = pg3.getWebTableFixHeader().getText();
		Assert.assertEquals("Web Table Fixed header", WebTableFixedHeaderText);
		Log.info("WebTable Fixed Header text is validated successfully");

	}

	@Test

	// Validates heading of the table
	public void validateWebTableFixedHeaders() {

		for (int i = 0; i < pg3.getWebTableFixHeaderHeadings().size(); i++) {
			String Headings = pg3.getWebTableFixHeaderHeadings().get(i).getText();
			System.out.println(Headings);
		}

		Assert.assertTrue(pg3.getWebTableFixHeaderHeadings().get(0).getText().equalsIgnoreCase("Name"));
		Assert.assertTrue(pg3.getWebTableFixHeaderHeadings().get(1).getText().equalsIgnoreCase("Position"));
		Assert.assertTrue(pg3.getWebTableFixHeaderHeadings().get(2).getText().equalsIgnoreCase("City"));
		Assert.assertTrue(pg3.getWebTableFixHeaderHeadings().get(3).getText().equalsIgnoreCase("Amount"));

	}

	@Test

	// Validates WebTable RowCount
	public void checkWebTableFixedHeaderRowCount() throws IOException {

		int rowCount = pg3.getWebTableFixedHeaderRowCount();
		Assert.assertEquals(rowCount, 9);

	}

	@Test

	// Validates WebTable ColCount
	public void checkWebTableFixedHeaderColCount() throws IOException {

		int ColCount = pg3.getWebTableFixedHeaderColCount();
		Assert.assertEquals(ColCount, 4);

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
