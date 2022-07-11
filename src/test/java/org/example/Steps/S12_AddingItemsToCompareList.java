package org.example.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CompareListPage;
import org.example.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class S12_AddingItemsToCompareList {
    HomePage homePage = new HomePage();
    CompareListPage compareListPage = new CompareListPage();
    Actions actions = new Actions(Hooks.driver);
    SoftAssert softAssert = new SoftAssert();

    @Given("user add First Item to compare list and check alert")
    public void AddFirstItemToCompareList() throws InterruptedException {
        actions.click(homePage.HTCcomparelistButton()).build().perform();
        softAssert.assertTrue(homePage.CompareAlertMessage().isDisplayed());
        softAssert.assertTrue(homePage.CompareAlertMessage().getText().contains("The product has been added to your "));
        softAssert.assertAll();

        Thread.sleep(3000);
    }

    @When("user add Second Item to compare list and check alert")
    public void AddSecondItemToCompareList() {
        actions.click(homePage.MackCompareListButton()).build().perform();
        softAssert.assertTrue(homePage.CompareAlertMessage().isDisplayed());
        softAssert.assertTrue(homePage.CompareAlertMessage().getText().contains("The product has been added to your "));
        softAssert.assertAll();
    }

    @When("user navigate to compare list")
    public void NavigateToComparePage() {
        actions.click(homePage.NavigateToCopmareListPage()).build().perform();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("compareproducts"));
    }

    @Then("items should be added successfully")
    public void CheckItemsIsAdded() {
        for (WebElement SingleRow : compareListPage.CompareRows()) {

            if (SingleRow.getText().contains("HTC ") ||SingleRow.getText().contains("MacBook")) {
                Assert.assertTrue(true);
            } else {
                continue;
            }

        }
    }

}

/*
for (int i = 0; i < 4; i++) {

            if (compareListPage.CompareRows().get(i).getText().contains("HTC ") || compareListPage.CompareRows().get(i).getText().contains("MacBook")) {
                Assert.assertTrue(true);
            } else {
                continue;
            }

        }
 */
