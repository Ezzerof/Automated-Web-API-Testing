package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver webDriver;
    private final By popUpWindow = new By.ByXPath("//div[@class='modal-content']");
    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    private void clickByXpath(By xpath) {
        webDriver.findElement(xpath);
    }

    public String getTextFromField(String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }

    private void clickByXpath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public int numberOfProductsInCart() {
        return webDriver.findElements(By.xpath("//td[@class='cart_description']")).size();
    }

    public CheckOutPage clickOnProceedToCheckoutButton() {
        webDriver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
        return new CheckOutPage(webDriver);
    }


    public void waitForElementTobeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));


    }

    public String getLinkOncheckOutPopUP() {
        waitForElementTobeVisible(popUpWindow);
       return webDriver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).getText();

    }

    public void clickOnRegisterLoginLink() {
         webDriver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
    }
}
