package ru.geekbrains.main.site.at.junit;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestExampleTest {

    @Test
    public void test01() {
        int a = 5;
        Object object = new Object();
        Object object1 = object;
        assertThat(a, equalTo(5));
        assertThat(object, notNullValue());
        assertThat(object, sameInstance(object1));
    }

    @Test
    public void test02() {
        int a = 0;
        double a1 = 1.555;
        int b = 1;
        int c = -100;
        Integer z = 100;
        assertThat(a, lessThan(10));
        assertThat(c, greaterThan(-101));
        assertThat(a, lessThanOrEqualTo(0));
        assertThat(a1, closeTo(1.5, 0.1));
        assertThat(z, instanceOf(Number.class));
    }

    @Test
    public void test03() {
        String a = "MMM DANONE";
        String b = "mmm danone";
        assertThat(a, equalToIgnoringCase(b));
    }

    @Test
    public void test04() {
        int a = 0;

        assertThat(a, allOf(
                lessThan(10),
                lessThanOrEqualTo(0)
        ));
    }

    @Test
    public void test05() {
        int a = 0;

        assertThat(a, anyOf(
                lessThan(-100),
                lessThanOrEqualTo(0)
        ));
    }

    @Test
    public void test06() {
        int a = 0;

        assertThat(a, not(anyOf(
                lessThan(-100),
                lessThanOrEqualTo(-40)
        )));
    }
}
