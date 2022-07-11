package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubCategoryPage {

    public List<WebElement> ColorFilters()
    {
        return Hooks.driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[1]/div/div[2]/ul"));
    }
    public WebElement RedCheckBox()
    {
        return Hooks.driver.findElement(By.id("attribute-option-15"));
    }

}
