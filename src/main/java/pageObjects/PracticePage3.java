package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage3 {

	public WebDriver driver;

	private By WebTableExample = By.xpath("//body/div[3]/div[1]/fieldset[1]/legend[1]");
	private By ElementDisplayedExample = By.xpath("//body/div[3]/div[2]/fieldset[1]/legend[1]");
	private By Hide = By.id("hide-textbox");
	private By Show = By.id("show-textbox");
	private By DisplayedTextBox = By.id("displayed-text");
	private By WebTableFixHeader = By.xpath("//body/div[3]/div[2]/fieldset[2]/legend[1]");
	private By WebTableHeaders = By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr/th");
	private By WebTableRowCount = By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr");
	private By WebTableColCount = By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr[2]/td");
	private By WebTableFixHeaderHeadings = By.xpath("//div[@class='tableFixHead']/table/thead/tr/th");
	private By WebTableFixedHeaderRowCount = By.xpath("//div[@class='tableFixHead']/table/tbody/tr");
	private By WebTableFixedHeaderColCount = By.xpath("//div[@class='tableFixHead']/table/tbody/tr[2]/td");

	public PracticePage3(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWebTableExample() {
		return driver.findElement(WebTableExample);

	}

	public WebElement getElementDisplayedExample() {
		return driver.findElement(ElementDisplayedExample);

	}

	public WebElement getHide() {
		return driver.findElement(Hide);

	}

	public WebElement getShow() {
		return driver.findElement(Show);

	}

	public WebElement getDisplayedTextBox() {
		return driver.findElement(DisplayedTextBox);

	}

	public WebElement getWebTableFixHeader() {
		return driver.findElement(WebTableFixHeader);

	}

	public List<WebElement> getWebTableHeaders() {
		return driver.findElements(WebTableHeaders);

	}

	public int getWebTableRowCount() {
		return driver.findElements(WebTableRowCount).size();

	}

	public int getWebTableColCount() {
		return driver.findElements(WebTableColCount).size();

	}

	public List<WebElement> getWebTableFixHeaderHeadings() {
		return driver.findElements(WebTableFixHeaderHeadings);

	}

	public int getWebTableFixedHeaderRowCount() {
		return driver.findElements(WebTableFixedHeaderRowCount).size();

	}

	public int getWebTableFixedHeaderColCount() {
		return driver.findElements(WebTableFixedHeaderColCount).size();

	}
}
