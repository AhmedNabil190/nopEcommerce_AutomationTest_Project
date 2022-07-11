package org.example.Steps;

import java.util.concurrent.TimeUnit;

import org.example.Pages.HomePage;
import org.example.Pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S04_SearchBar {

    HomePage Homee = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();


    @Given("^user types on ([^\"]*) in Search Bar$")
    public void TypeinSearchfield(String searchItem) {
        Homee.TypeOnSearchBar(searchItem);
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("user Click on Search button")
    public void PressSearchButton() {
        Homee.clickOnSearch();
    }

    @Then("^Search result must be appears ([^\"]*$)")
    public void CheckResultOfSearch(String SearchItem) {
        SoftAssert assertt = new SoftAssert();

        assertt.assertTrue(Hooks.driver.getCurrentUrl().contains(SearchItem));

        if (SearchItem == "book") {
            assertt.assertEquals(searchResultPage.SearchResultItems().size(), 4);
            for (WebElement singleitem : searchResultPage.SearchResultItems()) {
                String SerchITemValue = singleitem.getText();
                assertt.assertTrue(SerchITemValue.contains(SearchItem));
            }
        } else if (SearchItem == "laptop") {
            assertt.assertEquals(searchResultPage.SearchResultItems().size(), 2);
            for (WebElement singleitemm : searchResultPage.SearchResultItems()) {
                String SerchITemValue = singleitemm.getText();
                assertt.assertTrue(SerchITemValue.contains(SearchItem));
            }
        } else if (SearchItem == "nike") {
            assertt.assertEquals(searchResultPage.SearchResultItems().size(), 3);
            for (WebElement singleitemmm : searchResultPage.SearchResultItems()) {
                String SerchITemValue = singleitemmm.getText();
                assertt.assertTrue(SerchITemValue.contains(SearchItem));
            }
        }

        assertt.assertAll();
    }

    @Then("^Search result must be appearss ([^\"]*$)")
    public void CheckResultOfSearchSKu( String SearchItemm) {

        searchResultPage.SearchSkuRsult().click();
        Assert.assertTrue(Hooks.driver.findElement(By.className("sku")).getText().contains(SearchItemm));


    }

}
