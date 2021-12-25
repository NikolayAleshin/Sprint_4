import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String message;
    private final String name;
    private final boolean expectedResult;

    public AccountTest(String message, String name, boolean expectedResult) {
        this.message = message;
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Длина имени 3 символа", "Т Е", true},
                { "Длина имени больше 19 символов", "тесттестте тесттестт", false},
                { "В строке 2 пробела", "Имя  Фамилия", false},
                { "В строке пробел в начале строки", " ИмяФамилия", false},
                { "В строке пробел в конце строки", "ИмяФамилия ", false},
                { "Строка имеет правильную длину и содержит один пробел в середине", "Имя Фамилия", true},
        };
    }

    @Test
    @DisplayName("Check name to emboss")
    public void checkNameToEmboss() {
        Account account = new Account(name);

        assertEquals(message, expectedResult, account.checkNameToEmboss());
    }
}