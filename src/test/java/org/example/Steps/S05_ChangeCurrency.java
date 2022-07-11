package org.example.Steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class S05_ChangeCurrency {

    HomePage homee = new HomePage();

    @Given("user Selects Euro From TopLeft List")
    public void SelectCurrency() {
        Select CurrncyList = new Select(homee.CurrencyDropDownList());
        CurrncyList.selectByIndex(1);
    }

    @Then("Proudcts must be changed to Euro")
    public void CheckProductCurrency() {

        for (int i = 0; i < 4; i++) {
            String Valuee = homee.ItemsOfHomePage().get(i).getText();
            Assert.assertTrue(Valuee.contains("€"));
        }


    }


}
