package com.imdb.interview.pages;

import com.imdb.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BaseMethods {

    By lblResultsBy = By.className("ipc-metadata-list-summary-item__tc");
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public MoviePage clickResult(String movieName){
        clickWebElement(getElementWithTextInList(lblResultsBy,movieName));
        return new MoviePage(driver);
    }
}
