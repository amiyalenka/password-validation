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

        return true;
    }
}
