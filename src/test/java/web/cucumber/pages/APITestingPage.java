package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class APITestingPage {
    private final WebDriver driver;

    public APITestingPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
