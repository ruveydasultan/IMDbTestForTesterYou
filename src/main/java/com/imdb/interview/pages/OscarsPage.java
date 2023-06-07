package com.imdb.interview.pages;

import com.imdb.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OscarsPage extends BaseMethods {
    By btnYearsBy = By.cssSelector("li.ipc-tab.ipc-tab--on-base");
    By btnSubYearsBy = By.id("event-history-edition-0");
    By arrowIconBy = By.cssSelector("li.ipc-tab-arrow.ipc-tab-arrow--visible.ipc-tab-arrow--right");
    public OscarsPage(WebDriver driver) {
        super(driver);
    }

    public void clickYearsArrow() throws InterruptedException {
        Thread.sleep(3000);
        scrollToElement(arrowIconBy);
        click(arrowIconBy);
    }

    public void clickYears(String year) throws InterruptedException {
        WebElement yearElement = getElementWithTextInList(btnYearsBy,year);
        Thread.sleep(1000);
        clickWebElement(yearElement);
    }

    public AwardsPage clickSubYears(String year) throws InterruptedException {
        Thread.sleep(3000);
        WebElement subYearElemet = getElementWithTextInList(btnSubYearsBy,year);
        scrollToElement(subYearElemet);
        Thread.sleep(3000);
        clickWebElement(subYearElemet);
        return new AwardsPage(driver);
    }
}
