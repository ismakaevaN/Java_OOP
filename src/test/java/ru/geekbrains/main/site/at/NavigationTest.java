package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NavigationTest extends BaseTest {

    @BeforeEach
    void navigationSetUp() {
        driver.get(BASE_URL + "/career");
    }

    @Test
    public void blogTest() {
        String header;
        driver.findElement(By.cssSelector("nav > a[href='/posts']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Блог", header);
        checkFooter();
    }

    @Test
    public void forumTest() {
        String header;
        driver.findElement(By.cssSelector("nav > a[href='/topics']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Форум", header);
        checkFooter();
    }

    @Test
    public void webinarsTest() {
        String header;
        driver.findElement(By.cssSelector("nav > a[href='/events']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Вебинары", header);
        checkFooter();
    }

    @Test
    public void coursesTest() {
        String header;
        // можно нажимать и на иконку
        driver.findElement(By.cssSelector("nav.gb-left-menu__nav .svg-icon.icon-courses")).click();
        // После нажатия на кнопку Курсы мы помним, что через какое-то время может появиться баннер со скидкой
        // В любом месте программы мы можем настроить параметры неявного ожидания
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Теперь не боимся что тест упадет
        driver.findElement(By.xpath("//div/div/button[*]")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Курсы", header);
        checkFooter();
    }

    @Test
    public void testsTest() {
        String header;
        driver.findElement(By.cssSelector("nav > a[href='/tests']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Тесты", header);
        checkFooter();
    }

    @Test
    public void careerTest() {
        String header;
        WebElement careerNavItemButton = driver.findElement(By.cssSelector("nav > a[href='/career']"));
        careerNavItemButton.click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Карьера", header);
        checkFooter();
    }

    private void checkFooter() {
        WebElement searchFooter = driver.findElement(By.className("site-footer__content"));
        Assertions.assertTrue(searchFooter.isDisplayed());
    }
}