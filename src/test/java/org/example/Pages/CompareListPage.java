package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CompareListPage {
    public List<WebElement> CompareRows() {
    WebElement Table = Hooks.driver.findElement(By.className("compare-products-table"));
    return Table.findElements(By.tagName("tr"));
    }
}
