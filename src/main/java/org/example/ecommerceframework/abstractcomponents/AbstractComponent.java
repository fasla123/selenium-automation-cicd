package org.example.ecommerceframework.abstractcomponents;

import java.time.Duration;

import org.example.ecommerceframework.pageobjects.ProductCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	@FindBy(xpath = "//button[contains(@routerlink, 'cart')]")
	WebElement cart;

	public ProductCartPage goToCartPage() {
		cart.click();
		return new ProductCartPage(driver);
	}

	public void waitForElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
   public void waitForWebElementToAppear(WebElement msg) {
	   wait.until(ExpectedConditions.visibilityOf(msg));
	
}
	public void waitForElementToDisappear(WebElement find) {
		wait.until(ExpectedConditions.invisibilityOf(find));
	}
	public void waitToDisappear(By toastBy){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastBy));
		
	}
	

}
