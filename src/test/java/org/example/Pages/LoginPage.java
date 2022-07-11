package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.example.Steps.Hooks;

public class LoginPage {

    public void typeEmailAndPass(String Email, String Pass) {
        WebElement EmailField = Hooks.driver.findElement(By.id("Email"));
        WebElement PassField = Hooks.driver.findElement(By.id("Password"));

        EmailField.clear();
        EmailField.sendKeys(Email);
        PassField.clear();
        PassField.sendKeys(Pass);

    }

    public void clickLogin() {
        WebElement LoginButton = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        LoginButton.click();
    }

    public void clickonForgetpassword() {
        WebElement forgpass = Hooks.driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]"));
        forgpass.click();
    }

    public void TypeMailOnly(String MailOnly) {
        WebElement EmailField = Hooks.driver.findElement(By.id("Email"));
        EmailField.clear();
        EmailField.sendKeys(MailOnly);


    }


}
