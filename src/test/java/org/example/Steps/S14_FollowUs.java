package org.example.Steps;

import io.cucumber.java.en.Given;

import org.example.Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class S14_FollowUs {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Hooks.driver);

    @Given("user CLick on each Link")
    public void OpenLinks() throws InterruptedException {
        for (WebElement SingleLink : homePage.FollowUsList()) {

            if (SingleLink.getText().contains("Facebook")) {
                actions.click(SingleLink).build().perform();
                String CurrentWindow = Hooks.driver.getWindowHandle();
                for (String window : Hooks.driver.getWindowHandles()) {
                    String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                    if (Tilte.contains("NopCommerce - Home")) {
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://www.facebook.com/nopCommerce"));
                        Hooks.driver.close();
                    }
                }
                Thread.sleep(5000);
                Hooks.driver.switchTo().window(CurrentWindow);
            } else if (SingleLink.getText().contains("Twitter")) {
                actions.click(SingleLink).build().perform();
                String CurrentWindow2 = Hooks.driver.getWindowHandle();
                for (String window : Hooks.driver.getWindowHandles()) {
                    String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                    if (Tilte.contains("Twitter")) {
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://twitter.com/nopCommerce"));
                        Thread.sleep(3000);
                        Hooks.driver.close();
                    }
                    // Thread.sleep(5000);
                    Hooks.driver.switchTo().window(CurrentWindow2);
                }
            } else if (SingleLink.getText().contains("YouTube")) {
                actions.click(SingleLink).build().perform();
                String CurrentWindow3 = Hooks.driver.getWindowHandle();
                for (String window : Hooks.driver.getWindowHandles()) {
                    String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                    if (Tilte.contains("YouTube")) {
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://www.youtube.com/user/nopCommerce"));
                        Thread.sleep(3000);
                        Hooks.driver.close();
                    }
                    // Thread.sleep(5000);
                    Hooks.driver.switchTo().window(CurrentWindow3);
                }
            }


        }
    }
}

  /*
            String CurrentWindow = Hooks.driver.getWindowHandle();
            for (String window : Hooks.driver.getWindowHandles()) {
                String Tilte = Hooks.driver.switchTo().window(window).getTitle();
                if (Tilte.contains("NopCommerce - Home")) {
                    Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://www.facebook.com/nopCommerce"));
                    Hooks.driver.close();

                }

 */
                /*
                else if (Tilte.contains("Twitter"))
                {
                    Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://twitter.com/nopCommerce"));
                    Hooks.driver.close();

                } else if (Tilte.contains("YouTube"))
                {
                    Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://www.youtube.com/user/nopCommerce"));
                    Hooks.driver.close();

                }

                 */
