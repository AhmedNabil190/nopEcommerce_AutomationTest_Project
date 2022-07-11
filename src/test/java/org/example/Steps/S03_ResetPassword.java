package org.example.Steps;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.example.Pages.ResetPasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S03_ResetPassword {

    HomePage homee = new HomePage();
    LoginPage logpage = new LoginPage();
    ResetPasswordPage ResetPage = new ResetPasswordPage();

    @Given("user Navigate to Login page")
    public void gotologinPage() {
        homee.navigateToLoginPage();
    }

    @When("user Type Email")
    public void UserTypeEmail() {
        logpage.TypeMailOnly("abaashelmy@gmail.com");
    }

    @And("user Clik on forget password")
    public void CLickOnForgetPass() {
        logpage.clickonForgetpassword();
    }

    @And("Fill Email Information")
    public void fillmail() {
        ResetPage.EmailField("abaashelmy@gmail.com");
    }

    @And("click on Recover")
    public void ClickRecover() {
        ResetPage.ClickRecover();
    }

    @Then("intstruction of rest sent successfuly")
    public void CheckResultOfRecover() {
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String ActualText = ResetPage.CheckRecoverText();

        Assert.assertEquals(ActualText, "Email with instructions has been sent to you.");


    }


}
