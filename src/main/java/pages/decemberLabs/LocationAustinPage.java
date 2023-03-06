package pages.decemberLabs;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.TimeSeconds;

public class LocationAustinPage extends BasePage {
    public LocationAustinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='buttons']")
    private WebElement scheduleFreeConsultationLocator;

    @FindBy(xpath = "(//div[@class='dl-modal-content'])[1]")
    private WebElement popUpCalendarLocator;

    @FindBy(xpath = "(//div[@class='btn-close-modal'])[1]")
    private WebElement closePopUpCalendarLocator;

    public String getActualUrl(){
        return driver.getCurrentUrl();
    }

    public String getActualTitle(){
        return driver.getTitle();
    }

    public void clickScheduleFreeConsultation(){
        geteWait().until(ExpectedConditions.elementToBeClickable(scheduleFreeConsultationLocator));
        scheduleFreeConsultationLocator.click();
    }

    public boolean validatePopUpCalendarIsDisplayed(){
        geteWait().until(ExpectedConditions.elementToBeClickable(popUpCalendarLocator));
        try {
            return popUpCalendarLocator.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean validatePopUpCalendarIsClosed() {
        utils.timeUtil.timeOut(TimeSeconds.TWO_SECOND);
        try {
            return !popUpCalendarLocator.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void closePopUpCalendar(){
        closePopUpCalendarLocator.click();
    }

}
