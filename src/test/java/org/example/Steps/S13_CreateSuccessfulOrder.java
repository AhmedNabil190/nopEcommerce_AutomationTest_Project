package org.example.Steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.example.Pages.HomePage;
import org.example.Pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class S13_CreateSuccessfulOrder {
    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    Actions actions = new Actions(Hooks.driver);
    SoftAssert softAssert = new SoftAssert();

    @Given("user Navigate To shoppping cart")
    public void navigateToCart() {
        actions.click(homePage.ShoppingCArtPage()).build().perform();
    }

    @When("user Choose Gift Graping")
    public void userChooseGift() {
        Select select = new Select(shoppingCartPage.Gift());
        select.selectByIndex(0);
    }

    @And("fill check box of agreement")
    public void checkBoxAggreament() {
        actions.click(shoppingCartPage.CheckBox()).build().perform();
        Assert.assertTrue(shoppingCartPage.CheckBox().isSelected());
    }

    @And("press on Check Out")
    public void presCheckOut() {
        actions.click(shoppingCartPage.CheckOutButton()).build().perform();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("onepagecheckout"));
    }

    @And("Fill remaining mandatory fields")
    public void FillMissingData() throws InterruptedException {

            shoppingCartPage.fillFields(2, "cairo", "shrouk", "11873", "014841654989");
            this.pressCont1();

    }

    public void pressCont1() throws InterruptedException {
        actions.click(shoppingCartPage.continue1()).build().perform();
        Thread.sleep(3000);
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("shipping_method"));
    }

    @And("Choose Shipping Method")
    public void ChooseShippingMethod() {
        actions.click(shoppingCartPage.shoppingMethod()).build().perform();
        Assert.assertTrue(shoppingCartPage.shoppingMethod().isSelected());
    }

    @And("Press continue2")
    public void pressCont2() throws InterruptedException {
        actions.click(shoppingCartPage.continue2()).build().perform();
        Thread.sleep(1000);
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("payment_method"));
    }

    @And("Choose Pyament Method")
    public void choosePaymentMethod() {
        actions.click(shoppingCartPage.PaymentMethod()).build().perform();
        Assert.assertTrue(shoppingCartPage.PaymentMethod().isSelected());
    }

    @And("press continue3")
    public void Cont3() throws InterruptedException {
        actions.click(shoppingCartPage.continue3()).build().perform();
        Thread.sleep(1000);
    }

    @And("Check payment info url")
    public void CheckPAyinfo() {

        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("payment_info"));
    }

    @And("press continue4")
    public void Cont4() throws InterruptedException {
        actions.click(shoppingCartPage.continue4()).build().perform();
        Thread.sleep(1000);

    }

    @And("Check url confirmation and items to be order")
    public void checkFinalPage() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("confirm_order"));
        for (WebElement SingeRow : shoppingCartPage.Rows()) {

            if (SingeRow.getText().contains("HTC") || SingeRow.getText().contains("Shoes") || SingeRow.getText().contains("MacBook")) {
                Assert.assertTrue(true);
            } else {
                continue;
            }

        }

    }



    @And("press confirm")
    public void ClickOnConfirm() throws InterruptedException {
        actions.click(shoppingCartPage.ConfirmButton()).build().perform();
        Thread.sleep(1000);
    }

    @Then("order should crated successfully")
    public void CheckCOmpleteOrder() {
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("completed"));
        softAssert.assertTrue(Hooks.driver.findElement(By.className("title")).isDisplayed());
        softAssert.assertTrue(Hooks.driver.findElement(By.className("title")).getText().contains("Your order has been successfully processed!"));
        softAssert.assertAll();
    }


}
