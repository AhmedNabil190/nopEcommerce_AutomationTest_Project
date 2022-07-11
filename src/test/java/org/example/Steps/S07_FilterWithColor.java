package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.SubCategoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class S07_FilterWithColor {
    HomePage homee = new HomePage();
    Actions action = new Actions(Hooks.driver);
    SubCategoryPage subCategoryPage = new SubCategoryPage();
    SoftAssert softAssert = new SoftAssert();

    @Given("user hoover on Apperal category")
    public void HooveronApperal() {
        action.moveToElement(homee.ApperalCategory()).build().perform();
    }

    @When("user select shoes subcategory")
    public void ChooseShoes() {
        action.click(homee.ShoesSupCategory()).build().perform();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("shoes"));
    }

    @And("user Choose a specfic color")
    public void ApplyColorFilter() throws InterruptedException {
        for (WebElement CheckBox : subCategoryPage.ColorFilters()) {
            System.out.println(CheckBox.getText());
            if (CheckBox.getText().contains("Red")) {
                action.click(subCategoryPage.RedCheckBox()).build().perform();
            }

            Thread.sleep(5000);
        }
    }


    @Then("filter Applied successfully")
    public void FilterAppliedSuccessfully() {

        softAssert.assertTrue(subCategoryPage.RedCheckBox().isSelected());
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("15"));
        softAssert.assertAll();

    }
}
