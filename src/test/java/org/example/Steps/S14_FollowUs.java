package org.example.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.example.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class S14_FollowUs {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Hooks.driver);

    @Given("^user CLick on \"(.*)\" Link$")
    public void OpenLinkFaceBook(String URLF) throws InterruptedException {
        for (WebElement SingleLinkF : homePage.FollowUsList()) {

            if (SingleLinkF.getText().contains("Facebook")) {
                actions.click(SingleLinkF).build().perform();
                String CurrentWindow = Hooks.driver.getWindowHandle();
                for (String window : Hooks.driver.getWindowHandles()) {
                    String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                    if (Tilte.contains("NopCommerce - Home")) {
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(URLF));
                        Hooks.driver.close();

                    }
                }
                Thread.sleep(5000);
                Hooks.driver.switchTo().window(CurrentWindow);
            }

        }
    }

    @When("^user CLick on \"(.*)\" Link2$")
    public void OpenLinkTwitter(String URLT) throws InterruptedException {
        for (WebElement SingleLinkT : homePage.FollowUsList()) {

            if (SingleLinkT.getText().contains("Twitter")) {
                actions.click(SingleLinkT).build().perform();
                String CurrentWindow2 = Hooks.driver.getWindowHandle();
                for (String window : Hooks.driver.getWindowHandles()) {
                    String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                    if (Tilte.contains("Twitter")) {
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(URLT));
                        Thread.sleep(3000);
                        Hooks.driver.close();

                    }
                    // Thread.sleep(5000);
                    Hooks.driver.switchTo().window(CurrentWindow2);
                }

            }
        }
    }

    @And("^user CLick on \"(.*)\" Link3$")
    public void OpenLinkYouTupe(String URLY) throws InterruptedException {
        for (WebElement SingleLinkY : homePage.FollowUsList()) {

            if(SingleLinkY.getText().contains("YouTube")) {
                actions.click(SingleLinkY).build().perform();
                String CurrentWindow3 = Hooks.driver.getWindowHandle();
                for (String window : Hooks.driver.getWindowHandles()) {
                    String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                    if (Tilte.contains("YouTube")) {
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(URLY));
                        Thread.sleep(3000);
                        Hooks.driver.close();

                    }
                    // Thread.sleep(5000);
                    Hooks.driver.switchTo().window(CurrentWindow3);
                }
            }

        }
    }

    @Then("user CLick on \"(.*)\" Link4$")
    public void OpenRssLink(String URLR) throws InterruptedException {
        for (WebElement SingleLinkR : homePage.FollowUsList()) {
            if(SingleLinkR.getText().contains("RSS")) {
                actions.click(SingleLinkR).build().perform();
                String CurrentWindow4 = Hooks.driver.getWindowHandle();
                for (String window : Hooks.driver.getWindowHandles()) {
                    String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                    if (Tilte.contains("rss")) {
                        Assert.assertEquals(URLR, Hooks.driver.getCurrentUrl());
                        Thread.sleep(3000);
                        Hooks.driver.close();

                    }
                     Thread.sleep(5000);
                    Hooks.driver.switchTo().window(CurrentWindow4);
                }
            }
        }
    }
}







                
