package web.cucumber.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.cucumber.pages.*;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class RegisterWhileCheckOutStepDefs {
    private HomePage homePage;
    private WebDriver webDriver;
    private CartPage cartPage;
    private ProductsPage productsPage;
    private SignInPage signInPage;
   private AccountCreationPage accountCreationPage;
    private CheckOutPage checkOutPage;
    private PaymentPage paymentPage;
    private LoginPage loginPage;
   private SignUpPage signUpPage;
    private AccountDeletionPage accountDeletionPage;
    private final By popUpWindow = new By.ByXPath("//div[@class='modal-content']");
  //  private CartPageStepdefs cartPageStepdefs=new CartPageStepdefs(webDriver);
    Logger logger;
    private static final String DRIVER_LOCATION="src/test/resources/chromedriver";
private static By addToCartButton=new By.ByXPath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]");

    @Before("@Ag")
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.manage().window().maximize();

    }

    @Given("Iam on HomePage of automation exercise")
    public void iamOnHomePageOfAutomationExercise() {
        homePage = new HomePage(webDriver);


    }

    @When("I click on add to cart option")
    public void iClickOnAddToCartOption() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productsPage = homePage.goToProductsPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollTo(0, 600)");


        // productsPage.waitForElementTobeVisible(addToCartButton);


        productsPage.clickOnAddToCart();

       // productsPage.clickOnAddToCartOverlay("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]","a.add-to-cart");

        }


    @Then("products should be added to the cart")
    public void productsShouldBeAddedToTheCart() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals("Added!",productsPage.getPoppedUpText());

    }

    @When("I click on cart page")
    public void iClickOnCartPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//       productsPage.waitForElementTobeVisible(popUpWindow);
//        Set<String> windows=webDriver.getWindowHandles();
//        Iterator<String> iterator=windows.iterator();
//        String parentId=iterator.next();
//        String childId=iterator.next();
//        webDriver.switchTo().window(childId);

        productsPage.clickViewCartLink();


    }

    @Then("I can navigate to cart page")
    public void iCanNavigateToCartPage() {
        cartPage=homePage.goToCartPage();
        Assertions.assertEquals("https://automationexercise.com/view_cart",cartPage.getUrl());
    }
    @And("I can see the added products")
    public void iCanSeeTheAddedProducts() {
        Assertions.assertEquals(1,cartPage.numberOfProductsInCart());
    }



    @When("I click on proceed to checkout")
    public void iClickOnProceedToCheckout() {
        cartPage.clickOnProceedToCheckoutButton();
    }

    @Then("It should show Register_login button")
    public void itShouldShowRegister_loginButton() {
        Assertions.assertEquals("Register / Login",cartPage.getLinkOncheckOutPopUP());
    }


    @When("I click on Register_login button")
    public void iClickOnRegister_loginButton() {
        cartPage.clickOnRegisterLoginLink();

    }

    @Then("It should navigate to login page")
    public void itShouldNavigateToLoginPage() {
        Assertions.assertEquals("https://automationexercise.com/login",webDriver.getCurrentUrl());
    }



    @When("I enter UserName and Email")
    public void iEnterUserNameAndEmail() {
        loginPage=homePage.goToLoginPage();
        loginPage.enterUserDetailsForSignUp("Manusri","manusri@gmail.com");

    }

    @And("I click on Signup button")
    public void iClickOnSignupButton() {
        signUpPage =loginPage.goToSignUpPage();

    }

    @Then("It should navigate to signup page")
    public void itShouldNavigateToSignupPage() {
        //signUpPage = homePage.goToSignUpPage();
       Assertions.assertEquals("https://automationexercise.com/signup", signUpPage.getUrl());
        //System.out.println("Current Page:" +webDriver.getCurrentUrl());

    }




    @When("I enter All Details")
    public void iEnterAllDetails(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        signUpPage.fillAllRequiredFieldsInForm("Manusri","manusri@123","Gampa","56","Telangana","Hyderabad","555555","3039303930");
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollTo(0, 1000)");

    }

    @And("I click on create account button")
    public void iClickOnCreateAccountButton() {
    accountCreationPage=signUpPage.clickOnCreateAccountButton();
//        try {
//            Thread.sleep(500);
//            accountCreationPage = signUpPage.createAccount();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }



    @Then("It should show  ACCOUNT CREATED! and click Continue button")
    public void itShouldShowACCOUNTCREATEDAndClickContinueButton() {
//        try {
//            Thread.sleep(1000);
//            accountCreationPage = signUpPage.createAccount();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Assertions.assertEquals("https://automationexercise.com/account_created",accountCreationPage.getUrl());
//        try {
//            Alert alert = webDriver.switchTo().alert();
//            String alertText = alert.getText();
//            alert.dismiss();
//        } catch (NoAlertPresentException e) {
//          e.printStackTrace();
//        }
       Assertions.assertEquals("ACCOUNT CREATED!",webDriver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).getText());
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollTo(0, 500)");
       webDriver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
//        try {
//            Thread.sleep(500);
//            homePage = accountCreationPage.continueToHomePage();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @And("it should show Logged in as username at top")
    public void itShouldShowLoggedInAsUsernameAtTop() {
        Assertions.assertEquals("https://automationexercise.com/",webDriver.getCurrentUrl());
    }


    @When("I click on Cart button")
    public void iClickOnCartButton() {
      cartPage= homePage.goToCartPage();
    }

    @And("click on Proceed To Checkout' button")
    public void clickOnProceedToCheckoutButton() {

        checkOutPage= cartPage.clickOnProceedToCheckoutButton();
    }

    @Then("It should show Address Details and Review Your Order")
    public void itShouldShowAddressDetailsAndReviewYourOrder() {
     String showedMobileNumber= webDriver.findElement(By.className("address_phone")).getText();
     String givenMobileNumber="3039303930";
        Assertions.assertEquals(givenMobileNumber,showedMobileNumber);
   }



    @When("I Enter description in comment text area and click Place Order")
    public void iEnterDescriptionInCommentTextAreaAndClickPlaceOrder() {
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollTo(0,500)");
        checkOutPage.enterDescription("Hi! I love this application...");
       paymentPage= checkOutPage.clickOnPlaceOrder();

    }

    @And("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate() {
     paymentPage.enterPaymentDetails("Xyz abc","123466788909","566","03","2025");
    }

    @And("Click Pay and Confirm Order button")
    public void clickPayAndConfirmOrderButton() {
        paymentPage.clickOnPayAndConfirmButton();

    }

    @Then("it should show Your order has been placed successfully!")
    public void itShouldShowYourOrderHasBeenPlacedSuccessfully() {
        Assertions.assertEquals("Congratulations! Your order has been confirmed!",webDriver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']")).getText());
    }



    @When("I click Delete Account button")
    public void iClickDeleteAccountButton() {

        accountDeletionPage = homePage.goToDeletionPage();
       // webDriver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
    }

    @Then("it should show ACCOUNT DELETED! message and click Continue button")
    public void itShouldShowACCOUNTDELETEDMessageAndClickContinueButton() {
        Assertions.assertEquals("ACCOUNT DELETED!",webDriver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).getText());
    }


    @After("@Ag")
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }
}