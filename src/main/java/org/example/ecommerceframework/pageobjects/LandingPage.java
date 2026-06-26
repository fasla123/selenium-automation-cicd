package org.example.ecommerceframework.pageobjects;

import org.example.ecommerceframework.abstractcomponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
	    super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(className= "btn-block")
	WebElement login;
	@FindBy(css= ".ng-animating")
	WebElement errorMessage;
	
	 public void goTo() {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
	 
	 public ProductCatalogue loginApplication(String email, String pswd) {
		 userEmail.sendKeys(email);
		 password.sendKeys(pswd);
		 login.click();
		 return new ProductCatalogue(driver);
	 }
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();	}

}
