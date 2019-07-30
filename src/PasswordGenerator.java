import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * Generates a Password of a specified user length from the ASCII table.
 *
 * @author Daniel Hunter
 *
 */
public final class PasswordGenerator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private PasswordGenerator() {
    }

    /**
     * Lowest valid character on the ASCII table for password.
     */
    private static final int LOWEST_VALID_CHARACTER = 33;
    /**
     * Highest valid character on the ASCII table for password.
     */
    private static final int HIGHEST_VALID_CHARACTER = 126;

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        //Create Reader for User Input
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));

        //Get User Input for input file
        int passwordLength;
        try {
            System.out.print("Enter the desired password length: ");
            //Assuming correct input
            passwordLength = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            System.err.println("Input not Open");
            return;
        }
        //Generate the password within the bounds we created on the ASCII table.
        Random r = new Random();
        String password = "";
        while (password.length() < passwordLength) {
            int nextChar = r.nextInt(HIGHEST_VALID_CHARACTER + 1);
            if (nextChar >= LOWEST_VALID_CHARACTER
                    && nextChar <= HIGHEST_VALID_CHARACTER) {
                password += (char) nextChar;
            }
        }
        //Print the Generated Password to console.
        try {
            //Printing to Console
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(System.out));
            out.write(password);
            out.flush();
        } catch (IOException e) {
            System.err.println("Output not Open");
            return;
        }
    }

}
