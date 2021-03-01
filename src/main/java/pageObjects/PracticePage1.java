package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage1 {
	
	public WebDriver driver;

	private By RadioButtonExample=By.xpath("//body/div[1]/div[1]/fieldset[1]/legend[1]");
	private By Radio1=By.cssSelector("input[value='radio1']");
	private By Radio2=By.cssSelector("input[value='radio2']");
	private By Radio3=By.cssSelector("input[value='radio3']");
	private By SuggestionClassExample=By.xpath("//body/div[1]/div[2]/fieldset[1]/legend[1]");
	private By SuggestionClassTextBox=By.id("autocomplete");
	private By DropDownExample=By.xpath("//body/div[1]/div[3]/fieldset[1]/legend[1]");
	private By SelectDropDown=By.id("dropdown-class-example");
	private By CheckBoxExample=By.xpath("//body/div[1]/div[4]/fieldset[1]/legend[1]");
	private By CheckBoxOption1=By.id("checkBoxOption1");
	private By CheckBoxOption2=By.id("checkBoxOption2");
	private By CheckBoxOption3=By.id("checkBoxOption3");
	
	public PracticePage1(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getRadioButtonExample()
	{
		return driver.findElement(RadioButtonExample);
		
	}
	
	public WebElement getRadio1()
	{
		return driver.findElement(Radio1);
		
	}

	
	public WebElement getRadio2()
	{
		return driver.findElement(Radio2);
		
	}
	
	public WebElement getRadio3()
	{
		return driver.findElement(Radio3);
		
	}
	
	public WebElement getSuggestionClass()
	{
		return driver.findElement(SuggestionClassExample);
		
	}
	
	public WebElement getSuggestionClassTextBox()
	{
		return driver.findElement(SuggestionClassTextBox);
		
	}
	
	

	public WebElement getDropDownExample()
	{
		return driver.findElement(DropDownExample);
		
	}
	
	public WebElement getSelectDropDown()
	{
		return driver.findElement(SelectDropDown);
		
	}
	
	public WebElement getCheckBoxExample()
	{
		return driver.findElement(CheckBoxExample);
		
	}
	
	public WebElement getCheckBoxOption1()
	{
		return driver.findElement(CheckBoxOption1);
		
	}
	
	public WebElement getCheckBoxOption2()
	{
		return driver.findElement(CheckBoxOption2);
		
	}
	
	public WebElement getCheckBoxOption3()
	{
		return driver.findElement(CheckBoxOption3);
		
	}
	
}
