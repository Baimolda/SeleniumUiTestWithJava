package steps;

import pages.SearchResultsPage;

public class SearchResultSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultSteps verifyThatTopResultContainsCorrectText(String text) {
        searchResultsPage.assertThatTopResultContainsCorrectText(text);
        return this;
    }

    public SearchResultSteps verifyThatTopResultContainsProperAttribute(String text) {
        searchResultsPage.assertThatTopResultContainsProperAttribute(text);
        return this;
    }


}
