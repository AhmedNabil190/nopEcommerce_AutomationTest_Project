package org.example.Pages;

import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.example.Steps.Hooks;

import java.util.List;

public class HomePage {

    // Register Button At home PAge
    public void navigateToRegPage() {
        WebElement RegisterLink = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));

        RegisterLink.click();
    }

    // Login Button At Home Page
    public void navigateToLoginPage() {
        WebElement LoginLink = Hooks.driver.findElement(By.className("ico-login"));
        LoginLink.click();
    }

    // Search Bar
    public void TypeOnSearchBar(String FieldText) {
        WebElement SearchField = Hooks.driver.findElement(By.id("small-searchterms"));
        SearchField.clear();
        SearchField.sendKeys(FieldText);
    }

    public void clickOnSearch() {
        Hooks.driver.findElement(By.cssSelector
                ("form[id=\"small-search-box-form\"] > button[type = \"submit\"]")).click();
    }

    // Drop down List Of Currencies
    public WebElement CurrencyDropDownList() {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    //list of  4 Items At HOmePage
    public List<WebElement> ItemsOfHomePage() {
        return Hooks.driver.findElements(By.className("product-item"));

    }

    //category with subcactegort
    public WebElement ElectronicsCategory() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
    }

    //sub category from Electronics
    public List<WebElement> ListOfElectronics() {

        return Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul"));

    }

    //3sub from Eleectronics
    public WebElement Camera() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
    }

    public WebElement Cell() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
    }

    public WebElement Others() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[3]/a"));
    }


    // Apperal Category
    public WebElement ApperalCategory() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
    }

    //shoesSupcategory
    public WebElement ShoesSupCategory() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a"));
    }

    //HTC phone Product From Cell Phone
    public WebElement HtcCellPhone() {
        return Hooks.driver.findElement
                (By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/h2/a"));
    }

    // logo Home Page
    public WebElement LogoHomePage() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a"));
    }

    // ShoppingCartElemnets
    public WebElement ShoppingCartCounterFromHomePage() {
        return Hooks.driver.findElement(By.className("cart-qty"));
    }

    public WebElement ShoppingCArtPage() {
        return Hooks.driver.findElement(By.className("ico-cart"));
    }

    // RedChooseElement
    public WebElement RedshoespPage() {
        return Hooks.driver.findElement
                (By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/h2/a"));
    }

    // second Home Page Item
    public WebElement NavigateToProductPage() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/h2/a"));
    }

    public WebElement WishListButton() {
        return Hooks.driver.findElement(By.id("add-to-wishlist-button-4"));
    }

    public WebElement WishListQnty() {
        return Hooks.driver.findElement(By.className("wishlist-qty"));
    }

    public WebElement NavigateToWishListPage() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a"));
    }

    // button1compare list
    public WebElement HTCcomparelistButton() {
        return Hooks.driver.findElement
                (By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[2]"));
    }

    //Button2compare list
    public WebElement MackCompareListButton() {
        return Hooks.driver.findElement
                (By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[2]"));
    }

    //compare list page
    public WebElement NavigateToCopmareListPage() {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[5]/a"));
    }

    //compareList Alert
    public WebElement CompareAlertMessage() {
        return Hooks.driver.findElement(By.className("content"));
    }

    public List<WebElement> FollowUsList() {
    WebElement networks = Hooks.driver.findElement(By.className("networks"));
    return networks.findElements(By.tagName("li"));
    }
}
