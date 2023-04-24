package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver=driver;
    }
    public String getUrl(){
      return  driver.getCurrentUrl();


    }
}
