package web.cucumber.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.cucumber.pages.CartPage;
import web.cucumber.pages.HomePage;
import web.cucumber.pages.ProductsPage;

import java.time.Duration;

public class ViewProductDetailsStepdefs {
    private static WebDriver driver;
    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    private final By adWindow = new By.ById("//u[normalize-space()='View Cart']");
    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();

    }
    @Given("I am on the automation exercise homepage")
    public void iAmOnTheAutomationExerciseHomepage() {
        homePage = new HomePage(driver);
    }

    @When("I click on the products page")
    public void iClickOnTheProductsPage() {
        productsPage = homePage.goToProductsPage();
    }


    @Then("I navigate to products page")
    public void iNavigateToProductsPage() {
    }

}
