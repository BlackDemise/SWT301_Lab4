package com.ews.web_seller_test.controller.user;

import com.ews.web_seller_test.dao.impl.UserDaoImpl;
import com.ews.web_seller_test.model.User;
import com.ews.web_seller_test.until.TestDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminAddUserTest extends TestDriver {
    private final UserDaoImpl userDao = new UserDaoImpl();

    @BeforeEach
    void beforeEach() throws SQLException {
        resetTable();
    }

    private void loginAndNavigateToUserPage(ChromeDriver driver) {
        driver.get("http://localhost:9999/web_seller_test_war_exploded/login");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("a");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("a");
        driver.findElement(By.id("loginBtn")).click();
        driver.findElement(By.id("btn-user")).click();
    }

    private void assertUserNames(List<WebElement> users, String... expectedNames) {
        Assertions.assertNotNull(users);
        Assertions.assertEquals(expectedNames.length, users.size());
        for (int i = 0; i < users.size(); i++) {
            assertTrue(users.get(i).getText().contains(expectedNames[i]));
        }
    }

    @Test
    void testAddValidUser() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("b");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("b");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("b");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("b");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("b");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("b");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Add assertions to verify the user has been added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a", "b");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(2, listAllUsers.size());
        driver.close();
    }


    // Test adding a user with over the limit username
    @Test
    void testAddUserOverLimitUsername() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(generateData('b', 51));  // Assuming the limit is 50
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("b");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("b");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("b");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("b");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("b");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Check for validation error or no new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }

    // Test adding a user with over the limit password
    @Test
    void testAddUserOverLimitPassword() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("b");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(generateData('b', 33));  // Assuming the limit is 50
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("b");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("b");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("b");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("b");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Check for validation error or no new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }

    // Test adding a user with over the limit full name
    @Test
    void testAddUserOverLimitFullName() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("b");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("b");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys(generateData('b', 51));  // Assuming the limit is 50
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("b");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("b");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("b");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Check for validation error or no new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }

    // Test adding a user with over the limit phone
    @Test
    void testAddUserOverLimitPhone() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("b");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("b");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("b");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys(generateData('b', 21));  // Assuming the limit is 20
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("b");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("b");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Check for validation error or no new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }

    // Test adding a user with over the limit address
    @Test
    void testAddUserOverLimitAddress() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("b");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("b");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("b");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("b");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys(generateData('b', 201));  // Assuming the limit is 200
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("b");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Check for validation error or no new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }

    // Test adding a user with over the limit email
    @Test
    void testAddUserOverLimitEmail() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("b");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("b");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("b");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("b");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("b");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(generateData('b', 151));  // Assuming the limit is 150
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Check for validation error or no new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }

    // Test adding a user with no fields added
    @Test
    void testAddUserNoFields() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        driver.findElement(By.id("btn-create")).click();

        // Check for validation error or no new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }

    // Test adding a user with maximum length for all fields
    @Test
    void testAddUserMaxLengthAllFields() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(generateData('b', 50));
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(generateData('b', 32));
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys(generateData('b', 50));
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys(generateData('b', 20));
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys(generateData('b', 200));
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(generateData('b', 150));
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();

        // Check for the new user added
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a", generateData('b', 50));
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(2, listAllUsers.size());
        driver.close();
    }

    // Test adding a duplicate user
    @Test
    void testAddDuplicateUser() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        // Adding the first user
        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("a");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("a");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("a");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("a");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("a");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("a");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());
        driver.close();
    }
    @Test
    void testAddDuplicateUsername() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToUserPage(driver);

        // Adding the first user
        driver.findElement(By.id("btn-user-add")).click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("a");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("b");
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("b");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("b");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("b");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("b");
        WebElement gender = driver.findElement(By.id("inlineRadio1"));
        gender.click();  // Select Male

        driver.findElement(By.id("btn-create")).click();
        // Check that no new user was added due to duplicate username
        List<WebElement> users = driver.findElements(By.cssSelector(".gradeX"));
        assertUserNames(users, "a");
        List<User> listAllUsers = userDao.getAllUser();
        Assertions.assertEquals(1, listAllUsers.size());

        driver.close();
    }
    // Reset User table and insert initial users
    private void resetTable() throws SQLException {
        userDao.connection.prepareStatement("TRUNCATE TABLE User").executeUpdate();

        String insertUserA = "INSERT INTO User (id, full_name, email, phone, address, username, password, gender, avatar, role_id, created_at, updated_at) VALUES (1, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 1, now(), now())";

        userDao.connection.prepareStatement(insertUserA).executeUpdate();
    }

    @SuppressWarnings("SameParameterValue")
    private String generateData(char character, int length) {
        return String.valueOf(character).repeat(Math.max(0, length));
    }
}
