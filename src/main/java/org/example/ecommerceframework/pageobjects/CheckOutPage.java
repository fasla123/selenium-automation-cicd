package org.example.ecommerceframework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css ="[placeholder*='Country']")
	WebElement countrySelect;
	@FindBy(css= ".action__submit ")
	WebElement submit;
	
	By countryOptions =By.cssSelector("section .ta-item");

	public void selectCountry(String country) {
		Actions a = new Actions(driver);
		a.moveToElement(countrySelect).click().sendKeys(country)
				.build().perform();
		List<WebElement> options = driver.findElements(countryOptions);
		WebElement countryToBeSelected = options.stream().filter(o -> o.getText().equals(country)).findFirst()
				.orElseThrow(() -> new RuntimeException("Product not found"));
		countryToBeSelected.click();
	}
    public ConfirmationPage submitOrder() {
    	submit.click();
    	return new ConfirmationPage(driver);
    	
    }
}
