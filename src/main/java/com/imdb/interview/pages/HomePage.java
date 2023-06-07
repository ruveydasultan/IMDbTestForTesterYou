package com.imdb.interview.pages;

import com.imdb.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMethods {

    private String homePageUrl = "https://www.imdb.com/";
    By btnMenuBy = By.id("imdbHeader-navDrawerOpen");
    By menuSubItemsBy = By.className("ipc-list-item__text");

    By searchBoxBy = By.id("suggestion-search");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        getUrl(homePageUrl);
    }

    public void clickMenu(){
        click(btnMenuBy);
    }

    public OscarsPage clickSubItemMenu(String itemName) throws InterruptedException {
        Thread.sleep(2000);
        clickWebElement(getElementWithTextInList(menuSubItemsBy, itemName));
        return new OscarsPage(driver);
    }

    public SearchResultPage sendKeysSearchBox(String text){
        click(searchBoxBy);
        sendKeys(searchBoxBy,text + Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
