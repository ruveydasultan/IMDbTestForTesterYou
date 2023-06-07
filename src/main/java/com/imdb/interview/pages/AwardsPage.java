package com.imdb.interview.pages;

import com.imdb.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AwardsPage extends BaseMethods {
    By btnMovies = By.className("event-widgets__nominee-name");
    public AwardsPage(WebDriver driver) {
        super(driver);
    }

    public MoviePage clickMovie(String movieName) throws InterruptedException {
        WebElement movieElement = getElementWithTextInList(btnMovies, movieName);
        scrollToElement(movieElement);
        Thread.sleep(3000);
        clickWebElement(movieElement);
        return new MoviePage(driver);
    }
}
