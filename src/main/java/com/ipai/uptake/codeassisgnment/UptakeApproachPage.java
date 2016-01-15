package com.ipai.uptake.codeassisgnment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ipai.uptake.codeassisgnment.common.CompositeUIElement;

public class UptakeApproachPage extends CompositeUIElement {

	public static final String TITLE = "Approach | Uptake";
	public static final By HOW_WE__BUILD = By.xpath("//div[4]/div/main/div[1]/div/div/h2");
	public static final String CURRENT_URL = "http://uptake.com/approach/";
	public final CommonPageComponentsHeader uptakeSitePageHeader;
	public final CommonPageComponentsFooter uptakeSitePageFooter;

	public UptakeApproachPage(final WebDriver driverObj) {
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

	public boolean checkHowWeBuildComponentPresent() {
		return checkifElementPresent(HOW_WE__BUILD, "The UI element for How We Build.. text was not found in the page "
				+ TITLE);
	}

	public UptakeHomePage clickUptakeLogofromHeaderLink() {
		if (pageLoadPostElementClickStatus(uptakeSitePageHeader.HEADER_UPTAKE_LOGO, UptakeHomePage.CURRENT_URL))
			return new UptakeHomePage(this.pageDriver);

		return null;
	}

}
