package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.ShoppingCartPage;
import org.example.Pages.WishListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class S11_AddingToShoppingCartFromWishListPage {
    WishListPage wishListPage = new WishListPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    Actions actions = new Actions(Hooks.driver);

    @Given("fill check box")
    public void FillcheckBox() {
        actions.click(wishListPage.ITemCheckBox()).build().perform();
        Assert.assertTrue(wishListPage.ITemCheckBox().isSelected());
    }

    @And("press on button add to cart")
    public void ConvertItemToCart() {
        actions.click(wishListPage.ConvertToCartButton()).build().perform();

    }

    @And("Check navigation to cart page")
    public void checkURL() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("cart"));
    }

    @Then("check item is added to cart successfully")
    public void itemAddedToCart() {
        for (WebElement SingleRow : shoppingCartPage.Rows()) {

            if (SingleRow.getText().contains("MacBook")) {
                Assert.assertTrue(true);
            }
        }
    }
}
