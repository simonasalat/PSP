package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validators.PhoneValidator;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTest {

    PhoneValidator phoneValidator;

    @BeforeEach
    void setUp() {
        phoneValidator = new PhoneValidator();
    }

    @Test
    void testCheckSymbols_onlyNumbers() {
        assertTrue(phoneValidator.checkSymbols("861111111"));
    }

    @Test
    void testCheckSymbols_withOtherSymbols() {
        assertFalse(phoneValidator.checkSymbols("86ab11111"));
    }

    @Test
    void testCheckSymbols_emptyNumber() {
        assertFalse(phoneValidator.checkSymbols(" "));
    }

    @Test
    void testChangePrefix() {
        assertEquals("+37061111111", phoneValidator.changePrefix("+370", "861111111"));
    }

    @Test
    void testValidateNumberByCountry_correctPrefixAndLength() {
        assertTrue(phoneValidator.validateNumberByCountry("FR", "+33123456789"));
    }

    @Test
    void testValidateNumberByCountry_incorrectPrefix() {
        assertFalse(phoneValidator.validateNumberByCountry("FR", "+37061234567"));
    }

    @Test
    void testValidateNumberByCountry_lengthTooShort() {
        assertFalse(phoneValidator.validateNumberByCountry("FR", "+3312345"));
    }

    @Test
    void testValidateNumberByCountry_lengthTooLong() {
        assertFalse(phoneValidator.validateNumberByCountry("FR", "+3311111111111111"));
    }
}