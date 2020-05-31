package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class NavigationTest extends BaseTest {

    @BeforeEach
    void navigationSetUp() {
        driver.get(BASE_URL + "/career");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/navigation_test.csv", numLinesToSkip = 1)
    public void navigationTest(String name, String label) {
        String header;
        driver.findElement(By.cssSelector("nav > a[href='/" + name + "']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals(label, header);
        checkFooter();
    }

    private void checkFooter() {
        WebElement searchFooter = driver.findElement(By.className("site-footer__content"));
        Assertions.assertTrue(searchFooter.isDisplayed());
    }
}