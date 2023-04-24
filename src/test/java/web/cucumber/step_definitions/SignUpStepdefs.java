package web.cucumber.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import web.cucumber.pages.AccountInfoPage;
import web.cucumber.pages.HomePage;
import web.cucumber.pages.SignUpPage;
import web.cucumber.util.AutomationWebsiteUtil;

public class SignUpStepdefs {
  private static WebDriver driver;

  private static ChromeDriverService service;
  private static final String DRIVER_LOCATION = "src\\test\\resources\\chromedriver.exe";

  private HomePage homePage;
  private SignUpPage signUpPage;
  private AccountInfoPage accountInfoPage;

  @Before("@jr")
  public void setup(){
    service = AutomationWebsiteUtil.getChromeDriverService(DRIVER_LOCATION);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(service, options);
  }
  @Given("I am on the main page")
  public void iAmOnTheMainPage() {
    homePage=new HomePage(driver);
  }

  @When("I click on the Signup link")
  public void iClickOnTheSignupLink() {
    signUpPage=homePage.goToSignUpPage();
  }

  @Then("I should go to the Signup page")
  public void iShouldGoToTheSignupPage() {
    Assertions.assertEquals("https://automationexercise.com/login", signUpPage.getUrl());
  }

  @Given("I am on the sign up page")
  public void iAmOnTheSignUpPage() {
    signUpPage=new SignUpPage(driver);
    signUpPage.gotToSignUpPage();
  }

  @When("I enter details")
  public void iEnterDetails() {
  }

  @Then("I should go to the account information page")
  public void iShouldGoToTheAccountInformationPage() {
  }

  @After("@jr")
  public void tearDown(){
    driver.close();
    driver.quit();
  }
}
