package web.cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import web.cucumber.pom.pages.HomePage;
import web.cucumber.pom.pages.ProductsPage;
import web.cucumber.util.AutomationWebsiteUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchProductStepdefs {

    private static WebDriver webDriver;
    private static ChromeDriverService service;
    private static final String DRIVER_LOCATION = "src\\test\\resources\\chromedriver.exe";

    private HomePage homePage;
    private ProductsPage productsPage;

    @Before
    public void setup() {
        service = AutomationWebsiteUtil.getChromeDriverService(DRIVER_LOCATION);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(service, chromeOptions);
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
        service.stop();
    }


    @Given("I am on the Home Page")
    public void iAmOnTheHomePage() {
        homePage = new HomePage(webDriver);
    }


    @When("I click on the Products button")
    public void iClickOnTheProductsButton() {
        productsPage = homePage.goToProductsPage();
    }

    @Then("I will go to the Products page")
    public void iWillGoToTheProductsPage() {
        assertEquals(productsPage.getTitle(), "Automation Exercise - All Products");
    }

    @And("I click on the search bar")
    public void iClickOnTheSearchBar() {
        productsPage.clickOnSearchBar();
    }

    @And("Enter {string} and press enter")
    public void enterAndPressEnter(String arg0) {
        productsPage.searchForAndPressEntre(arg0);
    }

    @Then("I will go to Dress page") // will not go as Enter button does not work!
    public void iWillGoToDressPage() {
        assertEquals("https://automationexercise.com/products?search=Dress", productsPage.getUrl());
    }

    @And("Enter {string} on search bar")
    public void enterOnSearchBar(String arg0) {
        productsPage.searchFor(arg0);
    }

    @And("Press on search button")
    public void pressOnSearchButton() {
        productsPage.clickOnSearchButton();
    }

    @Given("I am on the Product page")
    public void iAmOnTheProductPage() {
        productsPage = homePage.goToProductsPage();
    }

    @When("I press search button")
    public void iPressSearchButton() {
        productsPage.clickOnSearchButton();
    }

    @Then("I should send empty query")
    public void iShouldSendEmptyQuery() {
        assertEquals(productsPage.getUrl(), "https://automationexercise.com/products?search=");
    }
}
