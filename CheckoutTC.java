package com.Swag.labs.testCases;

import com.saucedemonew.pages.CartPage;
import com.saucedemonew.pages.CheckOutPage;
import com.saucedemonew.pages.InventoryPage;
import com.saucedemonew.pages.LogInPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CheckoutTC {
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod
    public void initbrowser(@Optional(value = "chrome") String broswername)
    {
        if(broswername.equals("chrome")) {
            driver = new ChromeDriver();
        }
    }


@Test
    public void enter_details()
    {
        //driver = new ChromeDriver();
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        inventoryPage1.addProduct(inventoryPage1.bikelight);
        inventoryPage1.addProduct(inventoryPage1.fleeceJacket);
        System.out.println("products added succesfully to cart=passed");

        CartPage cartPage=new CartPage(driver);
        cartPage.VerufyproductAdded(cartPage.backPacklocator);
        cartPage.checkOut();

        CheckOutPage checkOutPage=new CheckOutPage(driver);
        checkOutPage.fill_details("Anu","Pillai","260037");


    }
    @Test
    public void TC2_add_item_amounts()
    {
        //driver = new ChromeDriver();
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        // inventoryPage.verify_title();
        inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        inventoryPage1.addProduct(inventoryPage1.bikelight);
       inventoryPage1.addProduct(inventoryPage1.fleeceJacket);
        System.out.println("products added succesfully to cart=passed");

        CartPage cartPage=new CartPage(driver);
        cartPage.VerufyproductAdded(cartPage.backPacklocator);
       // cartPage.VerufyproductAdded(cartPage.backPacklocator);
        cartPage.checkOut();

        CheckOutPage checkOutPage=new CheckOutPage(driver);
        checkOutPage.fill_details("Anu","Pillai","260037");

        CheckOutPage checkOutPage1=new CheckOutPage(driver);
        checkOutPage1.add_item_price();

    }
    @Test
    public void Tc_3_adding_tax_with_total_amount()

    {
        //driver = new ChromeDriver();
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        // inventoryPage.verify_title();
        inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        inventoryPage1.addProduct(inventoryPage1.bikelight);
        inventoryPage1.addProduct(inventoryPage1.fleeceJacket);
        System.out.println("products added succesfully to cart=passed");

        CartPage cartPage=new CartPage(driver);
        cartPage.VerufyproductAdded(cartPage.backPacklocator);
        // cartPage.VerufyproductAdded(cartPage.backPacklocator);
        cartPage.checkOut();

        CheckOutPage checkOutPage=new CheckOutPage(driver);
        checkOutPage.fill_details("Anu","Pillai","260037");

        CheckOutPage checkOutPage1=new CheckOutPage(driver);
        checkOutPage1.calculateTotal();
    }
    @Test
    public void Tc_without_adding_any_product()
    {
        //driver = new ChromeDriver();
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        // inventoryPage.verify_title();
        //inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        //inventoryPage1.addProduct(inventoryPage1.bikelight);
        //inventoryPage1.addProduct(inventoryPage1.fleeceJacket);
        //System.out.println("products added succesfully to cart=passed");



        CheckOutPage checkOutPage=new CheckOutPage(driver);
        checkOutPage.check_empty_cart_page();
        CartPage cartPage=new CartPage(driver);
        //cartPage.VerufyproductAdded(cartPage.backPacklocator);
        checkOutPage.check_empty_cart_page();
        cartPage.checkOut();
        checkOutPage.fill_details("Anu","Pillai","260037");
        System.out.println("No items are selected");
        //cartPage.VerufyproductAdded(cartPage.backPacklocator);
        checkOutPage.verify_withoutelement();
    }
@Test
    public void TC4_finish()
    {
        //driver = new ChromeDriver();

        InventoryPage inventoryPage1 = new InventoryPage(driver);
        // inventoryPage.verify_title();
        //inventoryPage1.addProduct(inventoryPage1.backpackAddtocartButton);
        //inventoryPage1.addProduct(inventoryPage1.bikelight);
        //inventoryPage1.addProduct(inventoryPage1.fleeceJacket);
        //System.out.println("products added succesfully to cart=passed");



        CheckOutPage checkOutPage=new CheckOutPage(driver);
        checkOutPage.check_empty_cart_page();
        CartPage cartPage=new CartPage(driver);
        //cartPage.VerufyproductAdded(cartPage.backPacklocator);
        checkOutPage.check_empty_cart_page();
        cartPage.checkOut();
        checkOutPage.fill_details("Anu","Pillai","260037");
        System.out.println("No items are selected");
        //cartPage.VerufyproductAdded(cartPage.backPacklocator);
        checkOutPage.verify_withoutelement();
        checkOutPage.finish();

    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
