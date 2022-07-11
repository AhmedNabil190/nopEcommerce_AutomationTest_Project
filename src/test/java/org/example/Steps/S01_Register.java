package org.example.Steps;

import org.example.Pages.HomePage;
import org.example.Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S01_Register {

    RegisterPage regpage = new RegisterPage();
    HomePage homepage = new HomePage();


    @Given("user navigate to register page")
    public void RegLink() {

        homepage.navigateToRegPage();

    }


    @When("user fill personal data detailes")
    public void fillpersonalData() {

        regpage.FillNames("Abbas", "Helmy");
        regpage.FillDofBirth("10", "3", "1999");
        regpage.FillEmail("abaashelmy@gmail.com");

    }

    @And("fill company details")
    public void companydetails() {

        regpage.companyFilled("sapceX");
    }

    @And("fill password fields")
    public void passswords() {

        regpage.fillPasswords("123123");
    }

    @And("click register button")
    public void regb() {

        regpage.clickreg();
    }


    @Then("user Registerd Successfully")
    public void CheckREgisterResult() {

        WebElement regText = Hooks.driver.findElement(By.className("result"));
        WebElement continueButton = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));

        SoftAssert assertt = new SoftAssert();

        assertt.assertEquals("Your registration completed", regText.getText());

        assertt.assertFalse(regText.getCssValue("background-color").equals("(255,255,255,1)"));

        assertt.assertTrue(continueButton.isDisplayed(), "error inbutton");

        assertt.assertEquals("https://demo.nopcommerce.com/registerresult/1?returnUrl=/", Hooks.driver.getCurrentUrl());

        assertt.assertAll();

    }

}
