package cl.ucn.modelo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ParameterizedIdentifier {

    @Parameterized.Parameters
    public static Iterable<Object> getData(){
        return Arrays.asList(new Object[][]{
                {"a",true},
                {"Z1234",true},
                {"aB3c",true},
                {"",false},
                {"abcdeF",false},
                {"1abc",false},
                {"_test",false},
                {"b_1",false},
                {"C$2",false},
                {"d",true},
                {"E5",true},
                {"a123456",false}
        });
    }

    private String string_to_verify;
    private boolean expected_result;

    public ParameterizedIdentifier(String string_to_verify, boolean expected_result){
        this.string_to_verify = string_to_verify;
        this.expected_result = expected_result;
    }

    @Test
    public void testValidateIdentifier(){
        Identifier identifier = new Identifier();
        boolean result = identifier.validateIdentifier(string_to_verify);
        assertEquals(expected_result,result);
    }
}
