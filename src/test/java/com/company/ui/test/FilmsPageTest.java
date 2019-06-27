package com.company.ui.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.company.ui.pages.FilmsPage;
import com.company.ui.pages.HomePage;
import com.company.ui.utils.DriverManager;
import com.company.ui.utils.PropertyManager;

public class FilmsPageTest {

	private static final Logger LOGGER = LogManager.getLogger();

	private static String filmUrl;
	private static String homeUrl;

	FilmsPage filmsPage = new FilmsPage();
	HomePage homePage = new HomePage();

	private static String pageTitle = "Star Wars Movies";

	@Test
	public void navigateFromHome() {
		DriverManager.getPage(homeUrl);
		homePage.isPageLoaded();
		homePage.navigateToFilms();
		filmsPage.isPageDisplayed();
		String filmsPageTitle = DriverManager.getPageTitle().toLowerCase();
		LOGGER.debug("films page title: [{}]", filmsPageTitle);
		Assert.assertTrue(filmsPageTitle.contains(pageTitle.toLowerCase()));
	}

	@Test
	public void movieSelectionFromDropdownTest() {
		filmsPage.selectFilmDropDownOption();
		filmsPage.getListOfMoviesFromSelector();
		String movieName = filmsPage.selectRandomMovie().toLowerCase();
		LOGGER.debug("movie selected: [{}]", movieName);
		Assert.assertTrue(DriverManager.getPageTitle().toLowerCase().contains(movieName),
				"incorrect movie info displayed");
	}

	@Test
	public void defaultFileSelectorTest() {
		String defaultFilmSelector = filmsPage.getDefaultFileSelector().toLowerCase();
		LOGGER.debug("default film selector: [{}]", defaultFilmSelector);
		Assert.assertEquals("see all", defaultFilmSelector, "incorrect default film selector");
	}
	
	@Test
	public void movieCountTest() {
		int numFilmsFromSelector = filmsPage.getListOfMoviesFromSelector().size();
		int numFilmsDisplayed = filmsPage.getListOfMovies().size();
		Assert.assertEquals(numFilmsFromSelector, numFilmsDisplayed, 
				"mismatch between number of films displayed vs number of films in the selector");
	}

	@BeforeMethod
	public void beforeTest() {
		DriverManager.getPage(filmUrl);
		filmsPage.isPageDisplayed();
	}

	@BeforeClass
	@Parameters({ "base-url" })
	public void beforeClass(String baseUrl) {
		filmUrl = baseUrl + PropertyManager.UI_PROPERTIES.getProperty("films-path");
		LOGGER.info("films url: [{}]", filmUrl);

		homeUrl = baseUrl;
		LOGGER.info("home url: [{}]", baseUrl);

		DriverManager.init();
		DriverManager.maximizewindow();
	}

	@AfterClass
	public void afterClass() {
		DriverManager.quit();
	}

}
