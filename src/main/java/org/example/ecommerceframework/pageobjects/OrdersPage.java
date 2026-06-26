package org.example.ecommerceframework.pageobjects;

import java.util.List;

import org.example.ecommerceframework.abstractcomponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends AbstractComponent {
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

    @FindBy( css= "[routerlink=\"/dashboard/myorders\"]")
    WebElement orders;
    @FindBy(xpath="//tr/td[2]")
    List<WebElement> ordersList;
   
    public List<WebElement> getOrderedProducts() {
 //	waitForWebElementToAppear(orders);
    	orders.click();
    	return ordersList;
    }
    
    public Boolean verifyProducOrdered(String productName) {
    	Boolean present=getOrderedProducts().stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
    	return present;
    }
    	




}