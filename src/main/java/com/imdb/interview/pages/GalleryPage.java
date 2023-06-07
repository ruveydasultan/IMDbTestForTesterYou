package com.imdb.interview.pages;

import com.imdb.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GalleryPage extends BaseMethods {

    By imagesBy = By.xpath("//*[@id=\"media_index_thumbnail_grid\"]/a/img");
    By btnNextBy = By.className("prevnext");
    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getPhotosUrl() throws InterruptedException {
        scrollToPage();
        List<WebElement> imagesElements = driver.findElements(imagesBy);
        List<String> imageUrls = getImagesUrl(imagesElements);
        driver.findElements(btnNextBy).get(1).click();

        Thread.sleep(3000);

        scrollToPage();
        imagesElements = driver.findElements(imagesBy);
        imageUrls.addAll(getImagesUrl(imagesElements));
        return imageUrls;
    }

    public Map<Integer,String> getResponseCode() throws IOException, InterruptedException {
        Map<Integer,String> responseCodesAndUrls = new HashMap<>() {
        };
        for (String url : getPhotosUrl()){
            responseCodesAndUrls.put(getHTTPRequestResponseCode(url),url);
        }
        return responseCodesAndUrls;
    }

    public List<String> getImagesUrl(List<WebElement> imagesElements){
        List<String> imageUrls = new ArrayList<>();
        for(WebElement item : imagesElements){
            imageUrls.add(item.getAttribute("src"));
        }
        return imageUrls;
    }
}
