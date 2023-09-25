package com.Swag.labs.testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.saucedemonew.listener.Retry;
import com.saucedemonew.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class LogInTC extends BaseClass{
   //ExtentReports extentReports;
    //ExtentTest extentTest=new ExtentTest;
        /*public static void main(String[] args) {

        LogInTC logInTC = new LogInTC();
        logInTC.TC1_login_with_valid_username_and_valid_psw();
        logInTC.TC2_login_with_valid_username_and_invalid_psw();
        logInTC.TC3_login_with_invalid_username_and_valid_psw();
        logInTC.TC4_login_with_invalid_username_and_invalid_psw();
        logInTC.TC5_login_with_empty_username_and_empty_psw();

    }*/

    ThreadLocal<WebDriver> webDriverThreadLocal=new ThreadLocal<>();

    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
   // WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod
    public  void initBrowser(@Optional(value = "chrome") String browsername)
    {
        if(browsername.equals("chrome")) {
            System.out.println("5");
            webDriverThreadLocal.set(new ChromeDriver());
             WebDriver driver = webDriverThreadLocal.get();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

@Test(dataProvider =  "ValidCred")//,//retryAnalyzer = Retry.class)//Thread-0

        public void TC1_login_with_valid_username_and_valid_psw(String username,String psw)
        {
            extentTest.set(extentReports.createTest("TC1_login_with_valid_username_and_valid_psw"));
            extentTest.get().info("TC1 started");

            webDriverThreadLocal.get();
            LogInPage log = new LogInPage(webDriverThreadLocal.get());
            //captureScreenshot(webDriverThreadLocal.get());
            extentTest.get().info("Login Page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
            log.login(username,psw);
            //Assert.fail();
            extentTest.get().info("Login Successfully",MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
            captureScreenshot(webDriverThreadLocal.get());
            extentTest.get().info("Opened inventory page");
            extentTest.get().info("TC1 Completed");
            extentTest.get().pass("TC1_login_with_valid_username_and_valid_psw  passed");
        }

        @Test(dataProvider = "vauserInvalpsw")//Thread-1
       public void TC2_login_with_valid_username_and_invalid_psw(String user,String Psw)
       {

        //
           extentTest.set(extentReports.createTest("TC2_login_with_valid_username_and_invalid_psw"));
           extentTest.get().info("TC2 started");
           webDriverThreadLocal.get();
        LogInPage log = new LogInPage(webDriverThreadLocal.get());
           extentTest.get().info("Login Page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());

           log.login(user,Psw);
           extentTest.get().info("Login failed Successfully", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        log.verifyerorMsg();
           extentTest.get().info("TC2 Completed");
           extentTest.get().pass("TC2_login_with_valid_username_and_invalid_psw  passed");
        //driver.quit();
       }
@Test(dataProvider = "invUservaPsw")//Thread-2
       public void TC3_login_with_invalid_username_and_valid_psw(String user,String pw)
       {
           extentTest.set(extentReports.createTest("TC3_login_with_invalid_username_and_valid_psw"));
           extentTest.get().info("TC3 started");

       // driver.get("https://www.saucedemo.com/");
        LogInPage log = new LogInPage(webDriverThreadLocal.get());
           extentTest.get().info("Login Page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());

           log.login(user,pw);
           extentTest.get().info(" Login Page failed successfully", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
           extentTest.get().info("TC3 Completed");
           extentTest.get().pass("TC3_login_with_invalid_username_and_valid_psw  passed");
           //driver.quit();
       }
       @Test(dataProvider = "InvalidCred")
       public void TC4_login_with_invalid_username_and_invalid_psw(String user,String pw)
       {
           extentTest.set(extentReports.createTest("TC4_login_with_invalid_username_and_invalid_psw"));
           extentTest.get().info("TC4 started");

       // driver.get("https://www.saucedemo.com/");
        LogInPage log = new LogInPage(webDriverThreadLocal.get());
           extentTest.get().info("Login Page", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());

           log.login(user,pw);
           extentTest.get().info(" Login Page failed successfully", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
           extentTest.get().info("TC4 Completed");
           extentTest.get().pass("TC4_login_with_invalid_username_and_invalid_psw  passed");
           //driver.quit();
       }
       @Test
    public void TC5_login_with_empty_username_and_empty_psw()
    {
        extentTest.set(extentReports.createTest("TC5_login_with_empty_username_and_empty_psw"));
        extentTest.get().info("TC5 started");

        //driver.get("https://www.saucedemo.com/");
        LogInPage log = new LogInPage(webDriverThreadLocal.get());
        extentTest.get().info(" Page opened successfully", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());

        log.login(" "," ");
        log.verify_emptyelements_erorMsg();
        extentTest.get().info(" Login Page failed successfully", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        extentTest.get().info("TC5 Completed");
        extentTest.get().pass("TC5_login_with_empty_username_and_empty_psw  passed");
        //driver.quit();
    }
    @AfterMethod
    public void closeBrowser(ITestResult result)
    {
        if (result.getStatus()==ITestResult.FAILURE)
        {
            extentTest.get().fail("TC Failed", MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(webDriverThreadLocal.get())).build());
        }
        webDriverThreadLocal.get().quit();
    }
    }




