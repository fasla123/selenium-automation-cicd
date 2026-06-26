package org.example.ecommerceframework.pageobjects;



import java.util.List;

import org.example.ecommerceframework.abstractcomponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCartPage extends AbstractComponent{
	
	WebDriver driver ;
	public ProductCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		return match;
	}
   public CheckOutPage goToCheckOutPage() {
	   checkout.click();
	   return new CheckOutPage(driver);
	   
   }
	
	

}
