package web.cucumber.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Set;

public class ProductsPage {
    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String url = driver.getCurrentUrl();
        //adBlocker();
return url;

    }
//    public void adBlocker(){
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//
//        js.executeScript("var elements = document.querySelectorAll('div[class*=ad], div[id*=ad], div[class*=ads], div[id*=ads], iframe[src*=ad], iframe[src*=ads], a[href*=ad], a[href*=ads]');" +
//
//                "for(var i = 0; i < elements.length; i++) { " +
//
//                " elements[i].style.display = 'none'; " +
//
//                "}" + "var ad = document.querySelector('.ee'); if (ad) { ad.style.display = 'none'; }");
//
//    }

    public String getTitle(){
        return driver.getTitle();
    }
}