package com.imdb.interview;

import com.imdb.interview.helper.MovieNamesData;
import com.imdb.interview.pages.*;
import listener.ScreenshotListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Listeners(ScreenshotListener.class)
public class IMDbTest extends BaseTest{
    @Test(dataProvider = "movieData", dataProviderClass = MovieNamesData.class)
    public void imdbTest(String movieName, String years, String subYears) throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        homePage.clickMenu();

        OscarsPage oscarsPage = homePage.clickSubItemMenu("Oscars");
        oscarsPage.clickYearsArrow();
        oscarsPage.clickYears(years);

        AwardsPage awardsPage = oscarsPage.clickSubYears(subYears);


        MoviePage moviePage = awardsPage.clickMovie(movieName);

        String directorName = moviePage.getName("Director");
        String writerName = moviePage.getName("Writer");
        String starsName = moviePage.getName("Stars");

        homePage = moviePage.clickHomePageButton();
        SearchResultPage searchResultPage = homePage.sendKeysSearchBox(movieName);
        moviePage = searchResultPage.clickResult(movieName);

        Assert.assertEquals(directorName,moviePage.getName("Director"));
        Assert.assertEquals(writerName,moviePage.getName("Writer"));
        Assert.assertEquals(starsName,moviePage.getName("Stars"));

        MediaViewerPage mediaViewerPage = moviePage.clickSeeAllPhotos();
        GalleryPage galleryPage = mediaViewerPage.clickGalleryButton();

        for (Map.Entry<Integer, String> responseCodeAndUrl: galleryPage.getResponseCode().entrySet()){
            Assert.assertEquals(200, responseCodeAndUrl.getKey(),"Url is broken. Url is: " + responseCodeAndUrl.getValue());
        }

    }
}
