package org.example.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.ApperalCategoryPage;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

public class S08_SelectTags {
    HomePage homee = new HomePage();
    ApperalCategoryPage apperalCategoryPage = new ApperalCategoryPage();

    @Given("user Navigate to ant Category")
    public void NavigateToApperalCAtegory() {
        homee.ApperalCategory().click();
    }

    @When("^user Select ([^\"]*)$")
    public void SelectAnyTag(String TagName) {

        Actions action = new Actions(Hooks.driver);


        if (Objects.equals(TagName, "awesome")) {
            action.click(apperalCategoryPage.AwesomeTag()).build().perform();
        } else if (Objects.equals(TagName, "cool")) {
            action.click(apperalCategoryPage.coolTag()).build().perform();
        } else if (Objects.equals(TagName, "nice")) {
            action.click(apperalCategoryPage.NiceTag()).build().perform();
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Then("^([^\"]*) Selected Successfully$")
    public void CheckTagResult(String TaggName) {

        SoftAssert assertr = new SoftAssert();
        assertr.assertTrue(Hooks.driver.getCurrentUrl().contains(TaggName));
        assertr.assertTrue(Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1")).getText().contains(TaggName));
        assertr.assertAll();
    }

}
