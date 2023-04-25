package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class AccountDeletionPage {
    WebDriver webDriver;

    public AccountDeletionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}