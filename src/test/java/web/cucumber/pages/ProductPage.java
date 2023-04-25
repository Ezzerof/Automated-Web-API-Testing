package web.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterReview(String message){
        webDriver.findElement(By.xpath("//textarea[@id='review']"))
                .sendKeys(message);
    }

    public void enterName(String name){
        webDriver.findElement(By.xpath("//input[@id='name']"))
                .sendKeys(name);
    }

    public void enterEmail(String email){
        webDriver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys(email);
    }

    public void clickSubmit(){
        webDriver.findElement(By.xpath("//button[@id='button-review']")).click();
    }

    public String successMessage(){
        String message = webDriver.findElement(By.xpath("//span[normalize-space()='Thank you for your review.']")).getText();
    return message;
    }

    public Boolean invalidInputMessage(){
        // String message = webDriver.findElement(By.xpath("//script[@type='text/javascript'][1]")).getText();
         WebElement invalidInput = webDriver.findElement(By.cssSelector("input:invalid"));
//        webDriver.findElement(By.className("alert"));
        return invalidInput != null;
    }

}
