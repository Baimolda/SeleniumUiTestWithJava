package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComTest(String text) throws InterruptedException {

        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Пишем автотест с использованием Selenium Webdriver ...")
                .verifyThatTopResultContainsProperAttribute("LC20lb MBeuO DKV0Md");
    }

    @Test
    public void verifySearchByVoiceTooltipOnGoogle() {
        steps.openTooltip()
                .verifyThatTooltipContainsProperText("Голосовой поиск");
    }
}
