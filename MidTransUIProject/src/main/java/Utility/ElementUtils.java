package Utility;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementUtils extends BasePage {

    public  WebDriver driver;


    //Constructor
    public ElementUtils(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method is used to get WebElements from Web Page.
     * @param locator
     * @return it returns WebElements.
     */
    public WebElement getElement(By locator) {
        waitForElementPresent(locator,1000);
        WebElement element;
        element = driver.findElement(locator);
        return element;
    }

    /**
     * This method is used to get list of WebElements
     * @param locator
     * @return it returns list of WebElements
     */
    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList =
                driver.findElements((By) locator);
        return elementsList;
    }


    public WebElement waitForElementPresent(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public WebElement waitForElementToBeVisible(By locator, int timeout) {
        WebElement element = getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public void doSendKeys(By locator, String value) {
        waitForElementPresent(locator, 3000);
        //getElement(locator).clear();
        //getElement(locator).sendKeys(value);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void doClick(By locator) {
        //waitForElementPresent(locator, 2000);
        waitForElementToBeClickable(locator,3000);
        getElement(locator).click();
    }

    public String doGetText(By locator) {
        waitForElementPresent(locator, 3000);
        return getElement(locator).getText();
    }

    public boolean doIsDisplayed(By locator) {
        waitForElementPresent((By) locator, 3000);
        return getElement((By) locator).isDisplayed();
    }

    public void switchToFrame(By locator){
        waitForElementPresent((By) locator, 3000);
        driver.switchTo().frame(driver.findElement(locator));
    }

    public int getCount(By locator){
        int size = driver.findElements(locator).size();
        return size;
    }

    public String getElementText(By locator){
        String textvalue = getElement(locator).getText();
        System.out.println(textvalue);
        return textvalue;
    }

    public void holdExecutionForSeconds(int seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }
    }

        public static void holdExecutionForFewSeconds(int seconds) {
            try {
                Thread.sleep((long)(seconds * 1000));
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
    }

}
