package web.cucumber.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver webDriver;
    private By searchBox = new By.ByXPath("//input[@id='search_product']");

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void clickOnSearchBar() {
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

    public void clickOnSearchButton() {
        clickByXpath("//button[@id='submit_search']");
    }
}
