package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HtcPhonePage {

    public void AddingIemTOCart( String number)
    {
        WebElement countField = Hooks.driver.findElement(By.id("product_enteredQuantity_18"));
        countField.clear();
        countField.sendKeys(number);

        WebElement btnToAddToCart = Hooks.driver.findElement(By.id("add-to-cart-button-18"));
        btnToAddToCart.click();
    }
}
