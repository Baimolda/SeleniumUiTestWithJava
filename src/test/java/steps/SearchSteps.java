package steps;

import pages.SearchePage;

public class SearchSteps {
    private SearchePage searchePage = new SearchePage();

    public SearchResultSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        searchePage.pasteToSearchField(keyword);
        searchePage.clickSearchButtonOrPressEnter();
        return new SearchResultSteps();

    }

    public SearchSteps openTooltip() {
        searchePage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsProperText(String text) {
        searchePage.assertThatVoiceSearchTooltipContainsText(text);
        return this;
    }
}
