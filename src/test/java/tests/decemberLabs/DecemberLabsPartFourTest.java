package tests.decemberLabs;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.decemberLabs.LocationAustinPage;
import tests.BaseTest;

public class DecemberLabsPartFourTest extends BaseTest {

    @Test
    @Parameters({"url","expectedUrl", "expectedTitle"})
    public void austinPage(String url, String expectedUrl, String expectedTitle){
        boolean topMenu = homePage.validateNavBarIsDisplayed();
        String actualHomePageUrl = homePage.getActualUrl();
        Assert.assertEquals(actualHomePageUrl,url);
        Assert.assertTrue(topMenu);
        LocationAustinPage locationAustinPage = homePage.clickAustinLocation();
        String actualUrl = locationAustinPage.getActualUrl();
        String actualTitle = locationAustinPage.getActualTitle();
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        locationAustinPage.clickScheduleFreeConsultation();
        boolean popUpCalendarIsOpen = locationAustinPage.validatePopUpCalendarIsDisplayed();
        Assert.assertTrue(popUpCalendarIsOpen);
        locationAustinPage.closePopUpCalendar();
        boolean popUpCalendarIsClosed = locationAustinPage.validatePopUpCalendarIsClosed();
        Assert.assertTrue(popUpCalendarIsClosed);


    }
}
