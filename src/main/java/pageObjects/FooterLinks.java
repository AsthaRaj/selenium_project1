package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterLinks {

	public WebDriver driver;

	private By footerdriver = By.id("gf-BIG");
	private By Column1Driver= By.xpath("//table[@class='gf-t']/tbody/tr/td[1]");
	private By footerdriverLinksAttribute = By.xpath("//li[@class='gf-li']/a");

//	private By FrameID= By.id("courses-iframe");
//	private By Text=By.xpath("//*[text()='Join now to Practice']");

	public FooterLinks(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getfooterDriver() {
		return driver.findElement(footerdriver);

	}

	public WebElement getColumn1Driver() {
		return driver.findElement(Column1Driver);

	}

	public List<WebElement> getfooterdriverLinksAttribute() {
		return driver.findElements(footerdriverLinksAttribute);

	}
//	public WebElement getText() {
//		return driver.findElement(Text);
//
//	}

}
