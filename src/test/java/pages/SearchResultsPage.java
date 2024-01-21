package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'N54PNb BToiNc cvP2Ce']//div[@class = 'yuRUbf']//h3")
    private WebElement resultRow;
    @FindBy(xpath = "//div[@class = 'N54PNb BToiNc cvP2Ce']//div[@class = 'yuRUbf']//h3")
    private List<WebElement> resultRows;

    public SearchResultsPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        wait.until(ExpectedConditions.visibilityOfAllElements(resultRows));
        assertThat(resultRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString())
                .as("Wrong text has been displayed").contains(expected);

    }

    public void assertThatTopResultContainsProperAttribute(String expected) {
        assertThat(resultRow.getAttribute("class")).as("Wrong attribute text").contains(expected);

    }
}
