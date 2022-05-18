package ru.yandex.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.Account;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean checkNameToEmbossExpectedResult;

    public AccountTest(String name, boolean checkNameToEmbossExpectedResult) {
        this.name = name;
        this.checkNameToEmbossExpectedResult = checkNameToEmbossExpectedResult;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][] {
                {RandomStringUtils.randomAlphabetic(2), false},
                {RandomStringUtils.randomAlphabetic(20), false},
                {RandomStringUtils.randomAlphabetic(5) + "  " + RandomStringUtils.randomAlphabetic(9), false},
                {" " + RandomStringUtils.randomAlphabetic(6), false},
                {RandomStringUtils.randomAlphabetic(7) + " ", false},
                {RandomStringUtils.randomAlphabetic(4) + " " + RandomStringUtils.randomAlphabetic(7), true},
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account account = new Account(name);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals(actualResult, checkNameToEmbossExpectedResult);
    }

}