package com.ews.web_seller_test.controller.user;

import com.ews.web_seller_test.until.TestDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateProfileTest extends TestDriver{

    @Test
    public void ValidIn4() {
        ChromeDriver driver = getDriver();
        driver.get("http://localhost:9999/web_seller_test_war_exploded/login");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("hoang");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123");

        driver.findElement(By.id("loginBtn")).click();

        driver.get("http://localhost:9999/web_seller_test_war_exploded/home");

        WebElement profileMenu = driver.findElement(By.cssSelector(".nav-profile"));
        profileMenu.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement myProfileLink = driver.findElement(By.xpath("//a[contains(@href, '/profile')]"));
        myProfileLink.click();

        driver.get("http://localhost:9999/web_seller_test_war_exploded/profile");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement editProfileTab = driver.findElement(By.id("returntoupdateprofile"));
        editProfileTab.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement fullname = driver.findElement(By.name("fullName"));
        fullname.clear();
        fullname.sendKeys("Nguyen Duc Phuong");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0945927647");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("phuong@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

}
