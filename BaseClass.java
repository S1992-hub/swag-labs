package com.Swag.labs.testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BaseClass {
    ExtentReports extentReports;
@DataProvider(name = "ValidCred")
    public Object[][] getValidCredentials()
    {
        return new Object[][]
                {
                        {"standard_user","secret_sauce"},
                        {"locked_out_user","secret_sauce"},
                        {"problem_user","secret_sauce"}
                };
    }

    @DataProvider(name = "InvalidCred")
    public Object[][] getInvalidCredentials()
    {
        return new Object[][]
                {
                        {"standard","secret"},
                        {"locked_user","secretSauce"},
                        {"problem","sauce"}
                };
    }
    @DataProvider(name = "invUservaPsw")
    public Object[][] getInvaliduservalpw()
    {
        return new Object[][]
                {
                        {"standard","secret_sauce"},
                        {"locked_user","secret_sauce"},
                        {"problem","secret_sauce"}
                };
    }
    @DataProvider(name = "vauserInvalpsw")
    public Object[][] getValuserInvalPsw()
    {
        return new Object[][]
                {
                        {"standard_user","secretsauce"},
                        {"locked_out_user","sauce"},
                        {"problem_user","secret"}
                };
    }
    @BeforeSuite
    public void reporting()
    {
        long timestamp=System.currentTimeMillis();
        ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\User\\IdeaProjects\\SeleniumMavenProject\\Reports\\swag-labs-report_" + timestamp + ".html");
        extentReports =new ExtentReports();
        extentReports.attachReporter(reporter);

    }
    @AfterSuite

public void writeReport()
    {
        extentReports.flush();
    }

    public String captureScreenshot(WebDriver driver) {
        long timestamp = System.currentTimeMillis();
        TakesScreenshot ts = (TakesScreenshot) driver;//typecasting the driver object
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\User\\IdeaProjects\\SeleniumMavenProject\\src\\main\\resources\\Screenshots\\screenshot_" + timestamp + ".jpg");
        try {
            FileUtils.copyFile(source,destination);
            return destination.getAbsolutePath();
        } catch (IOException e) {
            System.err.println("Unable to capture the screenshot");
            return "";
        }

}
        }


