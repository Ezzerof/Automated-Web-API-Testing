package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

  private final WebDriver webDriver;
    private final By createAccountButton = new By.ByXPath("button[data-qa='create-account']");

  public SignUpPage(WebDriver webDriver) {
    this.webDriver=webDriver;
  }

  public String getUrl() {
    return webDriver.getCurrentUrl();
  }

  public AccountCreationPage createAccount(){
      JavascriptExecutor jse = (JavascriptExecutor)webDriver;
      jse.executeScript("window.scrollTo(0, 1000)");
   // webDriver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
       webDriver.findElement(By.xpath("/html/body/section/div/div/div/div/form/button")).click();

      return new AccountCreationPage(webDriver);
  }

  public void fillAllRequiredFieldsInForm(String name,String password, String lastname, String address, String state, String city, String zipcode, String mobileNum) {
    webDriver.findElement(By.xpath("//input[@id='id_gender1']")).click();
//    webDriver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
//    webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
 webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
 webDriver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(name);
    webDriver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastname);
    webDriver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address);
   Select country=new Select(webDriver.findElement(By.xpath("//select[@id='country']")));
   country.selectByValue("India");

    webDriver.findElement(By.xpath("//input[@id='state']")).sendKeys(state);
    webDriver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
    webDriver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(zipcode);
    webDriver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(mobileNum);



  }

  public void clickOnCreateAccountButton() {

      JavascriptExecutor jse = (JavascriptExecutor)webDriver;
      jse.executeScript("window.scrollTo(0, 1100)");
    // waitForElementTobeVisible(createAccountButton);
      webDriver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
  }


    public void waitForElementTobeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
