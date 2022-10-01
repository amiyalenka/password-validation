package test;

import exception.InvalidPasswordException;
import org.junit.Test;
import utility.PasswordValidator;

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


    // case#7 : Valid password which meets these conditions - not null, Lowercase, Uppercase,
    // but no number exists and length is less than 9

    // case#8 : Valid password which meets these conditions - not null, Lowercase, Uppercase,
    // but no number exists and length is greater than 8

    // case#9 : Valid password which meets these conditions - not null, Lowercase, Uppercase,
    // but number exists and length is less than 9


    // case#10 : Valid password which meets these conditions - not null, Lowercase, number exists,
    // but no uppercase and length is less than 9

    // case#11 : Valid password which meets these conditions - not null, Lowercase, number exists,
    // but no uppercase and length is greater than 8

    // case#12 : Valid password which meets these conditions - not null, Lowercase, number exists,
    // but uppercase and length is less than 9


    // case#13 : Valid password which meets these conditions - not null, Lowercase, length greater than 8
    // but no uppercase and no number exists

    // case#14 : Valid password which meets these conditions - not null, Lowercase, length greater than 8
    // but no uppercase and number exists

    // case#15 : Valid password which meets these conditions - not null, Lowercase, length greater than 8
    // but uppercase and no number exists

}
