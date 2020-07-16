/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import static utils.ConfigPropertyReader.getProperty;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	
	public  WebDriver driver=null;

	public WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (Boolean.parseBoolean(getProperty("remote"))) {
				init_remoteWebDriver(browserName);
			}
			else {
				driver= new ChromeDriver();
			}

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(getProperty("remote"))) {
				init_remoteWebDriver(browserName);
			}
			else {
				driver= new FirefoxDriver();
				
			}
		}
		return driver;
	}
	
	private WebDriver init_remoteWebDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, false);
			try {
				driver= new RemoteWebDriver(new URL(getProperty("huburl")), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return driver;
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			try {
				driver= new RemoteWebDriver(new URL(getProperty("huburl")), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}
