package org.example.Pages;

import org.example.Steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ResetPasswordPage {

    public void EmailField(String RestMail) {
        WebElement EmailRestField = Hooks.driver.findElement(By.id("Email"));
        EmailRestField.clear();
        EmailRestField.sendKeys(RestMail);
    }

    public void ClickRecover() {
        WebElement RecoverBtn = Hooks.driver.findElement(By.name("send-email"));
        RecoverBtn.click();
    }

    public String CheckRecoverText() {
        WebElement CheckText = Hooks.driver.findElement(By.className("content"));
        return CheckText.getText();
    }

}
