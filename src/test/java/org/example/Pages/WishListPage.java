package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishListPage {
    public List<WebElement> Rowss ()
    {
        WebElement Table = Hooks.driver.findElement(By.className("cart"));
        return Table.findElements(By.tagName("tr"));
    }

    public WebElement ITemCheckBox()
    {
        return Hooks.driver.findElement(By.name("addtocart"));
    }
    public WebElement ConvertToCartButton()
    {
        return Hooks.driver.findElement(By.name("addtocartbutton"));
    }
}
