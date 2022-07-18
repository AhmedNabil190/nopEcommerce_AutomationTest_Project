package org.example.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class S15_HomeSliders {
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Hooks.driver);

    @Given("navigate to first slider Url")
    public void clickOnFirstSlider()
    {

        actions.click(homePage.NokiaSlider()).build().perform();

    }

    @Then("^check the result of first url \"(.*)\"$")
    public void CheckFirstUrl (String NokiaSlider) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(NokiaSlider, Hooks.driver.getCurrentUrl());
    }

    @Given("navigate to second url")
    public void ClickOnSecondSlider()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.IphoneSlider()));

        homePage.IphoneSlider().click();
    }

    @Then("^check the result of second url \"(.*)\"$")
    public void CheckSecondUrl (String IphoneSlider) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(IphoneSlider, Hooks.driver.getCurrentUrl());
    }

}
