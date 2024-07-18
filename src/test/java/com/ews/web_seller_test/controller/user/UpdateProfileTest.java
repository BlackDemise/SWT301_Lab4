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

    @Test
    public void FullNameIsNull() {
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

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0945927647");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement nameuser = driver.findElement(By.id("nameuser"));
        String actualName = nameuser.getText();
        System.out.println(actualName);

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedName = "Bui Sy Thai Hoang";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void FullNameHaveNumber() {
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
        fullname.sendKeys("Bui Sy Thai Hoang04");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0945927647");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement nameuser = driver.findElement(By.id("nameuser"));
        String actualName = nameuser.getText();
        System.out.println(actualName);

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedName = "Bui Sy Thai Hoang";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void FullNameHaveSpecialCharacter() {
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
        fullname.sendKeys("Bui Sy Thai Hoang#!");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0945927647");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement nameuser = driver.findElement(By.id("nameuser"));
        String actualName = nameuser.getText();
        System.out.println(actualName);

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedName = "Bui Sy Thai Hoang";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void AddressIsBlank() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0945927647");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement addressuser = driver.findElement(By.id("addressuser"));
        String actualAddress = addressuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedName = "Ha Noi";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedName, actualAddress);
    }

    @Test
    public void AddressHaveSpecChars() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi#!");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0945927647");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement addressuser = driver.findElement(By.id("addressuser"));
        String actualAddress = addressuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedName = "Ha Noi";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedName, actualAddress);
    }

    @Test
    public void PhoneIsBlank() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement phoneuser = driver.findElement(By.id("phoneuser"));
        String actualPhone = phoneuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedPhone = "0973165886";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void PhoneHaveLetters() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0973165886aaa");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement phoneuser = driver.findElement(By.id("phoneuser"));
        String actualPhone = phoneuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedPhone = "0973165886";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void PhoneHaveSpecialChars() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("0973165886#!");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement phoneuser = driver.findElement(By.id("phoneuser"));
        String actualPhone = phoneuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedPhone = "0973165886";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void Phonehas1Number() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("1");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement phoneuser = driver.findElement(By.id("phoneuser"));
        String actualPhone = phoneuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedPhone = "0973165886";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void PhonehasSame() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement phoneuser = driver.findElement(By.id("phoneuser"));
        String actualPhone = phoneuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedPhone = "0973165886";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void EmailIsEmpty() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement emailuser = driver.findElement(By.id("emailuser"));
        String actualEmail = emailuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedMail= "hoang@gmail.com";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedMail, actualEmail);
    }

    @Test
    public void EmailHasSpecChars() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang#!@gmail.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement emailuser = driver.findElement(By.id("emailuser"));
        String actualEmail = emailuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedMail= "hoang@gmail.com";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedMail, actualEmail);
    }

    @Test
    public void EmailDomainNull() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement emailuser = driver.findElement(By.id("emailuser"));
        String actualEmail = emailuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedMail= "hoang@gmail.com";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedMail, actualEmail);
    }

    @Test
    public void EmailSame() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("john@example.com");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement emailuser = driver.findElement(By.id("emailuser"));
        String actualEmail = emailuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedMail= "hoang@gmail.com";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedMail, actualEmail);
    }

    @Test
    public void EmailAfterDomain() {
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
        fullname.sendKeys("Bui Sy Thai Hoang");

        WebElement address = driver.findElement(By.name("address"));
        address.clear();
        address.sendKeys("Ha Noi");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("hoang@");

        WebElement saveChangesButton = driver.findElement(By.id("submitedit"));
        saveChangesButton.click();

        WebElement emailuser = driver.findElement(By.id("emailuser"));
        String actualEmail = emailuser.getText();

        String actualTitle = driver.getTitle();

        String expectedTitle = "Profile";
        String expectedMail= "hoang@gmail.com";
        driver.close();
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedMail, actualEmail);
    }
}
