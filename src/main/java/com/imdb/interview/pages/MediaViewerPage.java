package com.imdb.interview.pages;

import com.imdb.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MediaViewerPage extends BaseMethods {

    By btnGallereyBy = By.id("iconContext-grid-view");
    public MediaViewerPage(WebDriver driver) {
        super(driver);
    }

    public GalleryPage clickGalleryButton(){
        click(btnGallereyBy);
        return new GalleryPage(driver);
    }
}
