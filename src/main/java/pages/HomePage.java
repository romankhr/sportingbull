package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookiesButton;

    @FindBy(css = "spb-search-button.sports-menu-items-e3__search")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchInputField;

    @FindBy(xpath = "//spb-scrollable-tabs[@class='ng-star-inserted']//ul/li/div[1]")
    private List<WebElement> searchResultsList;

    @FindBy(css = ".search-input__icon--clear")
    private WebElement clearSearchField;

    @FindBy(xpath = "(//div[@class='search-no-results ng-star-inserted'])[2]")
    private WebElement noResultMessage;

    @FindBy(xpath = "(//div[@class='search-no-results ng-star-inserted'])[1]")
    private WebElement noSearchHistoryMessage;

    public void clickAcceptCookiesButton() {
        this.acceptCookiesButton.click();
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }

    public void inputSearchWord(String searchWord) {
        this.searchInputField.clear();
        this.searchInputField.sendKeys(searchWord);
    }

    public boolean isSearchButtonDisplayed() {
        return searchButton.isDisplayed();
    }

    public boolean isSearchButtonClickable() {
        return searchButton.isEnabled();
    }

    public void verifySearchResults(String searchWord) {
        for (WebElement result : searchResultsList) {
            Assert.assertTrue("Result does not contain  " + searchWord,
                    result.getText().contains(searchWord));
        }
    }

    public void clearSearchField() {
        this.clearSearchField.click();
    }

    public boolean isSearchInputFieldEmpty() {
        String value = searchInputField.getDomProperty("value");
        return value == null || value.isEmpty();
    }

    public boolean isNoResultsMessageDisplayed(String noResultMessage) {
        return this.noResultMessage.getText().replace("\n", " ").replaceAll("\\s+", " ").trim().contains(noResultMessage);
    }

    public boolean isNoSearchHistoryMessageDisplayed(String noSearchHistoryMessage) {
        return this.noSearchHistoryMessage.getText().replace("\n", " ").replaceAll("\\s+", " ").trim().contains(noSearchHistoryMessage);
    }

    public void pressEnter() {
        searchInputField.sendKeys(Keys.ENTER);
    }
}
