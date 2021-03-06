package com.ipai.uptake.codeassisgnment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ipai.uptake.codeassisgnment.common.CompositeUIElement;

public class UptakeHomePage extends CompositeUIElement {

	public static final String TITLE = "Home | Uptake";
	public static final By OUR_PLATFORM_TEXT = By
			.cssSelector("div.l-section__content div.l-wrap.l-wrap--wide h1.hero-title.hero-title--inline.js-hero-title.anim-in span.js-typed");
	public static final String CURRENT_URL = "http://uptake.com/";
	public final CommonPageComponentsHeader uptakeSitePageHeader;
	public final CommonPageComponentsFooter uptakeSitePageFooter;

	public UptakeHomePage(final WebDriver driverObj) {
		super(driverObj, TITLE, CURRENT_URL);
		uptakeSitePageHeader = new CommonPageComponentsHeader(pageDriver);
		uptakeSitePageFooter = new CommonPageComponentsFooter(pageDriver);
	}

	public boolean checkUptakeHomePageHeader() {
		return uptakeSitePageHeader.checkAllHeaderElemnts(TITLE);
	}

	public boolean checkUptakeHomePageFooter() {
		return uptakeSitePageFooter.checkAllFooterElemnts(TITLE);
	}

	public boolean checkOurPlatformComponentPresent() {
		return checkifElementPresent(OUR_PLATFORM_TEXT,
				"The UI element for our platform text was not found in the page " + TITLE);
	}

	public UptakeApproachPage clickApproachfromHeaderLink() {
		if (pageLoadPostElementClickStatus(uptakeSitePageHeader.HEADER_APPROACH_LINK, UptakeApproachPage.CURRENT_URL))
			return new UptakeApproachPage(this.pageDriver);

		return null;
	}
}
