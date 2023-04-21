package web.cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import web.cucumber.pom.pages.CartPage;
import web.cucumber.pom.pages.HomePage;
import web.cucumber.pom.pages.LoginPage;
import web.cucumber.pom.pages.ProductsPage;
import web.cucumber.util.AutomationWebsiteUtil;

public class MyStepdefs {
    private static WebDriver webDriver;
    private static ChromeDriverService service;
    private static final String DRIVER_LOCATION = "src\\test\\resources\\chromedriver.exe";

    private HomePage homePage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private LoginPage loginPage;

    @Before
    public void setup() {
        service = AutomationWebsiteUtil.getChromeDriverService(DRIVER_LOCATION);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(service, chromeOptions);

    }

    @After
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
        service.stop();
    }

}
