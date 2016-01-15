package com.ipai.uptake.codeassisgnment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompositeUIElement {

	protected static WebDriver pageDriver = null;

	public CompositeUIElement(WebDriver driverObj, String title, String url) {
		CompositeUIElement.pageDriver = driverObj;

		if (!StringUtils.equals(pageDriver.getTitle(), title)) {
			throw new IllegalStateException("This is not the " + title + " Page, The title found for this page is "
					+ pageDriver.getTitle());
		}
		if (!StringUtils.equals(pageDriver.getCurrentUrl(), url)) {
			throw new IllegalStateException("This is not the " + title + " URL, The URL post page load is "
					+ pageDriver.getCurrentUrl());
		}
	}

	public static boolean checkifElementPresent(By locator, String error) {
		boolean isTestCasePassed = true;
		WebElement webElement = null;

		try {
			webElement = pageDriver.findElement(locator);
			if (webElement.isDisplayed() == false)
				isTestCasePassed = false;

		} catch (final Exception e) {
			System.out.println(error);
			e.printStackTrace();
			isTestCasePassed = false;
		}

		return isTestCasePassed;
	}

	public static boolean checkifElementNotPresent(By locator, String error) {
		boolean isTestCasePassed = true;
		WebElement webElement = null;

		try {
			webElement = pageDriver.findElement(locator);
			if (webElement.isDisplayed() == true)
				isTestCasePassed = false;

		} catch (final Exception e) {
			System.out.println(error);
			e.printStackTrace();

		}

		return isTestCasePassed;
	}

	public static boolean checkURLHTTPStatus(String expectedURL) {
		boolean isTestCasePassed = true;

		try {
			final URL url = new URL(expectedURL);
			final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int codeResponse = connection.getResponseCode();

			System.out.println("Response code of the object is " + codeResponse);
			if (codeResponse == 404) {
				System.out.println("Got 404 http response code");
				isTestCasePassed = false;
			}
			if (codeResponse == 500) {
				System.out.println("Got 500 http response code");
				isTestCasePassed = false;
			}
			codeResponse = connection.getResponseCode();
		} catch (final MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isTestCasePassed;
	}

	public static boolean pageLoadPostElementClickStatus(By locator, String expectedURL) {
		boolean isTestCasePassed = true;
		WebElement webElement = null;

		try {
			webElement = pageDriver.findElement(locator);
			webElement.click();

			pageDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			if (checkURLHTTPStatus(expectedURL) == false)
				isTestCasePassed = false;

		} catch (final Exception e) {
			System.out.println("Error encountered post clicking on the locator");
			e.printStackTrace();

		}

		return isTestCasePassed;
	}

}
