package com.company.ui.pages;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.company.ui.utils.DriverManager;

public class FilmsPage extends DriverManager {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	private static final String SW_LOGO_ID = "nav-sw-logo-bar";
	private static final String FILM_SELECTOR_DROP_DOWN_CLASS = "drop-expand";
	private static final String MOVIE_LIST_CLASS = "has-linknoselect";
	private static final String FILM_SELECTOR_DEFAULT_XPATH = "//*[@id=\"film-selector\"]/div/div/label";
	
	
	public void isPageDisplayed() {
		driver.findElement(By.id(SW_LOGO_ID)).isDisplayed();
	}
	
	public void selectFilmDropDownOption() {
		WebElement element = driver.findElement(By.className(FILM_SELECTOR_DROP_DOWN_CLASS));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		driver.findElement(By.className(FILM_SELECTOR_DROP_DOWN_CLASS)).click();
	}
	
	public List<WebElement> getListOfMoviesFromSelector() {
		List<WebElement> movieList = driver.findElements(By.className(MOVIE_LIST_CLASS));
		LOGGER.debug("number of movies: [{}]", movieList.size());
		return movieList;
	}
	
	public List<WebElement> getListOfMovies() {
		List<WebElement> movieElements = driver.findElements(By.className("title"));
		int removeElementIndex = -1;
		for (int i=0; i<movieElements.size(); i++) {
			String name = movieElements.get(i).getText().trim();
			if( name == null || name.equals("") || !name.isEmpty() ) {
				removeElementIndex = i;
			}
		}
		movieElements.remove(removeElementIndex);
		return movieElements;
	}
	
	public String selectRandomMovie() {
		List<WebElement> movieList = getListOfMoviesFromSelector();
		
		int randomIndex = new Random().nextInt((movieList.size()));
		LOGGER.debug("random index: [{}]", randomIndex);
		
		WebElement randomMovie = movieList.get(randomIndex);
		String randomMovieName = randomMovie.getText();
		LOGGER.debug("random movie name: [{}]", randomMovieName);
		randomMovie.click();
		return randomMovieName;
	}
	
	public String getDefaultFileSelector() {
		driver.findElement(By.xpath(FILM_SELECTOR_DEFAULT_XPATH)).isDisplayed();
		return driver.findElement(By.xpath(FILM_SELECTOR_DEFAULT_XPATH)).getText();
	}
	

}
