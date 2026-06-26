package org.example.ecommerceframework.tests;

import java.io.IOException;
import java.util.HashMap;

import org.example.ecommerceframework.pageobjects.CheckOutPage;
import org.example.ecommerceframework.pageobjects.ConfirmationPage;
import org.example.ecommerceframework.pageobjects.OrdersPage;
import org.example.ecommerceframework.pageobjects.ProductCartPage;
import org.example.ecommerceframework.pageobjects.ProductCatalogue;
import org.example.ecommerceframework.testcomponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Regression"})
	public void submitOrderTest(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(input);
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		productCatalogue.addProductTocart(input.get("productName"));
		ProductCartPage productCart = productCatalogue.goToCartPage();
		Boolean match = productCart.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match, "Product not found");
		CheckOutPage checkOutPage = productCart.goToCheckOutPage();
		checkOutPage.selectCountry(input.get("country"));
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String msg = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));

	}
	
	@Test(dependsOnMethods= {"submitOrderTest"})
	public void verifyProuctOnOrdersPage() {
		landingPage.loginApplication("mpu.fasla@gmail.com", "Fasla@1998");
		OrdersPage orderPage = new OrdersPage(BaseTest.getDriver());
		Assert.assertTrue(orderPage.verifyProducOrdered(productName));
	}
 @DataProvider
 public Object[][] getData() {
	 HashMap<String,String> map= new HashMap<String,String>();
	 map.put("email", "mpu.fasla@gmail.com");
	 map.put("password", "Fasla@1998");
	 map.put("productName", "ZARA COAT 3");
	 map.put("country", "India");
	 HashMap<String,String> map1= new HashMap<String,String>();
	 map1.put("email", "fasla@gmail.com");
	 map1.put("password", "Ummul@123");
	 map1.put("productName", "ADIDAS ORIGINAL");
	 map1.put("country", "India");
	 return new Object[][] {{map},{map1}};
 }
}
