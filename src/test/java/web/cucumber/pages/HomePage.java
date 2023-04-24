package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        goToHomePage();

    }

    public void goToHomePage() {
        driver.get("https://automationexercise.com");
    }

    public ProductsPage goToProductsPage() {
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        return new ProductsPage(driver);
    }
    public CartPage goToCartPage(){
        driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        return new CartPage(driver);
    }
    public SignInPage goToSignInPage(){
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        return new SignInPage(driver);
    }

    public TestCasesPage goToTestCasesPage(){
        driver.findElement(By.xpath("//a[normalize-space()='Test Cases']")).click();
        return new TestCasesPage(driver);
    }


    public APITestingPage goToAPITestingPage(){
        driver.findElement(By.xpath("//a[normalize-space()='API Testing']")).click();
        return new APITestingPage(driver);
    }

    public VideoTutorialsPage goToVideoTutorialsPage(){
        driver.findElement(By.xpath("//a[normalize-space()='Video Tutorials']")).click();
        return new VideoTutorialsPage(driver);
    }

    public ContactUsPage goToContactUsPage(){
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
        return new ContactUsPage(driver);
    }



}
