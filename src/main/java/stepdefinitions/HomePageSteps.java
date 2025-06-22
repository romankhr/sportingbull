package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverFactory;

public class HomePageSteps {

    WebDriver driver;
    HomePage homePage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Given("I launch the SportingBull homepage")
    public void i_launch_the_homepage() {
        driver.get("https://en.sportingbull.com");
        homePage = new HomePage(driver);
    }

    @When("I accept cookies")
    public void clickAcceptCookiesButton() {
        homePage.clickAcceptCookiesButton();
    }

    @When("I click on search button on the Home Page")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @When("I input {string} search word in search input field on the Home Page")
    public void inputSearchWord(String searchWord) {
        homePage.inputSearchWord(searchWord);
    }

    @Then("Verify the search button is displayed on the Home Page")
    public void isSearchButtonDisplayed() {
        Assert.assertTrue("Search button should be visible", homePage.isSearchButtonDisplayed());
    }

    @Then("Verify the search button is clickable on the Home Page")
    public void isSearchButtonClickable() {
        Assert.assertTrue("Search button should be clickable", homePage.isSearchButtonClickable());
    }

    @Then("Verify the {string} search results are displayed on the Home Page")
    public void verifySearchResults(String searchWord) {
        homePage.verifySearchResults(searchWord);
    }

    @Then("Verify the search field is cleared on the Home Page")
    public void verifyTheSearchFieldIsCleared() {
        Assert.assertTrue("Search input field is not empty.",
                homePage.isSearchInputFieldEmpty());
    }

    @And("I click X \\(clear) of search field")
    public void iClickClearOfSearchField() {
        homePage.clearSearchField();
    }

    @Then("Verify the {string} error message is displayed on the Home Page")
    public void noResultErrorMessage(String errorMessage) {
        Assert.assertTrue("No Results Error message displayed", homePage.isNoResultsMessageDisplayed(errorMessage));
    }

    @And("I press Enter")
    public void iPressEnter() {
        homePage.pressEnter();
    }

    @Then("Verify the {string} history error message is displayed on the Home Page")
    public void verifyNoHistoryErrorMessage(String noHistoryErrorMessage) {
        Assert.assertTrue("No history Error message displayed", homePage.isNoSearchHistoryMessageDisplayed(noHistoryErrorMessage));
    }
}