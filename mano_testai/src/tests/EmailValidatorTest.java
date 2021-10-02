package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validators.EmailValidator;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    void testCheckAtSign_withAtSign() {
        assertTrue(emailValidator.checkAtSign("vardenis@gmail.com"));
    }

    @Test
    void testCheckAtSign_withoutAtSign() {
        assertFalse(emailValidator.checkAtSign("vardenisgmail.com"));
    }

    @Test
    void testCheckSymbols_withoutInvalidSymbols() {
        assertTrue(emailValidator.checkSymbols("vardenis@gmail.com"));
    }

    @Test
    void testCheckSymbols_withInvalidSymbols() {
        assertFalse(emailValidator.checkSymbols("vard~n s+@gmail.com"));
    }

    @Test
    void testCheckDomainAndTLD_validEmail() {
        assertTrue(emailValidator.checkDomainAndTLD("vardenis@gmail.com"));
    }

    @Test
    void testCheckDomainAndTLD_incorrectDomain() {
        assertFalse(emailValidator.checkDomainAndTLD("vardenis@.com"));
    }

    @Test
    void testCheckDomainAndTLD_incorrectTLD() {
        assertFalse(emailValidator.checkDomainAndTLD("vardenis@gmail."));
    }
}