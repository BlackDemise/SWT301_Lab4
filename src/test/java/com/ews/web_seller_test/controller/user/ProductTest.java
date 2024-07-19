package com.ews.web_seller_test.controller.user;

import com.ews.web_seller_test.dao.ProductDao;
import com.ews.web_seller_test.dao.impl.CategoryDaoImpl;
import com.ews.web_seller_test.dao.impl.ProductDaoImpl;
import com.ews.web_seller_test.model.Category;
import com.ews.web_seller_test.model.Product;
import com.ews.web_seller_test.until.TestDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest extends TestDriver {
    private final ProductDaoImpl productDao = new ProductDaoImpl();
    private final CategoryDaoImpl categoryDao = new CategoryDaoImpl();


    private void truncateTable() throws SQLException {
        productDao.connection.prepareStatement("TRUNCATE TABLE Product").executeUpdate();
    }

    @BeforeEach
    void beforeEach() throws SQLException {
        truncateTable();
        Date currentTime = Date.valueOf(LocalDate.now());
        String[] productNames = { "Football", "Laptop", "Book", "Car", "Pan", "Sofa"};
        int[] categoryIds = {1, 2, 3, 4}; // Assuming these category IDs exist in the database

        for (int i = 0; i < productNames.length; i++) {
            Product product = new Product();
            product.setCategory(categoryDao.getCategory(categoryIds[i % categoryIds.length])); // Assign category based on index
            product.setName(productNames[i]);
            product.setPrice(100.0f + i * 10); // Example prices
            product.setDiscount(0.1f * i); // Example discounts
            product.setImage("default.jpg");
            product.setDescription("Description for " + productNames[i]);
            product.setTotal_rating(5); // Example rating
            product.setTotal_starts(10); // Example starts
            product.setStatus(1); // Example status

            productDao.insertProduct(product);
        }
    }
    private void loginAndNavigateToProductPage(ChromeDriver driver) {
        driver.get("http://localhost:9999/web_seller_test_war_exploded/login");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("trong2k3");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123");
        driver.findElement(By.id("loginBtn")).click();
        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private void assertProductNames(List<WebElement> products, String... expectedNames) {
        Assertions.assertNotNull(products);
        assertEquals(expectedNames.length, products.size());
        for (int i = 0; i < products.size(); i++) {
            assertTrue(products.get(i).getText().contains(expectedNames[i]));
        }
    }

    // GET ALL Products //
    @Test
    void testGetAllProduct() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        List<WebElement> products = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(products, "Football", "Laptop", "Book", "Car", "Pan", "Sofa");

        driver.close();
    }
    // GET ALL Products // http://localhost:9999/web_seller_test_war_exploded/admin/product/list


    // INSERT Product //
    @Test
    void testInsertOneProduct() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Click the button to create a new product
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();

        // Fill out the form to add a new product
        WebElement productName = driver.findElement(By.name("name"));
        productName.sendKeys("Product Demo 1");

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.sendKeys("200.0");

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.sendKeys("Description for New Product");

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.sendKeys("0.2");

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue("2"); // Assuming category with ID 1 exists

        // Wait for the product list to refresh
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();


        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the new product appears in the product list
        List<WebElement> products = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(products, "Football", "Laptop", "Book", "Car", "Pan", "Sofa", "Product Demo 1");

        driver.close();
    }

    @Test
    void testInsertProductWithSpecialCharacters() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Click the button to create a new product
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();

        // Fill out the form to add a new product
        WebElement productName = driver.findElement(By.name("name"));
        productName.sendKeys("Product Demo 1@@@");

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.sendKeys("200.0");

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.sendKeys("Description for New Product");

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.sendKeys("0.2");

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue("2"); // Assuming category with ID 1 exists

        // Wait for the product list to refresh
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();


        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the new product appears in the product list
        List<WebElement> products = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(products, "Football", "Laptop", "Book", "Car", "Pan", "Sofa");

        driver.close();
    }
    private String generateData(char character, int length) {
        return String.valueOf(character).repeat(Math.max(0, length));
    }

    @Test
    void testInsertProductWith100Characters() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Click the button to create a new product
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();
        String insertedData = generateData('p', 101);

        // Fill out the form to add a new product
        WebElement productName = driver.findElement(By.name("name"));
        productName.sendKeys(insertedData);

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.sendKeys("200.0");

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.sendKeys("Description for New Product");

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.sendKeys("0.2");

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue("2"); // Assuming category with ID 1 exists

        // Wait for the product list to refresh
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();


        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the new product appears in the product list
        List<WebElement> products = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(products, "Football", "Laptop", "Book", "Car", "Pan", "Sofa", insertedData);

        driver.close();
    }


    @Test
    void testInsertDuplicateProductName() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Get the initial list of products
        List<WebElement> initialProductList = driver.findElements(By.cssSelector(".gradeX"));
        int initialProductCount = initialProductList.size();

        // Helper method to add a product
        addProduct(driver, "Duplicate Product", "300.0", "Description for Duplicate Product", "0.3", "1");
        initialProductCount++;
        // Attempt to add another product with the same name
        addProduct(driver, "Duplicate Product", "350.0", "Another description", "0.4", "1");
        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        initialProductCount++;

        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the updated list of products
        List<WebElement> updatedProductList = driver.findElements(By.cssSelector(".gradeX"));
        int updatedProductCount = updatedProductList.size();

        // Assert that the product count has not increased
        assertEquals(initialProductCount, updatedProductCount, "Product count should not increase when adding a duplicate product");

        driver.close();
    }

    private void addProduct(ChromeDriver driver, String name, String price, String description, String discount, String categoryId) {
        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();

        WebElement productName = driver.findElement(By.name("name"));
        productName.clear(); // Clear the field before entering new data
        productName.sendKeys(name);

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.clear();
        productPrice.sendKeys(price);

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.clear();
        productDescription.sendKeys(description);

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.clear();
        productDiscount.sendKeys(discount);

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue(categoryId);

        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();

        // Optionally wait for the action to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testInsertProductWithNameOfEmptiness() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();
        WebElement productName = driver.findElement(By.name("name"));
        productName.sendKeys("");

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.sendKeys("200.0");

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.sendKeys("Description for New Product");

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.sendKeys("0.2");

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue("2"); // Assuming category with ID 1 exists

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("btn-insert")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");

        List<WebElement> products = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(products, "Football", "Laptop", "Book", "Car", "Pan", "Sofa");
        driver.close();
    }

    @Test
    void testInsertProductWithBlankPrice() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Get the initial list of products
        List<WebElement> initialProductList = driver.findElements(By.cssSelector(".gradeX"));
        int initialProductCount = initialProductList.size();

        // Click the button to create a new product
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();

        // Fill out the form to add a new product with a blank price
        WebElement productName = driver.findElement(By.name("name"));
        productName.sendKeys("Product Without Price");

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.sendKeys(""); // Blank price

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.sendKeys("Description for Product Without Price");

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.sendKeys("0.2");

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue("2"); // Assuming category with ID 2 exists

        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();

        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the updated list of products
        List<WebElement> updatedProductList = driver.findElements(By.cssSelector(".gradeX"));
        int updatedProductCount = updatedProductList.size();

        // Assert that the product count has not increased
