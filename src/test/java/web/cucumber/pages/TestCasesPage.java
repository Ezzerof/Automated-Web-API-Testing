package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    private final WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
       return driver.getCurrentUrl();
    }
    public String getTitle(){
        return driver.getTitle();
    }
}
