package com.ipai.uptake.codeassisgnment;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class UptakeHomePage {

	public static final String TITLE = "Home | Uptake";

	private final WebDriver driver;

	public UptakeHomePage(WebDriver driver) {

		this.driver = driver;

		if (!StringUtils.equals(driver.getTitle(), TITLE)) {
			throw new IllegalStateException("This is not the Uptake Home Page");
		}
	}

}
