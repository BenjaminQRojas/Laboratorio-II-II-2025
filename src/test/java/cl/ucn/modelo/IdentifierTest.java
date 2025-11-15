package cl.ucn.modelo;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdentifierTest {

    private Identifier identifier = new Identifier();

    @Test
    public void validLengthMin() {
        assertTrue(identifier.validateIdentifier("A"));
    }

    @Test
    public void validLengthMax() {
        assertTrue(identifier.validateIdentifier("Abc12"));
    }

    @Test
    public void emptyStringThrowsException() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            identifier.validateIdentifier("");
        });
    }

    @Test
    public void invalidTooLong() {
        assertFalse(identifier.validateIdentifier("Abc123"));
    }

    @Test
    public void validStartsWithLetter() {
        assertTrue(identifier.validateIdentifier("A1b2"));
    }

    @Test
    public void validDoubleDigit() {
        assertTrue(identifier.validateIdentifier("A11b"));
    }

    @Test
    public void invalidStartsWithDigit() {
        assertFalse(identifier.validateIdentifier("1abc"));
    }

    @Test
    public void invalidStartsWithSymbol() {
        assertFalse(identifier.validateIdentifier("_abc"));
    }

    @Test
    public void invalidContainsSymbol() {
        assertFalse(identifier.validateIdentifier("A-b"));
    }

    @Test
    public void validSingleDigitSeparated() {
        assertTrue(identifier.validateIdentifier("A1b2"));
    }

}
