package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PagesBase;

public class JobSearchPage extends PagesBase{
	
	@FindBy(id="application_status_head_container")
	public WebElement totalJobWebElement;
	
	@FindBy(name= "submit")
	public WebElement JobSearchButton;

}
