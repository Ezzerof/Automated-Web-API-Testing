package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private final WebDriver webDriver;

    public ContactUsPage(WebDriver driver) {
        this.webDriver=driver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
