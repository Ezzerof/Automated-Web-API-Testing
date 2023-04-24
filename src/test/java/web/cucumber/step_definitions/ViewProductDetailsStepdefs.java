package web.cucumber.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import web.cucumber.pages.HomePage;
import web.cucumber.pages.ProductsPage;
import web.cucumber.util.AutomationWebsiteUtil;

public class ViewProductDetailsStepdefs {

    private static WebDriver webDriver;
    private static ChromeDriverService service;
    private HomePage homePage;
    private ProductsPage productsPage;

    private WebSiteNavigation webSiteNavigation;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @Before
    public void setup() {
        service = AutomationWebsiteUtil.getChromeDriverService(DRIVER_LOCATION);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(service, chromeOptions);
        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
        service.stop();

    }

    @Given("I am on the automation exercise website")
    public void iAmOnTheAutomationExerciseWebsite() {
        homePage = new HomePage(webDriver);
    }

    @When("User clicks {string} of first product")
    public void userClicksViewProductOfFirstProduct() {
        productsPage = homePage.goToProductsPage();
    }

    @Then("User should be in the product detail page")
    public void userShouldBeInTheProductDetailPage() {

    }

    @And("The following are visible : product name, category, price, availability, condition, brand")
    public void theFollowingAreVisibleProductNameCategoryPriceAvailabilityConditionBrand() {
    }
}
