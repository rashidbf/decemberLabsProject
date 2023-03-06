package tests;

import driver.MyDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.decemberLabs.HomePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    protected static MyDriver myDriver;

    protected HomePage homePage;

    @BeforeSuite(alwaysRun =true)
    @Parameters({"browser","url"})
    public void beforeSuite(String browser, String url){
        myDriver = new MyDriver(browser);
        myDriver.getDriver().get(url);
        myDriver.getDriver().manage().window().maximize();
        homePage = new HomePage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        homePage.dispose();
    }

    public String getScreenShot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/test-output/failedTestsScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalDestination.getParentFile().getName() + "/" + finalDestination.getName();
    }
}

