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

public class validateWebTable extends base {

	public WebDriver driver;
	public PracticePage3 pg3;

	private static Logger Log = LogManager.getLogger(validateWebTable.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		pg3 = new PracticePage3(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized for 'validateRadioButtons' class");

	}

	@Test

	// Validates WebTable title
	public void checkWebTableText() throws IOException {


		String WebTableText = pg3.getWebTableExample().getText();
		Assert.assertEquals("Web Table Example", WebTableText);
		Log.info("WebTable text is validated successfully");

	}

	@Test

	// Validates heading of the table
	public void validateWebTableHeaders() {
      
		for(int i=0;i<pg3.getWebTableHeaders().size();i++)
		{
			String Headings=pg3.getWebTableHeaders().get(i).getText();
			System.out.println(Headings);
		}

		Assert.assertTrue(pg3.getWebTableHeaders().get(0).getText().equalsIgnoreCase("Instructor"));
		Assert.assertTrue(pg3.getWebTableHeaders().get(1).getText().equalsIgnoreCase("course"));
		Assert.assertTrue(pg3.getWebTableHeaders().get(2).getText().equalsIgnoreCase("price"));

	}
	
	@Test

	// Validates WebTable RowCount
	public void checkWebTableRowCount() throws IOException {
		
		int rowCount=pg3.getWebTableRowCount();
		Assert.assertEquals(rowCount, 11);
		
		
	}
	
	@Test

	// Validates WebTable ColCount
	public void checkWebTableColCount() throws IOException {
		
		int ColCount=pg3.getWebTableColCount();
		Assert.assertEquals(ColCount,3);
			
	}


	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
