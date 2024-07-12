package com.ews.web_seller_test.until;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {

    public TestDriver() {
    }

    public ChromeDriver getDriver() {
        String driverUrl = "chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverUrl);
        return new ChromeDriver();
    }
}
