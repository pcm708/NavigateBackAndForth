package pages;

import org.openqa.selenium.WebDriver;

public class GSearchPage extends BasePage{

	public GSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String verifySearchResults() {
		return getPageTitle();
	}
	
	public GHomePage navigateBackandVerifyPageTitle() {
		navigateBack();
		return new GHomePage(driver);
	}
}