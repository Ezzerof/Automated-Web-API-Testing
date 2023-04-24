package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class SignInPage {
    private final WebDriver webDriver;

    public SignInPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
