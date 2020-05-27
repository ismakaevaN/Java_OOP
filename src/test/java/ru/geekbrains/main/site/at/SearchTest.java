package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest extends BaseTest {

    @BeforeAll
    static void beforeTestCase() {
        driver.get(BASE_URL + "/courses");
        driver.findElement(By.xpath("//div/div/button[*]")).click();

        WebElement searchButton = driver.findElement(By.cssSelector("ul > li > .show-search-form"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.cssSelector(".search-panel__search-field"));
        searchInput.sendKeys("java");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        // передаем в него условие - ждать до тех пор, пока элемент с указанным CSS селектором не появится на экране
        // если ожидание затянется более чем на 15 секунд - тест упадет.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.search-page-tabs")));
    }

    @Test
    void professionsCountTest() {
        WebElement tab = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='professions']"));
        Assertions.assertTrue(tab.isDisplayed());
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='professions'] > span"));
        Assertions.assertTrue(count.isDisplayed());
        Assertions.assertTrue(Integer.parseInt(count.getText())>=2);
    }

    @Test
    void coursesCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='courses']"));
        Assertions.assertTrue(tab.isDisplayed());
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='courses'] > span"));
        Assertions.assertTrue(count.isDisplayed());
        Assertions.assertTrue(Integer.parseInt(count.getText())>15);
    }

    @Test
    void webinarsCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='webinars']"));
        Assertions.assertTrue(tab.isDisplayed());
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='webinars'] > span"));
        Assertions.assertTrue(count.isDisplayed());
        Assertions.assertTrue(Integer.parseInt(count.getText())>180);
        Assertions.assertTrue(Integer.parseInt(count.getText())<300);
    }

    @Test
    void blogsTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='blogs']"));
        Assertions.assertTrue(tab.isDisplayed());
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='blogs'] > span"));
        Assertions.assertTrue(count.isDisplayed());
        Assertions.assertTrue(Integer.parseInt(count.getText())>300);
    }

    @Test
    void forumsCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='forums']"));
        Assertions.assertTrue(tab.isDisplayed());
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='forums'] > span"));
        Assertions.assertTrue(count.isDisplayed());
        Assertions.assertFalse(Integer.parseInt(count.getText())==350);
    }

    @Test
    void testsCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='tests']"));
        Assertions.assertTrue(tab.isDisplayed());
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='tests'] > span"));
        Assertions.assertTrue(count.isDisplayed());
        Assertions.assertFalse(Integer.parseInt(count.getText())==0);
    }

}