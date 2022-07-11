package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingCartPage {

    public List<WebElement> Rows() {
        WebElement Table = Hooks.driver.findElement(By.className("cart"));
        return Table.findElements(By.tagName("tr"));
    }

    public WebElement Gift() {
        return Hooks.driver.findElement(By.id("checkout_attribute_1"));
    }
    public WebElement CheckBox()
    {
        return Hooks.driver.findElement(By.id("termsofservice"));
    }
    public WebElement CheckOutButton()
    {
        return Hooks.driver.findElement(By.id("checkout"));
    }
    public void fillFields( int country , String city  ,String adress1 ,String ZIP  , String mobile)
    {
        Select select = new Select(Hooks.driver.findElement(By.id("BillingNewAddress_CountryId")));
        select.selectByIndex(country);
        WebElement cityfield = Hooks.driver.findElement(By.id("BillingNewAddress_City"));
        cityfield.clear();
        cityfield.sendKeys(city);
        WebElement Adress = Hooks.driver.findElement(By.id("BillingNewAddress_Address1"));
        Adress.clear();
        Adress.sendKeys(adress1);
        WebElement ZIpCode = Hooks.driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        ZIpCode.clear();
        ZIpCode.sendKeys(ZIP);
        WebElement PhoneNumber = Hooks.driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        PhoneNumber.clear();
        PhoneNumber.sendKeys(mobile);


    }

    public WebElement continue1()
    {
        return Hooks.driver.findElement(By.name("save"));
    }
    public WebElement shoppingMethod()
    {
        return Hooks.driver.findElement(By.id("shippingoption_1"));
    }
    public WebElement continue2()
    {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
    }
    public WebElement PaymentMethod()
    {
        return Hooks.driver.findElement(By.id("paymentmethod_0"));
    }
    public WebElement continue3()
    {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));
    }
    public WebElement continue4 ()
    {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
    }
    public WebElement ConfirmButton()
    {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
    }



}
