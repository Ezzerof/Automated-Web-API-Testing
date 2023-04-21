package web.cucumber.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver webDriver;
    private final By productsPage = new By.ByXPath("//a[@href='/products']");
    private final By cartPage = new By.ByXPath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
    private final By loginPage = new By.ByXPath("//a[normalize-space()='Signup / Login']");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToHomePage();
    }

    private void goToHomePage() {
        webDriver.get("https://automationexercise.com/");
    }

    public ProductsPage goToProductsPage() {
        webDriver.findElement(productsPage).click();
        return new ProductsPage(webDriver);
    }

    public CartPage goToCartPage() {
        webDriver.findElement(cartPage).click();
        return new CartPage(webDriver);
    }

    public LoginPage goToLoginPage() {
        webDriver.findElement(loginPage).click();
        return new LoginPage(webDriver);
    }


}
