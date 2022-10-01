package test;

import exception.InvalidPasswordException;
import org.junit.Test;
import utility.PasswordValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* not null, lower case are mandatory - 2 conditions are met here.
 uppercase, number, min length 9 are optionals where if any one condition meets will satisfy as valid password.*/
public class PasswordValidatorTest {
    // case#1 : Invalid password as null value, expect that it will throw InvalidPasswordException.
    @Test(expected = InvalidPasswordException.class)
    public void passwordIsNull() throws InvalidPasswordException {
        PasswordValidator.validatePassword(null);
    }

    // case#2 : Invalid password with no lowercase character, expect that it will throw InvalidPasswordException.
    // if there is not lower case char exists, then it is considered as invalid password
    @Test(expected = InvalidPasswordException.class)
    public void invalidPasswordWithNoLowerCaseChar() throws InvalidPasswordException {
        PasswordValidator.validatePassword("PASSWORD123");
    }

    // case#3 : Invalid password with length less than 9 and no lowercase letter exists,
    // expect that it will throw InvalidPasswordException.
    @Test(expected = InvalidPasswordException.class)
    public void invalidPasswordWithLengthLessThan9Char() throws InvalidPasswordException {
        PasswordValidator.validatePassword("PASS12");
    }

    // case#4 : inValid password with length less than 9 and no upper case character and no number exists,
    // expect that it will throw InvalidPasswordException.
    @Test(expected = InvalidPasswordException.class)
    public void invalidPasswordWithLengthLessThan9CharAndNoUppercaseAndNoNumber() throws InvalidPasswordException {
        PasswordValidator.validatePassword("password");
    }

    // case#5 : Invalid password with only numbers, no lowercase, no uppercase and length greater than 9,
    // expect that it will throw InvalidPasswordException.
    @Test(expected = InvalidPasswordException.class)
    public void invalidPasswordWithOnlyNumbers() throws InvalidPasswordException {
        PasswordValidator.validatePassword("123456789");
    }

    // case#6 : Valid password which meets these conditions - not null, Lowercase, Uppercase,
    // number exists and length is greater than 9
    @Test
    public void validPassword() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("Password123"));
    }

    // case#7 : Valid password which meets these conditions - not null, Lowercase, Uppercase,
    // but no number exists and length is less than 9
    @Test
    public void validPasswordWithNoNumberAndLengthLessThan9() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("ValidPa"));
    }

    // case#8 : Valid password which meets these conditions - not null, Lowercase, Uppercase,
    // but no number exists and length is greater than 8
    @Test
    public void validPasswordWithNoNumber() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("ValidPassword"));
    }

    // case#9 : Valid password which meets these conditions - not null, Lowercase, Uppercase,
    // but number exists and length is less than 9
    @Test
    public void validPasswordWithLengthLessThan9() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("ValidPa8"));
    }

    // case#10 : Valid password which meets these conditions - not null, Lowercase, number exists,
    // but no uppercase and length is less than 9
    @Test
    public void validPasswordWithNoUpperCaseAndLengthLessThan9() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("validpa8"));
    }

    // case#11 : Valid password which meets these conditions - not null, Lowercase, number exists,
    // but no uppercase and length is greater than 8
    @Test
    public void validPasswordWithNoUpperCase() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("validpassword8"));
    }

    // case#12 : Valid password which meets these conditions - not null, Lowercase, number exists,
    // but uppercase and length is less than 9
    @Test
    public void validPasswordWithUpperCaseAndLengthLessThan9() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("ValidPa8"));
    }

    // case#13 : Valid password which meets these conditions - not null, Lowercase, length greater than 8
    // but no uppercase and no number exists
    @Test
    public void validPasswordWithNoUpperCaseAndNoNumber() throws InvalidPasswordException {
        assertTrue(PasswordValidator.validatePassword("validpassword"));
    }

    // case#1.1 : Invalid password as null value, expect that it will throw InvalidPasswordException.
    @Test
    public void passwordIsNullCatchException() {
        try {
            PasswordValidator.validatePassword(null);
        } catch (InvalidPasswordException ipe) {
            assertEquals("password should not be null", ipe.getMessage());
        }
    }

    // case#2.2 : Invalid password with no lowercase character, expect that it will throw InvalidPasswordException.
    // if there is not lower case char exists, then it is considered as invalid password
    @Test
    public void invalidPasswordWithNoLowerCaseCharCatchException() {
        try {
            PasswordValidator.validatePassword("PASSWORD123");
        } catch (InvalidPasswordException ipe) {
            assertEquals("password should have one lowercase letter at least", ipe.getMessage());
        }
    }

    // case#4.1 : inValid password with length less than 9 and no upper case character and no number exists,
    // expect that it will throw InvalidPasswordException.
    @Test
    public void invalidPasswordWithLengthLessThan9CharAndNoUppercaseAndNoNumberWithCatch() {
        try {
            PasswordValidator.validatePassword("password");
        } catch (InvalidPasswordException ipe) {
            assertEquals("Error::password should be larger than 8 chars::password should have one uppercase " +
                    "letter at least::password should have one number at least", ipe.getMessage());
        }
    }

}
