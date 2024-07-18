package com.ews.web_seller_test.controller.user.category;

import com.ews.web_seller_test.dao.impl.CategoryDaoImpl;
import com.ews.web_seller_test.model.Category;
import com.ews.web_seller_test.until.TestDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest extends TestDriver {
    private final CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    @BeforeEach
    void beforeEach() throws SQLException {
        truncateTable();
        Date currentTime = Date.valueOf(LocalDate.now());
        String[] categories = {"Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home"};
        for (int i = 0; i < categories.length; i++) {
            categoryDao.insertCategory(new Category(i + 1, categories[i], currentTime, currentTime));
        }
    }

    private void loginAndNavigateToCategoryPage(ChromeDriver driver) {
        driver.get("http://localhost:9999/web_seller_test_war_exploded/login");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("a");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("a");
        driver.findElement(By.id("loginBtn")).click();
        driver.findElement(By.id("btn-category")).click();
    }

    private void assertCategoryNames(List<WebElement> categories, String... expectedNames) {
        Assertions.assertNotNull(categories);
        Assertions.assertEquals(expectedNames.length, categories.size());
        for (int i = 0; i < categories.size(); i++) {
            assertTrue(categories.get(i).getText().contains(expectedNames[i]));
        }
    }

    // GET ALL CATEGORIES //
    @Test
    void testGetAllCategories() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }
    // GET ALL CATEGORIES //

    // INSERT CATEGORY //
    @Test
    void testInsertCategoryWithNameOf100Characters() {
        String insertedData = generateData('a', 100);
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-new-category")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.sendKeys(insertedData);
        driver.findElement(By.id("btn-create")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home", insertedData);

        driver.close();
    }

    @Test
    void testInsertCategoryWithNameOfEmptiness() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-new-category")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.sendKeys("");
        driver.findElement(By.id("btn-create")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }

    @Test
    void testInsertCategoryWithNameOf101Characters() {
        String insertedData = generateData('b', 101);
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-new-category")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.sendKeys(insertedData);
        driver.findElement(By.id("btn-create")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }

    @Test
    void testInsertCategoryWithNameBeingDuplicated() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-new-category")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.sendKeys("Sport");
        driver.findElement(By.id("btn-create")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }

    @Test
    void testInsertCategoryWithValidName() {
        String insertedData = "Hypersport";
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-new-category")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.sendKeys(insertedData);
        driver.findElement(By.id("btn-create")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home", insertedData);

        driver.close();
    }
    // INSERT CATEGORY //

    // EDIT CATEGORY //
    @Test
    void testEditCategoryWithNameOf100Characters() {
        String editedData = generateData('c', 100);
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-edit-5")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.clear();
        categoryName.sendKeys(editedData);
        driver.findElement(By.id("btn-update")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", editedData, "Home");

        driver.close();
    }

    @Test
    void testEditCategoryWithNameOfEmptiness() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-edit-4")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.clear();
        categoryName.sendKeys("");
        driver.findElement(By.id("btn-update")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }

    @Test
    void testEditCategoryWithNameOf101Characters() {
        String editedData = generateData('d', 101);
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-edit-3")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.clear();
        categoryName.sendKeys(editedData);
        driver.findElement(By.id("btn-update")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }

    @Test
    void testEditCategoryWithNameBeingDuplicated() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-edit-2")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.clear();
        categoryName.sendKeys("Sport");
        driver.findElement(By.id("btn-update")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, "Sport", "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }

    @Test
    void testEditCategoryWithValidName() {
        String editedData = "Hypersport";
        ChromeDriver driver = getDriver();
        loginAndNavigateToCategoryPage(driver);
        driver.findElement(By.id("btn-edit-1")).click();

        WebElement categoryName = driver.findElement(By.name("cate_name"));
        categoryName.clear();
        categoryName.sendKeys(editedData);
        driver.findElement(By.id("btn-update")).click();

        List<WebElement> categories = driver.findElements(By.cssSelector(".gradeX"));
        assertCategoryNames(categories, editedData, "Electronics", "Education", "Vehicles", "Cooking", "Home");

        driver.close();
    }
    // EDIT CATEGORY //

    private void truncateTable() throws SQLException {
        categoryDao.connection.prepareStatement("TRUNCATE TABLE Category").executeUpdate();
    }

    private String generateData(char character, int length) {
        return String.valueOf(character).repeat(Math.max(0, length));
    }
}
