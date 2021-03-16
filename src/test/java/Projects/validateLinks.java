package Projects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.base;
import pageObjects.FooterLinks;

public class validateLinks extends base {

	public WebDriver driver;
	public FooterLinks fl;
	int footerLinksCount;
	int Column1LinksCount;

	private static Logger Log = LogManager.getLogger(validateLinks.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		fl = new FooterLinks(driver);
		Log.info("Driver is initialized for 'validateRadioButtons' class");

	}

	@Test

	// Validates links count
	public void checkLinksCount() throws IOException {

		footerLinksCount = fl.getfooterDriver().findElements(By.tagName("a")).size();
		Column1LinksCount = fl.getColumn1Driver().findElements(By.tagName("a")).size();

	}

	@Test

	// Validates if footer links are working fine
	public void validateFooterLinksAttribute() throws MalformedURLException, IOException {
		List<WebElement> links = fl.getfooterdriverLinksAttribute();

		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int RespCode = conn.getResponseCode();
			System.out.println(RespCode);
			a.assertTrue(RespCode < 400,
					"the link" + " " + link.getText() + "is broken with response code=" + RespCode);
		}

		a.assertAll();

	}

	@Test

	// Validates if links of column 1 is working fine
	public void validateColumn1Links() {

		for (int i = 1; i < footerLinksCount; i++) {
			String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			fl.getfooterDriver().findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
		}
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String ParentID = it.next();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getCurrentUrl());
		}
		driver.switchTo().window(ParentID);

	}

	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
