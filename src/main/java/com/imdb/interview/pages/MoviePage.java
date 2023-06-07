package com.imdb.interview.pages;

import com.imdb.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MoviePage extends BaseMethods {
    By lblPresentationBy = By.className("ipc-metadata-list__item");
    By btnHomePageBy = By.id("home_img_holder");

    By btnSeeAllPhotos = By.className("ipc-title-link-wrapper");
    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public String getName(String title){
        String titleAndName = getElementWithTextInList(lblPresentationBy,title).getText();
        String name = titleAndName.replace(title + "\n", "");
        return name;
    }

    public HomePage clickHomePageButton(){
        click(btnHomePageBy);
        return new HomePage(driver);
    }

    public MediaViewerPage clickSeeAllPhotos() throws InterruptedException {
        WebElement seeAllPhotosElement = getElementWithTextInList(btnSeeAllPhotos, "Photos");
        scrollToElement(seeAllPhotosElement);
        Thread.sleep(3000);
        clickWebElement(seeAllPhotosElement);
        return new MediaViewerPage(driver);
    }
}
