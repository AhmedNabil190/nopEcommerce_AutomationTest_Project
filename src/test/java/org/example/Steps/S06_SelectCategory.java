package org.example.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class S06_SelectCategory {

    HomePage homee = new HomePage();
    Actions action = new Actions(Hooks.driver);

    @Given("user hoover on random category")
    public void UserHooverOnCategory() {

        action.moveToElement(homee.ElectronicsCategory()).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user select a subcategory")
    public void UserSelectSub() {

        for (WebElement Sub : homee.ListOfElectronics()) {

            if (Sub.getText().contains("Camera")) {
                action.click(homee.Camera()).perform();
            }
        }
    }

    @Then("subcategory opened successfully")
    public void CheckSelectResult() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Hooks.driver.getCurrentUrl());
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("camera"));
    }


}
