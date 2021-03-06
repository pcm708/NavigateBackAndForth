package tests;

import static utils.ConfigPropertyReader.getProperty;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.WebDriverFactory;

public class ParentTest {

	protected WebDriver driver=null;
	protected WebDriverFactory wdFactory;
	
	@BeforeTest
	public void initPages() {
		if (driver == null) {
		wdFactory= new WebDriverFactory();
		driver = wdFactory.getDriver(getProperty("browser"));
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
}