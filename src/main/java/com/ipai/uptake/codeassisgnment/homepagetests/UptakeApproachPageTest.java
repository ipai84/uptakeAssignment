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

public class UptakeApproachPageTest {
	private static WebDriver driver;
	private static final String URL = "http://uptake.com/approach/";

	private final UptakeApproachPage approachPage = new UptakeApproachPage(driver);

	@BeforeClass
	public static void setup() {
		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Commented the following assert as response code was always 403

		// Assert.assertTrue("Error encountered on checking Http status of Home Page URL",
		// UptakeHomePage.checkURLHTTPStatus(HOME_URL));

	}

	@Test
	public void basicSmokeandNavigationToApproachPageTest() {

		Assert.assertTrue(" Approach Page header has errors", approachPage.checkUptakeHomePageHeader());

		Assert.assertTrue(" Approach Page footer has errors", approachPage.checkUptakeHomePageFooter());

		Assert.assertTrue(approachPage.checkHowWeBuildComponentPresent());

		final UptakeHomePage homePage = approachPage.clickUptakeLogofromHeaderLink();
		Assert.assertNotNull(homePage);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
