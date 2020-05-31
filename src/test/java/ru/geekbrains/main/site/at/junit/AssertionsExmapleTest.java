package ru.geekbrains.main.site.at.junit;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExmapleTest {

    public class AssertionsExmapleTest {

        @Test
        public void test01() {
            assertEquals(1.5, 1.5, "This elements are not equals!");
        }

        @Test
        public void test02() {
            int[] a = {0, 1};
            int[] b = {0, 1};
            assertArrayEquals(a, b);
        }

        @Test
        public void test03() {
            String a = null;
            String b = "String not null";
            assertNull(a);
            assertNotNull(b);
        }

        @Test
        public void test04() {
            List<Integer> myList = Arrays.asList(0, 1, 2);
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                myList.get(100);
            });
        }

        @Test
        public void test05() {
            assertTimeout(Duration.ofMillis(700), () -> {
                sleep(600);
            });
        }
    }
}
