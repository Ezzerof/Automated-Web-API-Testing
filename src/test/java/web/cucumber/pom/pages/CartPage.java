package web.cucumber.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void clickByXpath(By xpath) {
        webDriver.findElement(xpath);
    }

    public String getTextFromField(String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }

    public void clickByXpath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }
}
