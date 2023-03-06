package tests.decemberLabs;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DecemberLabsPartOneTest extends BaseTest {

    @Test(priority = 1)
    @Parameters({"name","email","company","longMessage","firstMessage","secondMessage"})
    public void completeFormGetInTouchRequireParameters(String name, String email, String company, String longMessage, String firstMessage, String secondMessage) {
        homePage.clickGetInTouch();
        homePage.inputName(name);
        homePage.inputEmail(email);
        homePage.inputCompany(company);
        homePage.inputLongMessage(longMessage);
        homePage.clickCheckBox();
        homePage.clickSendButton();
        String firstMessageFromWeb = homePage.getFirstMessage();
        Assert.assertEquals(firstMessage,firstMessageFromWeb);
        String secondMessageFromWeb = homePage.getSecondMessage();
        Assert.assertEquals(secondMessage,secondMessageFromWeb);
        homePage.clickOkButton();
        homePage.clickIconDecemberLabs();
    }

    @Test(priority = 2)
    @Parameters({"name","email","company","longMessage","firstMessage","secondMessage"})
    public void completeFormGetInTouchAllParameters(String name, String email, String company, String longMessage, String firstMessage, String secondMessage) {
        homePage.clickIconDecemberLabs();
        homePage.clickGetInTouch();
        homePage.inputName(name);
        homePage.inputEmail(email);
        homePage.inputCompany(company);
        homePage.selectRandomBudget();
        homePage.inputLongMessage(longMessage);
        homePage.selectRandomHearAboutUs();
        homePage.clickCheckBox();
        homePage.clickSendButton();
        String firstMessageFromWeb = homePage.getFirstMessage();
        Assert.assertEquals(firstMessage,firstMessageFromWeb);
        String secondMessageFromWeb = homePage.getSecondMessage();
        Assert.assertEquals(secondMessage,secondMessageFromWeb);
        homePage.clickOkButton();
        homePage.clickIconDecemberLabs();
    }

    @Test(priority = 2)
    @Parameters({"name","email"})
    public void incompleteFormGetInTouchRequireParameters(String name, String email) {
        homePage.clickIconDecemberLabs();
        homePage.clickGetInTouch();
        homePage.inputName(name);
        homePage.inputEmail(email);
        homePage.clickCheckBox();
        homePage.clickSendButton();
        String attributeName = homePage.getAttributeName();
        String attributeEmail = homePage.getAttributeEmail();
        String attributeCompany = homePage.getAttributeCompany();
        String attributeMessage = homePage.getAttributeMessage();
        Assert.assertEquals(attributeName, "false", "Assert for name is failed");
        Assert.assertEquals(attributeEmail, "false","Asser for email is failed");
        Assert.assertNull(attributeCompany);
        Assert.assertNull(attributeMessage);
        homePage.closeModal();
        homePage.clickIconDecemberLabs();
    }
}
