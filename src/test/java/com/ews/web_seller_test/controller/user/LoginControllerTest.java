package com.ews.web_seller_test.controller.user;

import com.ews.web_seller_test.until.TestDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginControllerTest extends TestDriver {
    @Test
    void testLoginTitle() {
        ChromeDriver driver = getDriver();
        driver.get("http://localhost:9999/web_seller_test_war_exploded/login");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void testLoginFailed() {
        ChromeDriver driver = getDriver();
        driver.get("http://localhost:9999/web_seller_test_war_exploded/login");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("a");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("a");

        driver.findElement(By.id("loginBtn")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}