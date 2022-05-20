package ru.yandex.tests;

import org.junit.Test;
import ru.yandex.praktikum.Account;

public class AccountExceptionTest {

    @Test(expected = NullPointerException.class)
    public void accountNullPointerExceptionTest() {

        Account account = new Account(null);
        account.checkNameToEmboss();

    }

}
