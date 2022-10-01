package test;

import exception.InvalidPasswordException;
import org.junit.Test;
import utility.PasswordValidator;

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

    // case#4 : inValid password with length less than 9 and no upper case character,
    // expect that it will throw InvalidPasswordException.
    @Test(expected = InvalidPasswordException.class)
    public void invalidPasswordWithLengthLessThan9CharAndNoUppercaseChar() throws InvalidPasswordException {
        PasswordValidator.validatePassword("pass12");
    }

    // case#5 : Invalid password with only numbers, expect that it will throw InvalidPasswordException.

    // case#6 : Valid password with length less than 9.

    // case#7 : Valid password with no uppercase character but meets 3 conditions - not null,
    // lower case exists, length greater than 8 and also number exists.

    // case#8 : Valid password with no uppercase character but meets 3 conditions - not null, lower case exists,
    // length greater than 8.

    // case#9 : Valid password with no number

    // case#10 : Valid password with all meeting criteria
}
