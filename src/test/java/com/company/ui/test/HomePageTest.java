package com.company.ui.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.company.ui.pages.HomePage;
import com.company.ui.pages.LogInPage;
import com.company.ui.pages.SignUpPage;
import com.company.ui.utils.DriverManager;
import com.company.ui.utils.PropertyManager;

public class HomePageTest {

	private static final Logger LOGGER = LogManager.getLogger();

	private static String homeUrl;

	HomePage homePage = new HomePage();

	LogInPage loginPage = new LogInPage();

	SignUpPage signupPage = new SignUpPage();

	/**
	 * Verify navigation to the video page
	 */
	@Test
	public void navigateToVideoOptionTest() {
		homePage.navigateToVideo();
		LOGGER.debug("page: [{}]", DriverManager.driver.getCurrentUrl());
		Assert.assertEquals(DriverManager.getCurrentUrl(),
				homeUrl + PropertyManager.UI_PROPERTIES.getProperty("video-path"), "incoorect url loaded");
	}

	/**
	 * Verify Copyright text
	 */
	@Test
	public void copyrightTest() {
		String copyrightText = homePage.getCopyrightText();
		LOGGER.debug("copyright info: [{}]", copyrightText);
		Assert.assertEquals(copyrightText, "TM & © Lucasfilm Ltd. All Rights Reserved",
				"copyright text does not match");
	}

	/**
	 * Before test.
	 */
	@BeforeMethod
	public void beforeTest() {
		DriverManager.getPage(homeUrl);
		homePage.isPageDisplayed();
	}

	/**
	 * Before class.
	 *
	 * @param baseUrl
	 *            the base url
	 */
	@BeforeClass
	@Parameters({ "base-url" })
	public void beforeClass(String baseUrl) {
		homeUrl = baseUrl;
		LOGGER.info("home url: [{}]", baseUrl);

		DriverManager.init();
		DriverManager.maximizeWindow();
	}

	/**
	 * After class.
	 */
	@AfterClass
	public void afterClass() {
		DriverManager.quit();
	}

}
