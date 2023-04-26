package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {private final WebDriver webDriver;

    public PaymentPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void enterPaymentDetails(String name, String cardNum, String CVV, String expirationMonth,String expirationYear) {
        webDriver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(name);
        webDriver.findElement(By.xpath("//input[@name='card_number']")).sendKeys(cardNum);
        webDriver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys(CVV);
        webDriver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(expirationMonth);
        webDriver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys(expirationYear);

    }
    public void clickOnPayAndConfirmButton(){
        webDriver.findElement(By.xpath("//button[@id='submit']")).click();

    }
}
