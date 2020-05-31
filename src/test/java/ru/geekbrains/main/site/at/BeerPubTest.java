package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.*;

@Disabled
public class BeerPubTest {

    @BeforeEach
    void setUp() {
        System.out.println("Hello, I'm here");
    }

    @Test
    void ageTest() {
        System.out.println("this is test 1");
        BeerPub beerPub = new BeerPub();
        boolean testResult = beerPub.isValidGuest(18);
        Assertions.assertTrue(testResult);
    }

    @Test
    void ageTest2() {
        System.out.println("this is test 2");
        BeerPub beerPub = new BeerPub();
        boolean testResult = beerPub.isValidGuest(17);
        Assertions.assertFalse(testResult);
    }

    @Test
    void ageTest3() {
        System.out.println("this is test 3");
        BeerPub beerPub = new BeerPub();
        boolean testResult = beerPub.isValidGuest(7);
        Assertions.assertEquals(false, testResult);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Bye!");
    }

}
