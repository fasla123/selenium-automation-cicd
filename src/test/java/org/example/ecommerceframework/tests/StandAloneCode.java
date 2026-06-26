package org.example.ecommerceframework.tests;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub//
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("userEmail")).sendKeys("mpu.fasla@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Fasla@1998");
		driver.findElement(By.className("btn-block")).click();
		String productName = "ZARA COAT 3";
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		WebElement prod =products.stream().filter(product -> product.findElement(By.cssSelector("h5 b")).getText().equals(productName)).findFirst().orElseThrow(() -> new RuntimeException("product not found:"+ productName));
		prod.findElement(By.cssSelector("button:last-of-type")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[contains(@routerlink, 'cart')]")).click();
		List<WebElement> cartProducts= driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		Assert.assertTrue(match, "Product not found");
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("[placeholder*='Country']"))).click().sendKeys("India").build().perform();
		List<WebElement> options = driver.findElements(By.cssSelector("section .ta-item"));
		WebElement country=options.stream().filter(o -> o.getText().equals("India")).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
		country.click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		
		
		
		
		
	}

}
