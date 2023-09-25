package com.Swag.labs.testCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.saucedemonew.pages.InventoryPage;
import com.saucedemonew.pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

public class InventoryTC extends BaseClass {
    /*public static void main(String[] args) throws InterruptedException {
        InventoryTC inventoryTC = new InventoryTC();
       inventoryTC.Tc1_addProducts_to_the_cart();
       inventoryTC.TC2_remove_Item_from_cart();
       inventoryTC.Tc3_printlists_from_inventory_page();
       inventoryTC.Tc4_selectitem_from_inventory_page_menulist();
       inventoryTC.Tc6_sortproduct_ascending_way();
      inventoryTC.TC7_sortPrice();
        inventoryTC.Tc8_sortproduct_descending_way();
        inventoryTC.TC7_sortPrice_descend();
    }*/
    ThreadLocal<WebDriver> webDriverThreadLocal=new ThreadLocal<>();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod
    public void initbrowse(@Optional(value = "chrome") String browsername)
    {
        if(browsername.equals("chrome"))
        {
             driver = new ChromeDriver();
        }
    }


    @Test
    public void Tc1_addProducts_to_the_cart() throws InterruptedException {

        extentTest.set(extentReports.createTest("Tc1_addProducts_to_the_cart"));
        extentTest.get().info("Inventory module TC started");
        InventoryPage inventoryPage = new InventoryPage(driver);
        // inventoryPage.verify_title();
        inventoryPage.addProduct(inventoryPage.backpackAddtocartButton);
        inventoryPage.addProduct(inventoryPage.bikelight);
        inventoryPage.addProduct(inventoryPage.fleeceJacket);
        extentTest.get().info("Products added to the cart");//, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        System.out.println("products added succesfully to cart=passed");
        extentTest.get().info("TC_Inentory Completed");
        extentTest.get().pass("Tc1_addProducts_to_the_cart");
    }
@Test
    public void TC2_remove_Item_from_cart() {
    extentTest.set(extentReports.createTest("TC2_remove_Item_from_cart"));
    extentTest.get().info("Inventory module TC started");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProduct(inventoryPage.backpackAddtocartButton);
        inventoryPage.addProduct(inventoryPage.bikelight);
        inventoryPage.addProduct(inventoryPage.fleeceJacket);
        inventoryPage.removefromCart(inventoryPage.rmovItem_backpack);
    extentTest.get().info("Item removal successfully Completed");
    extentTest.get().info("TC_Inentory Completed");
    extentTest.get().pass("TC2_remove_Item_from_cart Passed");
        //inventoryPage.removefromCart(inventoryPage.rmovItem_bikelight);
        //inventoryPage.removefromCart(inventoryPage.rmovItem_fleeceJacket);

    }
@Test
    public void Tc3_printlists_from_inventory_page() {
      extentTest.set(extentReports.createTest("Tc3_printlists_from_inventory_page"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        try {
            inventoryPage.showitemlist();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        extentTest.get().info("list of items printed");
    }
    @Test
    public void Tc4_selectitem_from_inventory_page_menulist() throws InterruptedException {
        extentTest.set(extentReports.createTest("Tc4_selectitem_from_inventory_page_menulist"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.selectitemlist_from_menu();
        extentTest.get().info("dsplaying the menu list items in inventory page");
        extentTest.get().pass("Tc4_selectitem_from_inventory_page_menulist passed");
    }

   @Test
    public void Tc5_verifying_title_of_inventory_page() throws InterruptedException {
        extentTest.set(extentReports.createTest("Tc5_verifying_title_of_inventory_page"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.verify_title();
        extentTest.get().info("Title verified successfully");
        extentTest.get().pass("Tc5_verifying_title_of_inventory_page  passes");
    }
@Test
    public  void Tc6_sortproduct_ascending_way()
    {
        extentTest.set(extentReports.createTest("Tc6_sortproduct_ascending_way"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProducts("lohi","Price (low to high)");
        extentTest.get().info("products are sorted in ascending order");
        extentTest.get().pass("Tc6_sortproduct_ascending_way passed");
    }


    @Test
    public void TC7_sortPrice()
    {
        extentTest.set(extentReports.createTest("TC7_sortPrice"));
        extentTest.get().info("Sorting the products by price wise");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProducts("lohi","Price (low to high)");
        inventoryPage.verifyAscendingOrder();
        extentTest.get().info("Product sorted by price wise successfully");
        extentTest.get().pass("TC7_sortPrice  passed");

    }
    @Test
    public  void Tc8_sortproduct_descending_way()
    {

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProducts("hilo","Price (high to low)");
       // inventoryPage.verifyDescendingOrder();
    }
@Test
    public void TC7_sortPrice_descending()
    {

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProducts("lohi","Price (low to high)");
        inventoryPage.verifyAscendingOrder();


    }
    @Test
    public void TC7_sortPrice_descend()
    {

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sortProducts("lohi","Price (low to high)");
        inventoryPage.verifyDescendingOrder();


    }

    @AfterMethod
    public void closewindo()
    {
        driver.quit();
    }

}
