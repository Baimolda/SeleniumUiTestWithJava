package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchePage extends BasePage {
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnK")
    private WebElement searchButton;
    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(css = "div.XDyW0e")
    private WebElement searchByVoiceButton;


    public SearchePage() {
        super();
    }

    public void fillSearchField(String text) {
        searchField.click();
        searchField.sendKeys(text);
    }

    public void pasteToSearchField(String text) {
        pasteTextToElementFromClipboard(searchField, text);

    }

    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);

    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnK"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            //searchButton.click();
            clickWithJavaScirpt(searchButton);
        } else {
            pressEnter();
        }
    }

    public void moveToVoiceSearchButton() {
        builder.moveToElement(searchByVoiceButton).build().perform();
    }

    public void assertThatVoiceSearchTooltipContainsText(String text) {
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Excepted tooltip [" + text + "] was not found").isNotZero();

    }
}
