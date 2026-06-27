package org.example.ecommerceframework.tests;

import java.io.IOException;

import org.example.ecommerceframework.pageobjects.ProductCartPage;
import org.example.ecommerceframework.pageobjects.ProductCatalogue;
import org.example.ecommerceframework.testcomponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.ecommerceframework.testcomponents.Retry;

public class ErrorValidationTest extends BaseTest {
	@Test(groups = {"ErrorValidation"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		//comments are added

		landingPage.loginApplication("mpu.fasla@gmail.com", "Fasla@123");

		Assert.assertTrue(landingPage.getErrorMessage().equalsIgnoreCase("incorrect email or password."));
	}

	@Test(groups = {"ErrorValidation"})
	public void productErrorValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("mpu.fasla@gmail.com", "Fasla@1998");
		productCatalogue.addProductTocart(productName);
		ProductCartPage productCart = productCatalogue.goToCartPage();
		Boolean match = productCart.verifyProductDisplay("zara coat 3");
    	Assert.assertFalse(match);

	}
	}

