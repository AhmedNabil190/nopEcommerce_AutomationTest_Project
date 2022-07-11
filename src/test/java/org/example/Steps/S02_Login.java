package org.example.Steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class S02_Login {

    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    SoftAssert assertt = new SoftAssert();

    @Given("user navigate to Login page")
    public void NavToLogin() {
        home.navigateToLoginPage();
    }
    @When("^type \"(.*)\" and \"(.*)\"$")
    public void typeEmaiAndPass(String user , String pass) {
        loginPage.typeEmailAndPass(user, pass);

    }
    @And("Click on Login button")
    public void clicklogButton() {
        loginPage.clickLogin();
    }
    @Then("user logged in successfully")
    public void UserLoggedIn() {

        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement MyAccount = Hooks.driver.findElement(By.className("ico-account"));
        assertt.assertTrue(MyAccount.isDisplayed());
        assertt.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        assertt.assertAll();

    }
    @Given("user navigate to Login page Negative")
    public void NavToLoginVegative()
    {
        home.navigateToLoginPage();
    }
    @When("^typee \"(.*)\" and \"(.*)\"$")
    public void typeEmaiAndPassNeg(String user , String pass) {
        loginPage.typeEmailAndPass(user, pass);
    }
    @And("Click on Login button Negative")
    public void clicklogButtonNeg() {
        loginPage.clickLogin();
    }
    @Then("user can not login")
    public void UserCannotLoggedIn() {
        WebElement ErrorText = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));

        assertt.assertTrue
                (ErrorText.getText().contains("Login was unsuccessful. Please correct the errors and try again."));


        assertt.assertFalse(ErrorText.getCssValue("color").contains("#e4434b"));



        assertt.assertAll();


    }



}
