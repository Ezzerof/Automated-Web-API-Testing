package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class VideoTutorialsPage {
    private final WebDriver driver;

    public VideoTutorialsPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
    public String getTitle(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }
}
