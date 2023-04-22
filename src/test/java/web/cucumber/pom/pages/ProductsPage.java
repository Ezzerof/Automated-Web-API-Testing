package web.cucumber.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private WebDriver webDriver;
    private final By searchBox = new By.ByXPath("//input[@id='search_product']");
    private final By searchButton = new By.ByXPath("//button[@id='submit_search']");

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait used to secure our operations on un synchronised pages
    public void clickOnSearchBar() {
        waitForClickable(searchBox);
        webDriver.findElement(searchBox).click();
    }

    public void searchForAndPressEntre(String keyword) {
        webDriver.findElement(searchBox).sendKeys(keyword + Keys.ENTER);
    }

    public void searchFor(String keyword) {
        webDriver.findElement(searchBox).sendKeys(keyword);
    }

    public void clickByXpath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public void clickByXpath(By xpath) {
        waitForClickable(xpath);
        webDriver.findElement(xpath);
    }

    public void clickOnSearchButton() {
        clickByXpath(searchButton);
    }
}
