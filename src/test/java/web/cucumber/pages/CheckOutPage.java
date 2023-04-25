package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    private final WebDriver webDriver;

    public CheckOutPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void enterDescription(String description) {
        webDriver.findElement(By.xpath("textarea[name='message']")).sendKeys(description);

    }
    public void clickOnPlaceOrder(){
        webDriver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
    }
}
