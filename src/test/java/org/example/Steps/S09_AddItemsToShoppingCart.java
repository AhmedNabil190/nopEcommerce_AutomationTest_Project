package org.example.Steps;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.example.Pages.HomePage;
import org.example.Pages.HtcPhonePage;
import org.example.Pages.RedshoesPage;
import org.example.Pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class S09_AddItemsToShoppingCart {

    HomePage homee = new HomePage();
    Actions actions = new Actions(Hooks.driver);
    HtcPhonePage htcPhonePage = new HtcPhonePage();
    RedshoesPage redshoesPage = new RedshoesPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    SoftAssert softAssert = new SoftAssert();

    @Given("navigate to cell phone page")
    public void NavigateToCellPage() {
        actions.moveToElement(homee.ElectronicsCategory()).build().perform();
        actions.click(homee.Cell()).build().perform();
    }

    @When("choose first item")
    public void ChooseFirstItemToAdd() {
        actions.click(homee.HtcCellPhone()).build().perform();
    }

    @And("Click on add to cart to add first item and check alert message")
    public void ClickOnAddToCart1() throws InterruptedException {
        htcPhonePage.AddingIemTOCart("1");
        Thread.sleep(2000);
        Assert.assertTrue(Hooks.driver.findElement(By.className("content")).isDisplayed());

    }

    @And("navigate to home page")
    public void GobackToHomePage() {
        homee.LogoHomePage().click();
    }

    @And("check  first item was added")
    public void CheckCounterOfCartFirstTime() {
         Assert.assertTrue(homee.ShoppingCartCounterFromHomePage().getText().contains("1"));
    }

    @And("navigate to shoes page")
    public void GotoShoesPage() {
        actions.moveToElement(homee.ApperalCategory()).build().perform();
        actions.click(homee.ShoesSupCategory()).build().perform();
    }

    @And("choose Seccond item")
    public void ChooseSecondItemToAdd() {
        actions.click(homee.RedshoespPage()).build().perform();
    }

    @And("Seclect size of second item")
    public void SeletcShoesSize() {
        redshoesPage.SelectSize(2);
    }

    @And("Select color of second item")
    public void SelectColorofShoes() {
        redshoesPage.SelectColor();
    }

    @And("click on Add to cart button to Add second item and check alert message")
    public void AddSecondItemToCart() throws InterruptedException {
        redshoesPage.AddToshoesToCart("2");
        Thread.sleep(2000);
        Assert.assertTrue(Hooks.driver.findElement(By.className("content")).isDisplayed());

    }

    @And("navigate to home page again")
    public void BackToHomePage() {
        actions.click(homee.LogoHomePage()).build().perform();
    }

    @And("check the second Item Was Added")
    public void CheckCounterofShoppingCart() {
        Assert.assertTrue(homee.ShoppingCartCounterFromHomePage().getText().contains("3"));
    }

    @And("navigate to shooping cart page")
    public void NavigateToCartPage() {
        homee.ShoppingCArtPage().click();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("cart"));
    }

    @Then("first and second item was addedd successfully")
    public void CheckShoppingCart() {

        for (WebElement SingleRow : shoppingCartPage.Rows()) {

            System.out.println(SingleRow.getText());

            if (SingleRow.getText().contains("HTC") || SingleRow.getText().contains("Running Shoes")) {
                Assert.assertTrue(true);

            }
        }
        Assert.assertEquals(shoppingCartPage.Rows().size(),3);
    }
}





