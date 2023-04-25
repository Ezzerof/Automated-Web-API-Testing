package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreatedPage {
    private final WebDriver webDriver;


    public AccountCreatedPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void waitForElementTobeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

}
