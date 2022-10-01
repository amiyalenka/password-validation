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

    /**
     * Assuming the method will neither throw not let know the unsatisfied rules when the password valid.
     *
     * @param password password to be validated
     * @return boolean when password is valid
     * @throws InvalidPasswordException throws InvalidPasswordException when password in invalid
     */
    public static boolean validatePassword(String password) throws InvalidPasswordException {

        // If it is null then all other conditions will not be satisfied.
        // So, password will be invalid, Throw exception when it is null.
        if (Objects.isNull(password)) {
            throw new InvalidPasswordException("password should not be null");
        }

        // if there is no lower case letter then password is invalid, no further validation needed.
        if (!password.chars().anyMatch(Character::isLowerCase)) {
            throw new InvalidPasswordException("password should have one lowercase letter at least");
        }

        // Create this message string which will be populated based on unsatisfied rules.
        StringBuffer exceptionMessage = new StringBuffer("Error");

        // Minimum length validation
        if (password.length() <= 8) {
            exceptionMessage.append("::password should be larger than 8 chars");
        } else {
            // if it reaches here then it meets any three conditions criteria as not null and lowercase are already met.
            // Return here to avoid further processing, this logic is applicable for other validations below
            return true;
        }

        // At-least one upper case validation
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            exceptionMessage.append("::password should have one uppercase letter at least");
        } else {
            return true;
        }

        // At-least one number validation
        if (!password.chars().anyMatch(Character::isDigit)) {
            exceptionMessage.append("::password should have one number at least");
        } else {
            return true;
        }

        // Throw exception by consolidating all the invalid rules.
        // Used StringBuffer above to append all the unsatisfied criteria's.
        throw new InvalidPasswordException(exceptionMessage);
    }
}
