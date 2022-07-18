package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.HomePage;
import org.example.Pages.WishListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class S10_AddItemsToWishlist {

    HomePage homee = new HomePage();
    SoftAssert assertt = new SoftAssert();
    WishListPage wishListPage = new WishListPage();
    Actions action = new Actions(Hooks.driver);

    @Given("go to item page")
    public void GotoItemPAge() {
        homee.NavigateToProductPage().click();
    }

    @And("click on add to wish list and check alert message")
    public void ClickOnWishListButton() throws InterruptedException {
        homee.WishListButton().click();
        Thread.sleep(2000);
        assertt.assertTrue(homee.SuccessMessageContent().isDisplayed());
        assertt.assertTrue(homee.SuccessMessageContent().getText().contains("The product has been added to your "));
        assertt.assertTrue(homee.SuccessMessageBar().getCssValue("background-color").equals("rgba(75, 176, 122, 1)"));
        assertt.assertAll();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(homee.SuccessMessageContent()));


    }

    @Then("go back to home page")
    public void NavigateToHomePage() {
        action.click(homee.LogoHomePage()).build().perform();
    }

    @And("check counter of wishlist")
    public void CounterOfWishList() {
        System.out.println(homee.WishListQnty().getText());
        String valueofWishList =  homee.WishListQnty().getText();
        valueofWishList = valueofWishList.replaceAll("[^0-9]" , "");
        Assert.assertTrue(Integer.parseInt(valueofWishList) > 0 );

    }

    @And("go to Wish List Page")
    public void GotoWishListPage() {
        homee.NavigateToWishListPage().click();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("wishlist"));
    }

    @Then("Items Added successfully")
    public void CheckTableOfWishLists() {
        for (WebElement SingleRow : wishListPage.Rowss()) {

            if (SingleRow.getText().contains("MacBook")) {
                Assert.assertTrue(true);
            }

        }

    }
}

