package web.cucumber.pages;

import org.openqa.selenium.WebDriver;

public class AccountInfoPage {

  private final WebDriver webDriver;

  public AccountInfoPage(WebDriver webDriver) {
    this.webDriver=webDriver;
  }

  public String getUrl() {
    return webDriver.getCurrentUrl();
  }
}
