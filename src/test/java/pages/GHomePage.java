package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GHomePage extends BasePage{

	private By searchBox = By.name("q");
	
	public GHomePage(WebDriver driver) {
		super(driver);
	}

	public void launchApplication() {
		driver.get("https://www.google.co.in/");
	}
	
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public GSearchPage enterSearchTerm() {
		getElement(searchBox).sendKeys("Avengers");
		getElement(searchBox).sendKeys(Keys.ENTER);
		return new GSearchPage(driver);
	}
}