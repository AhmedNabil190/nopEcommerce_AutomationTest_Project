
package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.example.Steps.Hooks;

public class RegisterPage {


    // partition of personal data


    public void FillNames(String fname, String lname) {
        WebElement GenderType = Hooks.driver.findElement(By.id("gender-male"));
        WebElement FirstName = Hooks.driver.findElement(By.id("FirstName"));
        WebElement LastName = Hooks.driver.findElement(By.id("LastName"));

        GenderType.click();
        FirstName.clear();
        FirstName.sendKeys(fname);
        LastName.clear();
        LastName.sendKeys(lname);
    }


    public void FillDofBirth(String day, String month, String year) {
        WebElement Day = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        WebElement Month = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        WebElement Year = Hooks.driver.findElement(By.name("DateOfBirthYear"));

        Select SelectedDay = new Select(Day);
        Select Selectedmonth = new Select(Month);
        Select Selectedyear = new Select(Year);

        SelectedDay.selectByValue(day);
        Selectedmonth.selectByValue(month);
        Selectedyear.selectByValue(year);

    }


    public void FillEmail(String mail) {
        WebElement Email = Hooks.driver.findElement(By.id("Email"));

        Email.clear();
        Email.sendKeys(mail);
    }


    /*---------------------------------------------*/

    //company details

    public void companyFilled(String companyName) {
        WebElement companyField = Hooks.driver.findElement(By.id("Company"));
        companyField.clear();
        companyField.sendKeys(companyName);

    }
    /*-----------------------------------------------*/

    // password filleds

    public void fillPasswords(String pass) {
        WebElement passowrd = Hooks.driver.findElement(By.id("Password"));
        WebElement ConfirmPassword = Hooks.driver.findElement(By.id("ConfirmPassword"));

        passowrd.clear();
        passowrd.sendKeys(pass);
        ConfirmPassword.clear();
        ConfirmPassword.sendKeys(pass);

    }
    /*-----------------------------------------------*/

    //Rgister Button


    public void clickreg() {
        WebElement RegisterButton = Hooks.driver.findElement(By.id("register-button"));
        RegisterButton.click();
        ;
    }


}
