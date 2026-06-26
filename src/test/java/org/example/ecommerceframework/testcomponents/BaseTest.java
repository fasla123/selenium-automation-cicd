package org.example.ecommerceframework.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.example.ecommerceframework.pageobjects.LandingPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public LandingPage landingPage;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	WebDriver localDriver ;

	public WebDriver initializeBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//org//example//ecommerceframework//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		ChromeOptions option = new ChromeOptions();

		if (browserName.equalsIgnoreCase("Chrome")) {
			if(browserName.contains("headless")) {
				
				option.addArguments("headless");
				localDriver.manage().window().setSize(new Dimension(1440,900));
				
						
			}
			localDriver = new ChromeDriver(option);

		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			localDriver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			localDriver = new FirefoxDriver();
		}

		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.set(localDriver);
		return localDriver;
	}

	@BeforeMethod(alwaysRun= true)
	public LandingPage launchApplication() throws IOException {
		WebDriver localDriver = initializeBrowser();
		landingPage = new LandingPage(localDriver);
		landingPage.goTo();
		return landingPage;
	}
	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ss= (TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//Reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//Reports//"+testCaseName+".png";
	}
	public static WebDriver getDriver() {
        return driver.get();
    }

	@AfterMethod(alwaysRun= true)
	public void tearDown() {
		driver.get().close();
	}
}
