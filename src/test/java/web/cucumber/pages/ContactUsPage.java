package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
