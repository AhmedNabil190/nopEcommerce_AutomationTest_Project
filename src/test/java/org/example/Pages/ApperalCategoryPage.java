package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApperalCategoryPage {

    public WebElement AwesomeTag() {
        return Hooks.driver.findElement(By.linkText("awesome"));
    }

    public WebElement coolTag() {
        return Hooks.driver.findElement(By.linkText("cool"));
    }

    public WebElement NiceTag() {
        return Hooks.driver.findElement(By.linkText("nice"));
    }


    public List<WebElement> Tags() {
        WebElement tags = Hooks.driver.findElement(By.className("tags"));
        return tags.findElements(By.tagName("li"));

    }


}
