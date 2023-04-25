package web.cucumber.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_tw.並且;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import web.cucumber.pages.HomePage;
import web.cucumber.util.AutomationWebsiteUtil;

public class SubscriptionStepdefs {

    private static WebDriver webDriver;
    private static ChromeDriverService service;
    private static final String DRIVER_LOCATION = "src\\test\\resources\\chromedriver.exe";

    private HomePage homePage;

    @Before
    public void setup(){
        service = AutomationWebsiteUtil.getChromeDriverService(DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(service, options);
        webDriver.manage().window().maximize();

        homePage = new HomePage(webDriver);
    }

    @And("I scroll down to the footer")
    public void iScrollDownToTheFooter() {
        homePage.getContentOfFooterElementH2();
    }

    @And("I can see the {string} message")
    public void iCanSeeTheSUBSCRIPTIONMessage() {
        String message = homePage.getContentOfFooterElementH2();
        Assertions.assertEquals("SUBSCRIPTION",message);
    }

    @When("I input my email details in the input box")
    public void iInputMyEmailDetailsInTheInputBox() {
        homePage.enterEmailInFooter("testemail123@gmail.com");
    }

    @And("click the arrow button")
    public void clickTheArrowButton() {
        homePage.clickArrowSubmitButton();
    }

    @Then("I should see a success popup message")
    public void iShouldSeeASuccessPopupMessage() {
    }
}
