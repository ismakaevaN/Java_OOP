package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        assertThat(true, is(tab.isDisplayed()));
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='professions'] > span"));
        assertThat(true, is(count.isDisplayed()));
        assertThat(2, lessThan(Integer.parseInt(count.getText())));
    }

    @Test
    void coursesCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='courses']"));
        assertThat(true, is(tab.isDisplayed()));
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='courses'] > span"));
        assertThat(true, is(count.isDisplayed()));
        assertThat(Integer.parseInt(count.getText()), greaterThan(15));
    }

    @Test
    void webinarsCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='webinars']"));
        assertThat(true, is(tab.isDisplayed()));
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='webinars'] > span"));
        assertThat(true, is(count.isDisplayed()));
        assertThat(Integer.parseInt(count.getText()), greaterThan(180));
        assertThat(Integer.parseInt(count.getText()), lessThan(300));
    }

    @Test
    void blogsTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='blogs']"));
        assertThat(true, is(tab.isDisplayed()));
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='blogs'] > span"));
        assertThat(true, is(count.isDisplayed()));
        assertThat(Integer.parseInt(count.getText()), greaterThan(300));
    }

    @Test
    void forumsCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='forums']"));
        assertThat(true, is(tab.isDisplayed()));
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='forums'] > span"));
        assertThat(true, is(count.isDisplayed()));
        assertThat(Integer.parseInt(count.getText()), not(350));
    }

    @Test
    void testsCountTest() {
        WebElement tab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='tests']"));
        assertThat(true, is(tab.isDisplayed()));
        WebElement count = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='tests'] > span"));
        assertThat(true, is(count.isDisplayed()));
        assertThat(Integer.parseInt(count.getText()), not(0));
    }

}