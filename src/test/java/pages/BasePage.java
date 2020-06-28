package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;

public abstract class BasePage {

	WebDriver driver;
	WebDriverFactory wdFactory;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By element) {
		return driver.findElement(element);
	}

	public abstract String getPageTitle();
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void tearDown() {
		driver.quit();
	}
}