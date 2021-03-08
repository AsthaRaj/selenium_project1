package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage4 {

	public WebDriver driver;

	private By MouseHoverExample = By.xpath("//body/div[4]/div/fieldset/legend");
	private By MouseHoverButton = By.xpath("//body/div[4]/div/fieldset/div[1]/button");
	private By MouseHoverButtonContentTop = By.linkText("Top");
	private By MouseHoverButtonContentReload = By.linkText("Reload");

	public PracticePage4(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMouseHoverExample() {
		return driver.findElement(MouseHoverExample);

	}

	public WebElement getMouseHoverButton() {
		return driver.findElement(MouseHoverButton);

	}

	public WebElement getMouseHoverButtonContentTop() {
		return driver.findElement(MouseHoverButtonContentTop);

	}

	public WebElement getMouseHoverButtonContentReload() {
		return driver.findElement(MouseHoverButtonContentReload);

	}

}
