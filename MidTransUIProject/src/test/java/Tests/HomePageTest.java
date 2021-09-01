package Tests;

import Base.BaseTest;
import Utility.Constants;
import Utility.ElementUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyIsTextDisplayedTest(){
        Assert.assertTrue(homepage.isWrittenTextDisplayed());
    }

    @Test(priority = 3)
    public void verifyPillowIsAddedToCartWithAmount() {
        //Thread.sleep(3000);
        //ElementUtils.holdExecutionForFewSeconds(2000);
        homepage.clickOnBuyNow();
        //Thread.sleep(4000);
        Assert.assertEquals(homepage.getElementTextForPillow(),Constants.PILLOW_AMOUNT);
        //Assert.assertTrue(homepage.getVisibleTextForPillow());
    }

    @Test(priority = 2)
    public void verifyClickingOnBuyNowRedirectsUserToPopUpWindowTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        Assert.assertTrue(homepage.elementIsVisible());
        //ElementUtils.holdExecutionForFewSeconds(1500);
        Thread.sleep(3000);
        Assert.assertEquals(homepage.getElementTextForPillow(),Constants.PILLOW_AMOUNT);
    }

    @Test(priority = 4)
    public void verifyBuyNowButtonRedirectsToCheckOutPopUpTest(){
       homepage.clickOnBuyNow();
       Assert.assertEquals(homepage.getAccountSectionsList(),Constants.getAccountSectionList());
    }

    @Test(priority = 5)
    public void verifyUserShouldBeAbleToEnterDetailsTest(){
        homepage.clickOnBuyNow();
        homepage.enterDetailsOfName(prop.getProperty("name"));
        homepage.enterDetailsOfEmail(prop.getProperty("email"));
        homepage.enterDetailsOfPhone(prop.getProperty("phone_no"));
        homepage.enterDetailsOfCity(prop.getProperty("city"));
        homepage.enterDetailsOfAddress(prop.getProperty("address"));
        homepage.enterDetailsOfPostalcode(prop.getProperty("postal_code"));
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        Assert.assertTrue(homepage.isDisplayedCocostoreElement(),"Element not found");
    }

    @Test(priority = 6)
    public void verifyOrderSummaryPopUp(){
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        //ElementUtils.holdExecutionForFewSeconds(3000);
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        Assert.assertEquals(homepage.getElementItemNameValue(),Constants.ITEM_NAME);
        Assert.assertEquals(homepage.getElementPriceValue(),Constants.ITEM_PRICE);
    }

    @Test(priority = 7)
    public void verifyClickingOnContinueBtnRedirectsUserToPaymentPage(){
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        //ElementUtils.holdExecutionForFewSeconds(3000);
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        //Thread.sleep(3000);
        homepage.clickOnContinueButton();
        //homepage.navigateToFrame();
        //ElementUtils.holdExecutionForFewSeconds(3000);
        //Thread.sleep(3000);
        //homepage.navigateToFrameTwo();
        Assert.assertTrue(homepage.isDisplayedSelectPaymentElement(),"SelectPayment element not found");
        //Assert.assertEquals(homepage.getElementSelectPaymentValue(),Constants.SELECT_PAYMENT);
    }

    @Test(priority = 8)
    public void verifyPaymentSectionListTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        homepage.clickOnContinueButton();
        //homepage.navigateToFrameTwo();
        //Thread.sleep(3000);
        //ElementUtils.holdExecutionForFewSeconds(3000);
        Assert.assertEquals(homepage.getPaymentList(),Constants.getPaymentSectionList(),"Values not matching");
    }

    @Test(priority = 9)
    public void verifyClickingOnCreditCardRedirectsToPaymentPageTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        //ElementUtils.holdExecutionForFewSeconds(3000);
        homepage.clickOnCheckOutButton();
        homepage.navigateToFrame();
        //Thread.sleep(3000);
        homepage.clickOnContinueButton();
        //Thread.sleep(3000);
        homepage.clickOnCreditCard();
        //Thread.sleep(2000);
        Assert.assertTrue(homepage.isDisplayedElementOnCreditCardPayment(),"Element not Visible");
    }

    @Test(priority = 10)
    public void verifyClickingOnCheckBoxDiscountedValueShouldAppear() throws InterruptedException {
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        //Thread.sleep(3000);
        homepage.clickOnContinueButton();
        //Thread.sleep(3000);
        homepage.clickOnCreditCard();
        homepage.clickOnDiscountCheckbox();
        Assert.assertEquals(homepage.getTextOfDiscountedValue(),Constants.DISCOUNTED_PRICE);
    }

    @Test(priority = 11)
    public void verifyAfterDetailsUserShouldRedirectsToNewPageTest() throws InterruptedException {
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        //Thread.sleep(3000);
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        //Thread.sleep(3000);
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));
        homepage.clickOnPayNowButton();
        Thread.sleep(3000);
        Assert.assertTrue(homepage.isDisplayedElementOnCreditCardPayment());
        //Assert.assertEquals(homepage.getTextForElementIssuingBank(),Constants.ISSUING_BANK);
    }

    @Test(priority = 12)
    public void verifyVisibilityOfElementsOnOTPPage(){
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        //Thread.sleep(3000);
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        //Thread.sleep(3000);
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));

        homepage.clickOnPayNowButton();

        Assert.assertEquals(homepage.getTextForElementMerchant(),Constants.MERCHANT_NAME);
        Assert.assertEquals(homepage.getTextForElementAmount(),Constants.AMOUNT);
        Assert.assertEquals(homepage.getTextForElementTransaction(),Constants.TRANSACTION);
        Assert.assertEquals(homepage.getTextForElementCardNumber(),Constants.CARDNO);
    }

    @Test(priority = 13)
    public void verifyFailedStatusMessageShouldBeVisible() throws InterruptedException {
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        //Thread.sleep(3000);
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        //Thread.sleep(3000);
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));

        homepage.clickOnPayNowButton();
        homepage.enterOTP(prop.getProperty("otpfield1"));
        homepage.clickOnOkButton();
        Thread.sleep(5000);
        //Assert.assertEquals(homepage.getTextForElementFailedStatusMsg(),Constants.FAILED_STATUS);
        Assert.assertTrue(homepage.isTextOfFailedStatusMsgDisplayed());
    }

    @Test(priority = 14)
    public void verifyClickingOnCancelBtnFailedStatusMessageShouldBeVisible(){
        homepage.clickOnBuyNow();
        //Thread.sleep(3000);
        homepage.clickOnCheckOutButton();
        //Thread.sleep(3000);
        homepage.navigateToFrame();
        //Thread.sleep(3000);
        homepage.clickOnContinueButton();
        homepage.clickOnCreditCard();
        //Thread.sleep(3000);
        homepage.enterDetailsOfCreditCard(prop.getProperty("cardnumber"), prop.getProperty("expirydate"), prop.getProperty("cvv"));

        homepage.clickOnPayNowButton();
        //homepage.enterOTP(prop.getProperty("otpfield1"));
        //homepage.navigateToFrame();
        homepage.clickOnCancelButton();
        //Thread.sleep(3000);
        //Assert.assertEquals(homepage.getTextForElementFailedStatusMsg(),Constants.FAILED_STATUS);
        Assert.assertTrue(homepage.isTextOfFailedStatusMsgDisplayed());
    }

    public void verifyPillowIsAddedToCart(){
        homepage.clickOnBuyNow();
        homepage.clickOnCheckOutButton();
    }

   /* @Test
    public void verifyPopUpWindowTest(){
        homepage.clickOnBuyNow();
        Assert.assertEquals(homepage.getAccountSectionCounts(),Constants.ELEMENTS_COUNTS);
    }*/
}
