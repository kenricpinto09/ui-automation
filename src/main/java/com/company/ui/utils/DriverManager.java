package com.company.ui.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	public static WebDriver driver;

	public static String BROWSER = System.getProperty("browser");

	static {
		if (BROWSER == null) {
			BROWSER = "chrome";
		} else {
			BROWSER = BROWSER.toLowerCase();
		}
	}

	/**
	 * Instantiate the driver
	 */
	public static void init() {
		switch (BROWSER) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			driver = new FirefoxDriver();
			break;
		}
	}

	/**
	 * Quit.
	 */
	public static void quit() {
		driver.quit();
	}

	/**
	 * Close.
	 */
	public static void close() {
		driver.quit();
	}

	/**
	 * Gets the handle.
	 *
	 * @return the handle
	 */
	public static String getHandle() {
		return driver.getWindowHandle();
	}

	/**
	 * Gets the handles.
	 *
	 * @return the handles
	 */
	public static Set<String> getHandles() {
		return driver.getWindowHandles();
	}

	/**
	 * Switch to handle.
	 *
	 * @param handle the handle
	 */
	public static void switchToHandle(String handle) {
		driver.switchTo().window(handle);
	}

	/**
	 * Navigates to page
	 *
	 * @param url the url
	 */
	public static void getPage(String url) {
		driver.get(url);
	}

	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public static String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Maximize window.
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Gets the current url.
	 *
	 * @return the current url
	 */
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
