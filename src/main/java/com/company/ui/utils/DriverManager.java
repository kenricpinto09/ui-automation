package com.company.ui.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	public static WebDriver driver;
	
	
	
	
	public static void init() {
		System.setProperty("webdriver.gecko.driver","geckodriver");
		driver = new FirefoxDriver();
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void close() {
		driver.quit();
	}
	
	
	public static String getHandle() {
		return driver.getWindowHandle();
	}
	
	
	public static Set<String> getHandles() {
		return driver.getWindowHandles();
	}
	
	
	public static void switchToHandle(String handle) {
		driver.switchTo().window(handle);
	}
	
	public static void getPage(String url) {
		driver.get(url);
	}
	
	public static String getPageTitle() {
		return driver.getTitle();
	}
	
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}
	
	
	
	

}
