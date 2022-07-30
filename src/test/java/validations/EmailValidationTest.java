package validations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static validations.EmailValidation.validateEmail;

class EmailValidationTest {

    @ParameterizedTest(name = "{index} \"{0}\" is not a valid GOOGLE email")
    @NullAndEmptySource
    @ValueSource(strings = {
            " ",
            "william@google.com",
            "william.shakespeare@google.com",
            "william...shakespeare@google.com",
            "william-shakespeare@google.com",
            "shakespeare123@google.com",
            "william_$hakespeare@google.com",
            "william_shakespeare@google.org",
            "_shakespeare@google.com",
            "shakespeare_@google.com",
            "william.shakespeare@google@com",
            "william.shakespeare@googlecom",
    })
    void validateEmailInvalidCases(String input) {
        assertFalse(validateEmail(input));
    }

    @ParameterizedTest(name = "{index} \"{0}\" is not a valid GOOGLE email")
    @ValueSource(strings = {
            "william_shakespeare@google.com",
            "lu_e@google.com",
            "william_shakespeare1@google.com",
            "william_shakespeare2@google.com"
    })
    void validateEmailValidCases(String input) {
        assertTrue(validateEmail(input));
    }
}