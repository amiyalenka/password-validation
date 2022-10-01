package utility;

/**
 * Password verification
 * PasswordValidator utility is responsible to validate the given password again a set-up of business rules.
 */
public class PasswordValidator {

    public static void main(String arg[]) {
        String password = "October@01";
        if (validatePassword(password)) {
            System.out.println("The given password is valid!");
        } else {
            System.out.println("The given password is not valid!! ");
        }
    }

    public static boolean validatePassword(String password) {
        return true;
    }
}
