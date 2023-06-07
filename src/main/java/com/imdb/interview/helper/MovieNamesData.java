package com.imdb.interview.helper;

import org.testng.annotations.DataProvider;

public class MovieNamesData {
    @DataProvider(name = "movieData")
    public Object[][] provideMovieData() {
        return new Object[][] {
                {"The Circus", "1920s","1929"},
                {"The Jazz Singer","1920s","1929"}
        };
    }
}
