package org.example.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class S06_HoverCategories {

    HomePage homee = new HomePage();
    Actions action = new Actions(Hooks.driver);

    @Given("user hoover on random category")
    public void UserHooverOnCategory() {

        action.moveToElement(homee.ElectronicsCategory()).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user select a subcategory")
    public void UserSelectSub() {

        for (WebElement Sub : homee.ListOfElectronics()) {

            if (Sub.getText().contains("Camera")) {
                action.click(Sub).perform();
                break;
            }
        }
    }

    @Then("subcategory opened successfully")
    public void CheckSelectResult() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("camera"));
        Assert.assertTrue(Hooks.driver.getTitle().toLowerCase().trim().contains("camera"));
    }

    // secondScenario

    @Given("user hoover on random category2")
    public void UserHooverOnCategory2() {

        action.moveToElement(homee.ApperalCategory()).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user select a subcategory2")
    public void UserSelectSub2() {

        for (WebElement Sub : homee.ApperalList()) {

            if (Sub.getText().contains("Clothing")) {
                action.click(Sub).perform();
                break;
            }
        }
    }

    @Then("subcategory2 opened successfully")
    public void CheckSelectResult2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("clothing"));
        Assert.assertTrue(Hooks.driver.getTitle().toLowerCase().trim().contains("clothing"));
    }

    //Third Scenario

    @Given("user hoover on random category3")
    public void UserHooverOnCategory3() {

        action.moveToElement(homee.ComputerCategory()).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("user select a subcategory3")
    public void UserSelectSub3() {

        for (WebElement Sub : homee.ComputerList()) {

            if (Sub.getText().contains("Software")) {
                action.click(Sub).perform();
                break;
            }
        }
    }

    @Then("subcategory3 opened successfully")
    public void CheckSelectResult3() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("software"));
        Assert.assertTrue(Hooks.driver.getTitle().toLowerCase().trim().contains("software"));
    }




}
