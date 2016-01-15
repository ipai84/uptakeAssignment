package com.ipai.uptake.codeassisgnment;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UptakeApproachPage {

	public static final String TITLE = "Approach | Uptake";
	public static final By HOW_WE__BUILD = By.xpath("//div[4]/div/main/div[1]/div/div/h2");
	public static final String CURRENT_URL = "http://uptake.com/approach/";
	private final WebDriver pageDriver;

	public UptakeApproachPage(WebDriver driver) {

		this.pageDriver = driver;

		if (!StringUtils.equals(pageDriver.getTitle(), TITLE)) {
			throw new IllegalStateException("This is not the Approach Page");
		}
		if (!StringUtils.equals(pageDriver.getCurrentUrl(), CURRENT_URL)) {
			throw new IllegalStateException("This is not the Approach Page, The URL post page load is "
					+ pageDriver.getCurrentUrl());
		}
	}

}
