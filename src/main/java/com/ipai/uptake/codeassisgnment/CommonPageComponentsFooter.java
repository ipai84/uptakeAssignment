package com.ipai.uptake.codeassisgnment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ipai.uptake.codeassisgnment.common.CompositeUIElement;

public class CommonPageComponentsFooter extends CompositeUIElement {
	public static final By FOOTER_APPROACH_LINK = By.xpath("//footer/div/div[1]/div/ul[1]/li[1]/a");
	public static final By FOOTER_PLATFORM_LINK = By.xpath("//footer/div/div[1]/div/ul[1]/li[2]/a");
	public static final By FOOTER_PEOPLE_LINK = By.xpath("//footer/div/div[1]/div/ul[1]/li[3]/a");
	public static final By FOOTER_OPEN_POSITIONS_LINK = By.xpath("//footer/div/div[1]/div/ul[2]/li[1]/a");
	public static final By FOOTER_BLOG_LINK = By.xpath("//footer/div/div[1]/div/ul[2]/li[2]/a");
	public static final By FOOTER = By.className("footer__top");
	public static final By FOOTER_SOCIAL = By.className("footer__social");
	public static final By FOOTER_ARROW = By.className("footer__arrow");
	public static final By FOOTER_COPYRIGHT = By.className("footer__copyright");

	public CommonPageComponentsFooter(WebDriver driverObj) {
		super(driverObj);
	}

	public boolean checkAllFooterElemnts(String page) {
		boolean isTestCasePassed = true;

		if (checkifElementPresent(FOOTER_APPROACH_LINK, "Approach link was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(FOOTER_PLATFORM_LINK, "Platform link was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(FOOTER_PEOPLE_LINK, "People link was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(FOOTER_OPEN_POSITIONS_LINK, "Join Us link was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(FOOTER_BLOG_LINK, "Blog link was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(FOOTER_SOCIAL, "Social Media component was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(FOOTER_ARROW, "Arrow Icon was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		if (checkifElementPresent(FOOTER_COPYRIGHT, "CopyRight was not found in FOOTER in page : " + page) == false)
			isTestCasePassed = false;

		return isTestCasePassed;
	}

}
