package com.ipai.uptake.codeassisgnment.homepagetests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ipai.uptake.codeassisgnment.UptakeApproachPage;
import com.ipai.uptake.codeassisgnment.UptakeHomePage;

public class HomePageTest {
	private static WebDriver driver;
	private static final String HOME_URL = "http://uptake.com/";
	private final UptakeHomePage homePage = new UptakeHomePage(driver);

	@BeforeClass
	public static void setup() {
		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		driver.get(HOME_URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Commented the following assert as response code was always 403

		// Assert.assertTrue("Error encountered on checking Http status of Home Page URL",
		// UptakeHomePage.checkURLHTTPStatus(HOME_URL));

	}

	@Test
	public void basicSmokeandNavigationToApproachPageTest() {

		Assert.assertTrue("HomePage Header has errors", homePage.checkUptakeHomePageHeader());
		Assert.assertTrue("HomePage footer has errors", homePage.checkUptakeHomePageFooter());

		Assert.assertTrue(homePage.checkOurPlatformComponentPresent());

		final UptakeApproachPage approachPage = homePage.clickApproachfromHeaderLink();
		Assert.assertNotNull(approachPage);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
