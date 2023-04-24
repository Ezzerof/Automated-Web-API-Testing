package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class SignInPage {
    private final WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
