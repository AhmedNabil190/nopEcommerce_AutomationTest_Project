package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {
    public List<WebElement> SearchResultItems ()
    {
        return Hooks.driver.findElements(By.className("product-item"));
    }

    public WebElement SearchSkuRsult ()
    {
        return Hooks.driver.findElement(By.className("picture"));
    }

}
