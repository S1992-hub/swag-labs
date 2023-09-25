package com.Swag.labs.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.saucedemonew.pages.CartPage;
import com.saucedemonew.pages.InventoryPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class CartTC extends BaseClass {
   /* public static void main(String[] args) {

        CartTC cartTC=new CartTC();
        cartTC.Tc1_item_added_or_not();
        //cartTC.TC2_item_price_checking();
        cartTC.TC3_check_again_products();
        cartTC.TC4_checkout_pages();
    }*/
   ThreadLocal<WebDriver> webDriverThreadLocal=new ThreadLocal<>();

    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

    WebDriver driver;
    @Parameters({"Browser"})
    @BeforeMethod
    public void initBrowser(@Optional(value = "chrome") String browswerName)
    {
        if (browswerName.equals("chrome")) {
            webDriverThreadLocal.set(new ChromeDriver()) ;
            WebDriver driver=webDriverThreadLocal.get();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }
    @Test
        public void Tc1_item_added_or_not()
    {
        webDriverThreadLocal.get();
        extentTest.set(extentReports.createTest("Tc1_item_added_or_not"));
        extentTest.get().info("TC1_Cartmodule Started");
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        inventoryPage1.addProduct(inventoryPage1.bikelight);
        extentTest.get().info("Inventory page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        CartPage page1=new CartPage(driver);
        page1.VerufyproductAdded(page1.backPacklocator);
        extentTest.get().info("Check item add or not page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        extentTest.get().pass("Tc1_item_added_or_not passed");


    }
    /*public void TC2_item_price_checking()
    {
        WebDriver driver = new ChromeDriver();
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        CartPage cartPage=new CartPage(driver);
        cartPage.Verufy_product_price();


    }*/
    @Test
    public void TC3_check_again_products()
    {
        extentTest.set(extentReports.createTest("TC3_check_again_products"));
        extentTest.get().info("TC3_Cartmodule Started and check again item added or not");

        InventoryPage inventoryPage1 = new InventoryPage(driver);
        inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        inventoryPage1.addProduct(inventoryPage1.bikelight);
        extentTest.get().info("Inventory page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());

        CartPage page1=new CartPage(driver);
        page1.VerufyproductAdded(page1.backPacklocator);
        page1.continue_check_pdt();
        extentTest.get().info("continue to choose product in page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());

    }
    @Test
    public void TC4_checkout_pages()
    {
        extentTest.set(extentReports.createTest("TC4_checkout_pages"));
        extentTest.get().info("TC4_Cartmodule Started and checkout pages",MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        inventoryPage1.addProduct(inventoryPage1.bikelight);
        CartPage page1=new CartPage(driver);
        page1.VerufyproductAdded(page1.backPacklocator);
        extentTest.get().info("Checkout page",MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        page1.checkOut();
    }
    @AfterMethod
    public void closeBrowser()//(ITestResult result)
    {
        /*if (result.getStatus()== ITestResult.FAILURE)
        {
            extentTest.get().fail("TC Failed");
        }*/
        driver.quit();
    }
}

//https://github.com/S1992-hub/swag-labs.git
C:\Users\User\IdeaProjects


