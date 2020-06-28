package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.GHomePage;
import pages.GSearchPage;

public class GoogleTest extends ParentTest{
	
	protected GHomePage gHPage;
	protected GSearchPage gSPage;
	
	@BeforeClass
	public void initVars() {
		gHPage= new GHomePage(driver);
		gSPage= new GSearchPage(driver);
	}
	
	@Test(priority=1)
	public void launchApplication() {
		gHPage.launchApplication();
		Assert.assertEquals("Google", gHPage.getPageTitle());
		System.out.println("User is on google page");
	}
	
	@Test(priority=2)
	public void verifySearchResults() {
		gSPage=gHPage.enterSearchTerm();
		System.out.println("User entered the search term");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(gSPage.verifySearchResults(),"Avengers - Google Search");
		System.out.println("User is on search page");
	}
	
	@Test(priority=3)
	public void verifyHomePage() {
		gHPage=gSPage.navigateBackandVerifyPageTitle();
		System.out.println("User navigated back to home page");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(gSPage.verifySearchResults(),"Google");
		System.out.println("User is on home page");
	}
}