package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

//    public void enterUserDetailsAndLogin(String email, String password) {
//        webDriver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("Example@123");
//        webDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Example@123");
//        webDriver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//    }

}
