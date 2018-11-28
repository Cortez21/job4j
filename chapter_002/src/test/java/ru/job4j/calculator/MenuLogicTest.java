package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MenuLogicTest {
    @Test
    public void when2plus2() {
        MenuLogic menu = new MenuLogic();
        int[] answers = new int[] {2, 0, 2};
        assertThat(menu.action(answers), is(4.0));
    }

    @Test
    public void when8minus2() {
        MenuLogic menu = new MenuLogic();
        int[] answers = new int[] {8, 1, 2};
        assertThat(menu.action(answers), is(6.0));
    }

    @Test
    public void when12division4() {
        MenuLogic menu = new MenuLogic();
        int[] answers = new int[] {12, 2, 4};
        assertThat(menu.action(answers), is(3.0));
    }

    @Test
    public void when2multiple4() {
        MenuLogic menu = new MenuLogic();
        int[] answers = new int[] {2, 3, 4};
        assertThat(menu.action(answers), is(8.0));
    }
}
