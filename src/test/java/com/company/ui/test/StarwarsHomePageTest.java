package com.company.ui.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StarwarsHomePageTest {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	String url = "https://www.starwars.com/";

	@Test
	public void f() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","/Users/kenricpinto/tools/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		LOGGER.info("launched firefox");
		
		
		driver.get(url);
		
		LOGGER.info("loaded url");
		
		Thread.sleep(3000);
		
		
		
	}

	@BeforeTest
	public void beforeTest() {
	}

}
