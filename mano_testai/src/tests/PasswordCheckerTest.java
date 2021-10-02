package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validators.PasswordChecker;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {

    PasswordChecker passwordChecker;

    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
    }

    @Test
    void testCheckLength_passwordLengthOk() {
        assertTrue(passwordChecker.checkLength("password", 5));
    }

    @Test
    void testCheckLength_passwordTooShort() {
        assertFalse(passwordChecker.checkLength("aaa", 5));
    }

    @Test
    void testCheckUppercase_withUppercase() {
        assertTrue(passwordChecker.checkUppercase("PassWord"));
    }

    @Test
    void testCheckUppercase_withoutUppercase() {
        assertFalse(passwordChecker.checkUppercase("password"));
    }

    @Test
    void testCheckSpecialSymbols_withSpecialSymbol() {
        assertTrue(passwordChecker.checkSpecialSymbols("p@ssword"));
    }

    @Test
    void testCheckSpecialSymbols_withoutSpecialSymbol() {
        assertFalse(passwordChecker.checkSpecialSymbols("password"));
    }
}