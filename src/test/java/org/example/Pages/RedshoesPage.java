package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RedshoesPage {
    public void SelectSize (int Sizee)
    {
        Select select = new Select(Hooks.driver.findElement(By.id("product_attribute_9")));
        select.selectByIndex(Sizee);
    }

    public void SelectColor()
    {
        WebElement Redcolor = Hooks.driver.findElement(By.className("attribute-square"));
        Redcolor.click();
    }
    public void AddToshoesToCart(String Num)
    {
        WebElement NumField = Hooks.driver.findElement(By.id("product_enteredQuantity_25"));
        NumField.clear();
        NumField.sendKeys(Num);

        WebElement AddButton = Hooks.driver.findElement(By.id("add-to-cart-button-25"));
        AddButton.click();
    }


}
