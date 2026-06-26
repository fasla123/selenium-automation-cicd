package org.example.ecommerceframework.pageobjects;

import org.example.ecommerceframework.abstractcomponents.AbstractComponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{ 
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".card-body")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By find = By.cssSelector(".card-body");
	By productCart = By.cssSelector("button:last-of-type");
	By toast = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(find);
		return products;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod =getProductList().stream().filter(product -> product.findElement(By.cssSelector("h5 b")).getText().equals(productName)).findFirst().orElseThrow(() -> new RuntimeException("product not found:"+ productName));
		return prod;
	}
	public void addProductTocart(String productName) throws InterruptedException {
		getProductByName(productName).findElement(productCart).click();
		//waitForElementToDisappear(spinner);
		waitForElementToAppear(toast);
		Thread.sleep(1000);
		
	}

}
