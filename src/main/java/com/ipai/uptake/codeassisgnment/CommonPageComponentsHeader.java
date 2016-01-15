package com.ipai.uptake.codeassisgnment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.ipai.uptake.codeassisgnment.common.CompositeUIElement;

public class CommonPageComponentsHeader extends CompositeUIElement {

	public static final By HEADER_APPROACH_LINK = By.xpath("//header/div/div[1]/div/ul/li[1]/a");
	public static final By HEADER_PLATFORM_LINK = By.xpath("//header/div/div[1]/div/ul/li[2]/a");
	public static final By HEADER_SOLUTIONS_LINK = By.xpath("//header/div/div[1]/div/ul/li[3]/a");
	public static final By HEADER_PEOPLE_LINK = By.xpath("//header/div/div[1]/div/ul/li[4]/a");
	public static final By HEADER_JOINUS_LINK = By.xpath("//header/div/div[1]/div/ul/li[5]/a");
	public static final By HEADER_BLOG_LINK = By.xpath("//header/div/div[1]/div/ul/li[6]/a");
	public static final By HEADER_UPTAKE_LOGO = By
			.cssSelector("div.l-wrap.l-wrap--full a.l-site-header__logo svg.icon.icon--logo");
	public static final By HEADER_TOP = By.id("top");
	public static final By HEADER_AT_TOP = By.className("l-site-header in top");
	public static final String HEADER_WHEN_SCROLLING_DOWN_FROM_TOP = "l-site-header";
	public static final String HEADER_WHEN_SCROLLING_TOP_FROM_DOWN = "l-site-header in";

	// public WebDriver driver;

	public CommonPageComponentsHeader(WebDriver driverObj) {
		super(driverObj);
	}

	public boolean checkAllHeaderElemnts(String page) {
		boolean isTestCasePassed = true;

		if (checkifElementPresent(HEADER_UPTAKE_LOGO, "Uptake Logo was not found in header in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(HEADER_APPROACH_LINK, "Approach link was not found in header in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(HEADER_PLATFORM_LINK, "Platform link was not found in header in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(HEADER_SOLUTIONS_LINK, "Solutions link was not found in header in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(HEADER_PEOPLE_LINK, "People link was not found in header in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(HEADER_JOINUS_LINK, "Join Us link was not found in header in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(HEADER_BLOG_LINK, "Blog link was not found in header in page : " + page) == false)
			isTestCasePassed = false;

		/*
		 * The following part of code checks for header is not sticky on scroll
		 * down, but is sticky on scroll up
		 */

		pageDriver.manage().window().maximize();

		if (checkifElementPresent(HEADER_TOP,
				"Header At Top was not found when page was vertically scrolled to TOP in page : " + page) == false)
			isTestCasePassed = false;

		else {

			/* This for loop code simulates user browser scroll down */

			for (int counter = 0; counter < 3; counter++) {

				((JavascriptExecutor) pageDriver).executeScript("window.scrollBy(0,500)", "");

				try {
					Thread.sleep(100);
				} catch (final InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pageDriver.findElement(HEADER_TOP).getAttribute("class")
					.equalsIgnoreCase(HEADER_WHEN_SCROLLING_DOWN_FROM_TOP) == false) {
				System.out.println("Header with expected class name as " + HEADER_WHEN_SCROLLING_DOWN_FROM_TOP
						+ " was not found");
				isTestCasePassed = false;
			}

			((JavascriptExecutor) pageDriver).executeScript("window.scrollBy(0,-500)", "");

			if (pageDriver.findElement(HEADER_TOP).getAttribute("class")
					.equalsIgnoreCase(HEADER_WHEN_SCROLLING_TOP_FROM_DOWN) == false) {
				System.out.println("Header with expected class name as " + HEADER_WHEN_SCROLLING_TOP_FROM_DOWN
						+ " was not found");
				isTestCasePassed = false;
			}

			((JavascriptExecutor) pageDriver).executeScript("window.scrollBy(0,-250)", "");
		}

		return isTestCasePassed;
	}

}
