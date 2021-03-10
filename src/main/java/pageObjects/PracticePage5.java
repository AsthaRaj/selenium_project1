package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage5 {

	public WebDriver driver;

	private By FrameExample = By.xpath("//body/div[5]/fieldset/legend");
	private By PracticeProject = By.linkText("Practice Projects");
	private By FrameID= By.id("courses-iframe");
	private By Text=By.xpath("//*[text()='Join now to Practice']");

	public PracticePage5(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFrameExample() {
		return driver.findElement(FrameExample);

	}

	public WebElement getPracticeProject() {
		return driver.findElement(PracticeProject);

	}
	
	public WebElement getFrameID() {
		return driver.findElement(FrameID);

	}
	
	public WebElement getText() {
		return driver.findElement(Text);

	}

}
