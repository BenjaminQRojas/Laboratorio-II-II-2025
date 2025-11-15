package cl.ucn.modelo;

import net.jqwik.api.*;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.StringLength;
import net.jqwik.api.constraints.NumericChars;

import static org.junit.jupiter.api.Assertions.*;

public class PBTIdentifierTest {

    private Identifier identifier = new Identifier();


    @Property
    void validIdentifierIsAccepted(
            @ForAll @AlphaChars @StringLength(min = 1, max = 1) String first,
            @ForAll @AlphaChars @NumericChars @StringLength(min = 0, max = 4) String tail
    ){
        String s = first + tail;
        Assume.that(!s.matches(".*\\d{2}.*"));
        assertTrue(identifier.validateIdentifier(s));
    }

    @Property
    void tooLongIdentifierIsRejected(
            @ForAll @AlphaChars @NumericChars @StringLength(min = 6, max = 12) String s
    ) {
        assertFalse(identifier.validateIdentifier(s));
    }

    @Property
    void identifierStartingWithDigitIsRejected(
            @ForAll @NumericChars @StringLength(min = 1, max = 1) String firstDigit,
            @ForAll @AlphaChars @NumericChars @StringLength(min = 0, max = 4) String tail
    ) {
        String s = firstDigit + tail;
        assertFalse(identifier.validateIdentifier(s));
    }
}
