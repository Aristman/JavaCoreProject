package tests.test14;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AppTest {
    private App app;

    @Before
    public void init() {
        app = new App();
    }

    @Test
    public void test1Method1() {
        Assertions.assertArrayEquals(new Integer[]{3, 2, 1}, app.getArrayFollowed4(new Integer[]{1, 2, 3, 4, 3, 2, 1}));
    }

    @Test
    public void test2Method1() {
        Assertions.assertArrayEquals(new Integer[]{3, 6, 0}, app.getArrayFollowed4(new Integer[]{7, 4, 3, 4, 3, 6, 0}));
    }

    @Test
    public void test3Method1() {
        Assertions.assertArrayEquals(new Integer[]{}, app.getArrayFollowed4(new Integer[]{1, 2, 3, 4, 3, 2, 4}));
    }

    @Test
    public void test4Method1() {
        Assertions.assertArrayEquals(new Integer[]{}, app.getArrayFollowed4(new Integer[]{4, 4, 4, 4, 4, 4, 4}));
    }

    @Test
    public void test5Method1() {
        Assertions.assertThrows(RuntimeException.class, () -> app.getArrayFollowed4(new Integer[]{1, 2, 3, 1, 3, 2, 1}));
    }

    @Test
    public void test6Method1() {
        Assertions.assertArrayEquals(new Integer[]{2, -6, -4, 0, 28, 3}, app.getArrayFollowed4(new Integer[]{4, 2, -6, -4, 0, 28, 3}));
    }

    @Test
    public void test7Method1() {
        Assertions.assertArrayEquals(new Integer[]{-3}, app.getArrayFollowed4(new Integer[]{0, 0, 0, 0, 0, 4, -3}));
    }

    @Test
    public void test1Method2() {
        Assertions.assertTrue(app.isOnly4and1(new int[]{1, 1, 1, 4, 1, 4, 1}));
    }

    @Test
    public void test2Method2() {
        Assertions.assertFalse(app.isOnly4and1(new int[]{4, 4, 4, 4, 4, 4, 4}));
    }

    @Test
    public void test3Method2() {
        Assertions.assertFalse(app.isOnly4and1(new int[]{1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void test4Method2() {
        Assertions.assertFalse(app.isOnly4and1(new int[]{1, 3, 1, 4, 1, 4, 1}));
    }

    @Test
    public void test5Method2() {
        Assertions.assertFalse(app.isOnly4and1(new int[]{1, 1, -1, 4, 1, 4, 1}));
    }

    @Test
    public void test6Method2() {
        Assertions.assertFalse(app.isOnly4and1(new int[]{1, 4, 1, 4, 0, 4, 1}));
    }
}