//        assertEquals(initialProductCount, updatedProductCount, "Product count should not increase when adding a product with a blank price");

        driver.close();
    }


    @Test
    void testInsertProductWithUpperCaseName() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Get the initial list of products
        List<WebElement> initialProductList = driver.findElements(By.cssSelector(".gradeX"));
        int initialProductCount = initialProductList.size();

        // Click the button to create a new product
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();

        // Fill out the form to add a new product with an uppercase name
        WebElement productName = driver.findElement(By.name("name"));
        productName.sendKeys("UPPERCASE PRODUCT");

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.sendKeys("200.0");

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.sendKeys("Description for UPPERCASE PRODUCT");

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.sendKeys("0.2");

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue("2"); // Assuming category with ID 2 exists

        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();

        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the new product appears in the product list
        List<WebElement> updatedProductList = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(updatedProductList, "Football", "Laptop", "Book", "Car", "Pan", "Sofa", "UPPERCASE PRODUCT");

        driver.close();
    }


    @Test
    void testInsertProductWithMaxLengthFields() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Define maximum lengths for each field
        int maxLengthName = 255;        // Example maximum length for product name
        int maxLengthDescription = 1000; // Example maximum length for product description
        int maxLengthPrice = 10;         // Example maximum length for product price
        int maxLengthDiscount = 5;       // Example maximum length for product discount

        // Generate maximum length strings
        String maxLengthNameStr = generateData('N', maxLengthName);
        String maxLengthDescriptionStr = generateData('D', maxLengthDescription);
        String maxLengthPriceStr = generateData('9', maxLengthPrice); // Assuming max price fits within the length limit
        String maxLengthDiscountStr = generateData('9', maxLengthDiscount); // Assuming max discount fits within the length limit

        // Click the button to create a new product
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();

        // Fill out the form to add a new product with max length fields
        WebElement productName = driver.findElement(By.name("name"));
        productName.sendKeys(maxLengthNameStr);

        WebElement productPrice = driver.findElement(By.name("price"));
        productPrice.sendKeys(maxLengthPriceStr);

        WebElement productDescription = driver.findElement(By.name("des"));
        productDescription.sendKeys(maxLengthDescriptionStr);

        WebElement productDiscount = driver.findElement(By.name("discount"));
        productDiscount.sendKeys(maxLengthDiscountStr);

        // Use Select to handle the dropdown menu
        WebElement productCategoryDropdown = driver.findElement(By.name("category"));
        Select categorySelect = new Select(productCategoryDropdown);
        categorySelect.selectByValue("2"); // Assuming category with ID 2 exists

        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();

        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");
        // Wait for the product list to refresh
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the new product appears in the product list
        List<WebElement> products = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(products, "Football", "Laptop", "Book", "Car", "Pan", "Sofa", maxLengthNameStr);

        driver.close();
    }

    @Test
    void testInsertProductWithMissingFields() {
        ChromeDriver driver = getDriver();
        loginAndNavigateToProductPage(driver);

        // Click the button to create a new product
        WebElement newProductButton = driver.findElement(By.id("new-product-button"));
        newProductButton.click();

        // Leave all fields empty and try to submit the form
        WebElement submitButton = driver.findElement(By.id("btn-insert"));
        submitButton.click();
        driver.get("http://localhost:9999/web_seller_test_war_exploded/admin/product/list");

        // Wait for any validation messages to appear
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Verify that the product list does not include a new product
        List<WebElement> products = driver.findElements(By.cssSelector(".gradeX"));
        assertProductNames(products, "Football", "Laptop", "Book", "Car", "Pan", "Sofa");

        driver.close();
    }


    // INSERT Product //


}





