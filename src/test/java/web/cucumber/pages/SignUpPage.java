package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class SignUpPage {

  private final WebDriver webDriver;

  public SignUpPage(WebDriver webDriver) {
    this.webDriver=webDriver;
  }

  public String getUrl() {
    return webDriver.getCurrentUrl();
  }

  public void gotToSignUpPage() {
    webDriver.get("https://automationexercise.com/login");
  }
}