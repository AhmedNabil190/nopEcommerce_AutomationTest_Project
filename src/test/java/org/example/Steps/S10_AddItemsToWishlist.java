package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.HomePage;
import org.example.Pages.WishListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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
        assertt.assertTrue(Hooks.driver.findElement(By.className("content")).isDisplayed());
        assertt.assertTrue(Hooks.driver.findElement(By.className("content")).getText().contains("The product has been added to your "));
        assertt.assertAll();
    }

    @And("go back to home page")
    public void NavigateToHomePage() {
        action.click(homee.LogoHomePage()).build().perform();
    }

    @And("check counter of wishlist")
    public void CounterOfWishList() {
        Assert.assertTrue(homee.WishListQnty().getText().contains("2"));
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
/*
        assertt.assertEquals(wishListPage.Rowss().size(), 2);
        assertt.assertTrue(wishListPage.Rowss().get(1).getText().contains("MacBook"));
        assertt.assertAll();

 */

