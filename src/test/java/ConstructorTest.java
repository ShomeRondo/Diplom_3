import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest{

    @Test
    @DisplayName("переход к разделу Булки")
    public void checkTransferToBuns(){
        MainPage mainPage = new MainPage(driver)
                .mainPageOpen()
                .clickFillingBtn()
                .clickBunsBtnOnMainPage();
        String actual = mainPage.checkAtrubuteForBuns();
        assertTrue(actual.contains("current"));

    }

    @Test
    @DisplayName("переход к разделу Соусы")
    public void checkTransferToSauces(){
        MainPage mainPage = new MainPage(driver)
                .mainPageOpen()
                .clickSauseBtnOnMainPage();
        String actual = mainPage.checkAtrubuteForSauce();
        assertTrue(actual.contains("current"));
    }

    @Test
    @DisplayName("переход к разделу Начинки")
    public void checkTransferToFillings(){
        MainPage mainPage = new MainPage(driver)
                .mainPageOpen()
                .clickFillingBtn();
        String actual = mainPage.checkAtrubuteForFilling();
        assertTrue(actual.contains("current"));
    }
}
