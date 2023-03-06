package pages.decemberLabs;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.TimeSeconds;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(className = "content_logo")
    private WebElement iconDecemberLabsLocator;

    @FindBy(id = "menu-item-839")
    private WebElement aboutLocator;

    @FindBy(id = "menu-item-846")
    private WebElement getInTouchLocator;

    //Get in touch form
    @FindBy(id = "wpforms-872-field_0")
    private WebElement nameFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_1")
    private WebElement emailFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_6")
    private WebElement companyFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_3_1")
    private WebElement approxBudget25kFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_3_2")
    private WebElement approxBudget25k50kFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_3_3")
    private WebElement approxBudget50k100kFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_3_4")
    private WebElement approxBudget100k200kFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_3_5")
    private WebElement approxBudget200kFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_2")
    private WebElement messageFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_5_1")
    private WebElement herAboutUsGoogleFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_5_6")
    private WebElement herAboutUsSocialFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_5_7")
    private WebElement herAboutClutchFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_5_8")
    private WebElement herAboutRecommendationFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_5_9")
    private WebElement herAboutEventsFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_5_10")
    private WebElement herAboutWorldOfMouthFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_5_11")
    private WebElement herAboutOtherFormGetInTouchLocator;

    @FindBy(id = "wpforms-872-field_7_1")
    private WebElement checkBoxFormGetInTouchLocator;

    @FindBy(id = "wpforms-submit-872")
    private WebElement sendButtonFormGetInTouchLocator;

    //
    @FindBy(xpath = "//p[@class='row big_text']")
    private WebElement firstMessageLocator;

    @FindBy(xpath = "//p[@class='row small_text']")
    private WebElement secondMessageLocator;

    @FindBy(xpath = "//a[@class='button btn-close-modal-success']")
    private WebElement okButtonLocator;

    @FindBy(xpath = "//div[@class='wpforms-error-container'][2]")
    private List<WebElement> googleReCaptchaLocator;

    @FindBy(id = "wpforms-form-872")
    private List<WebElement> formModalLocator;

    @FindBy(xpath = "//div[@class='btn-close-modal'][1]")
    private WebElement closeModalLocator;

    @FindBy(xpath = "(//a[@class='city'])[1]")
    private WebElement austinLocationLocator;


    //Methods
    public void clickGetInTouch() {
        geteWait().until(ExpectedConditions.elementToBeClickable(getInTouchLocator));
        getInTouchLocator.click();
        errorModalNotOpen();
    }

    public void clickIconDecemberLabs() {
        geteWait().until(ExpectedConditions.elementToBeClickable(iconDecemberLabsLocator));
        iconDecemberLabsLocator.click();
        utils.timeUtil.timeOut(TimeSeconds.TWO_SECOND);
    }

    public void inputName(String name){
        geteWait().until(ExpectedConditions.elementToBeClickable(nameFormGetInTouchLocator));
        nameFormGetInTouchLocator.clear();
        nameFormGetInTouchLocator.sendKeys(name);
    }

    public void inputEmail(String email){
        geteWait().until(ExpectedConditions.elementToBeClickable(emailFormGetInTouchLocator));
        emailFormGetInTouchLocator.clear();
        emailFormGetInTouchLocator.sendKeys(email);
    }

    public void inputCompany(String company){
        geteWait().until(ExpectedConditions.elementToBeClickable(companyFormGetInTouchLocator));
        companyFormGetInTouchLocator.clear();
        companyFormGetInTouchLocator.sendKeys(company);
    }

    public void inputLongMessage(String longMessage){
        geteWait().until(ExpectedConditions.elementToBeClickable(messageFormGetInTouchLocator));
        messageFormGetInTouchLocator.clear();
        messageFormGetInTouchLocator.sendKeys(longMessage);
    }
    public String getFirstMessage(){
        geteWait().until(ExpectedConditions.visibilityOf(firstMessageLocator));
        String messageFromWeb = firstMessageLocator.getText();
        System.out.println("Message ::" + messageFromWeb);
        return messageFromWeb;
    }

    public String getSecondMessage(){
        geteWait().until(ExpectedConditions.visibilityOf(secondMessageLocator));
        String messageFromWeb = secondMessageLocator.getText();
        System.out.println("Message ::" + messageFromWeb);
        return messageFromWeb;
    }

    public void selectBudgetBellow25k(){
        System.out.println("Selected: below $25k");
        approxBudget25kFormGetInTouchLocator.click();
    }

    public void selectBudget25k50k(){
        System.out.println("Selected: $25k-$50k");
        approxBudget25k50kFormGetInTouchLocator.click();
    }

    public void selectBudget50k100k(){
        System.out.println("Selected: $50k-$100k");
        approxBudget50k100kFormGetInTouchLocator.click();
    }

    public void selectBudget100k200k(){
        System.out.println("Selected: $100k-$200k");
        approxBudget100k200kFormGetInTouchLocator.click();
    }

    public void selectBudgetAbove200k(){
        System.out.println("Selected: above 200k ");
        approxBudget200kFormGetInTouchLocator.click();
    }
    public void clickOkButton(){
        geteWait().until(ExpectedConditions.elementToBeClickable(okButtonLocator));
        okButtonLocator.click();
    }

    public void selectHearAboutGoogle(){
        herAboutUsGoogleFormGetInTouchLocator.click();
    }

    public void selectHearAboutSocial(){
        herAboutUsSocialFormGetInTouchLocator.click();
    }

    public void selectHearAboutClutch(){
        herAboutClutchFormGetInTouchLocator.click();
    }

    public void selectHearAboutRecommendation(){
        herAboutRecommendationFormGetInTouchLocator.click();
    }

    public void selectHearAboutEvents(){
        herAboutEventsFormGetInTouchLocator.click();
    }

    public void selectHearAboutWordOfMouth(){
        herAboutWorldOfMouthFormGetInTouchLocator.click();
    }

    public void selectHearAboutOther(){
        herAboutOtherFormGetInTouchLocator.click();
    }

    public void clickCheckBox(){
        checkBoxFormGetInTouchLocator.click();
    }

    public void selectRandomBudget(){
        Random random = new Random();
        String randomCase = String.valueOf(random.nextInt(5) + 1);
        switch (randomCase){
            case "1":
                System.out.println("case 1: " +randomCase);

                selectBudgetBellow25k();
                break;

            case "2":
                System.out.println("case 2: " +randomCase);

                selectBudget25k50k();
                break;

            case "3":
                System.out.println("case 3: " +randomCase);

                selectBudget50k100k();
                break;

            case "4":
                System.out.println("case 4: " +randomCase);

                selectBudget100k200k();
                break;

            case "5":
                System.out.println("case 5: " +randomCase);

                selectBudgetAbove200k();
                break;

            default:
                break;
        }
    }

    public void selectRandomHearAboutUs(){
        Random random = new Random();
        int randomCase = random.nextInt(7) + 1;
        switch (randomCase){
            case 1:
                selectHearAboutGoogle();
                break;

            case 2:
                selectHearAboutSocial();
                break;

            case 3:
                selectHearAboutClutch();
                break;

            case 4:
                selectHearAboutRecommendation();
                break;

            case 5:
                selectHearAboutEvents();
                break;

            case 6:
                selectHearAboutWordOfMouth();
                break;

            case 7:
                selectHearAboutOther();
                break;

            default:
                break;
        }
    }


    public void selectRandomParameter(String name, String email, String company, String longMessage){
        Random random = new Random();
        int randomCase = random.nextInt(4) + 1;
        switch (randomCase){
            case 1:
                inputName(name);
                break;

            case 2:
                inputEmail(email);
                break;

            case 3:
                inputCompany(company);
                break;

            case 4:
                inputLongMessage(longMessage);
                break;
            default:
                break;
        }
    }

    public String getAttributeName(){
        return getWebElementAttribute(nameFormGetInTouchLocator,"aria-invalid");
    }

    public String getAttributeEmail(){
        return getWebElementAttribute(emailFormGetInTouchLocator,"aria-invalid");
    }

    public String getAttributeCompany(){
        return getWebElementAttribute(companyFormGetInTouchLocator,"aria-invalid");
    }

    public String getAttributeMessage(){
        return getWebElementAttribute(messageFormGetInTouchLocator,"aria-invalid");
    }
    public void clickSendButton(){
        utils.timeUtil.timeOut(TimeSeconds.ONE_SECOND);
        geteWait().until(ExpectedConditions.elementToBeClickable(sendButtonFormGetInTouchLocator));
        sendButtonFormGetInTouchLocator.click();
        errorMessageCaptcha();
    }

    public void errorMessageCaptcha(){
        for(int i = 0; i < 7 ; i++ ) {
            if (!googleReCaptchaLocator.isEmpty()) {
                utils.timeUtil.timeOut(TimeSeconds.THREE_SECOND);
                System.out.println("intento numero " + i);
                clickSendButton();
            }else {
                break;
            }
        }
    }

    public void errorModalNotOpen(){
        for(int i = 0; i < 2 ; i++ ) {
            if (formModalLocator.isEmpty()) {
                utils.timeUtil.timeOut(TimeSeconds.ONE_SECOND);
                clickGetInTouch();
            }else {
                break;
            }
        }
    }

    public void closeModal(){
        geteWait().until(ExpectedConditions.elementToBeClickable(closeModalLocator));
        closeModalLocator.click();
    }
    public void sleep(){
        utils.timeUtil.timeOut(TimeSeconds.THREE_SECOND);
    }

    public LocationAustinPage clickAustinLocation(){
        geteWait().until(ExpectedConditions.elementToBeClickable(austinLocationLocator));
        austinLocationLocator.click();
        return new LocationAustinPage(getDriver());
    }

    public boolean validateNavBarIsDisplayed(){
        geteWait().until(ExpectedConditions.elementToBeClickable(aboutLocator));
        try {
            return aboutLocator.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String getActualUrl(){
        return driver.getCurrentUrl();
    }
}
