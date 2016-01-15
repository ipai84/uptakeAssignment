package com.ipai.uptake.codeassisgnment;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {
	private static WebDriver driver;
	private static final String HOME_URL = "http://uptake.com/";
	private final UptakeHomePage homePage = new UptakeHomePage(driver);

	@BeforeClass
	public static void setup() {
		driver = new FirefoxDriver();
		driver.get(HOME_URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test
	public void basicStatusCodeTest() {

		Assert.assertTrue("Error encountered on checking Http status of Home Page URL",
				UptakeHomePage.checkURLHTTPStatus(HOME_URL));

	}

	@Test
	public void basicPageHeaderTest() {

		Assert.assertTrue("HomePage header has errors", homePage.checkUptakeHomePageHeader());

	}

	@Test
	public void basicPageFooterTest() {

		Assert.assertTrue("HomePage footer has errors", homePage.checkUptakeHomePageFooter());

	}

	@Test
	public void basicTest() {

		// Assert.assertTrue(homePage.checkOurPlatformText());
		// ApproachPage approachPage = homePage.clickApproachLink();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
