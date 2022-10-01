package utility;

import exception.InvalidPasswordException;

import java.util.Objects;

/**
 * Password verification
 * PasswordValidator utility is responsible to validate the given password again a set-up of business rules.
 */
public class PasswordValidator {

    public static void main(String arg[]) {
        String password = "October@01";
        try {
            validatePassword(password);
            System.out.println("The given password is valid!");
        } catch (InvalidPasswordException ipe) {
            System.out.println("The given password is not valid!! " + ipe.getMessage());
        }
    }

    public static boolean validatePassword(String password) throws InvalidPasswordException {

        // If it is null then all other conditions will not be satisfied.
        // Throwing this exception right away.
        if (Objects.isNull(password)) {
            throw new InvalidPasswordException("password should not be null");
        }

        // Adding the lower case validation after null check as if there is not lower case char exists,
        // then it is considered as invalid password
        if (!password.chars().anyMatch(Character::isLowerCase)) {
            throw new InvalidPasswordException("password should have one lowercase letter at least");
        }

        // Minimum length validation
        if (password.length() <= 8) {
            throw new InvalidPasswordException("password should be larger than 8 chars");
        }

        // At-least one upper case validation
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            throw new InvalidPasswordException("password should have one uppercase letter at least");
        }

        // At-least one number validation
        if (!password.chars().anyMatch(Character::isDigit)) {
            throw new InvalidPasswordException("password should have one number at least");
        }

        return true;
    }
}
