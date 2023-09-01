/**
 * Encodes a String entered by a user.
 *
 * @author Samuel Halsey
 
 * @version 11102022
 */
import java.util.Scanner;

public class EncodingLab {

    public static final String CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Method that returns a string that is rot13 encoded from the input string.
     *
     * @param input
     *            The string to encode
     * @return The input string with the rot13 algorithm applied to it
     */
    public static String rot13(String input) 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) 
        {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'M'&&Character.isUpperCase(c)) 
              {
                 c += 13;
              }
            else if (c >= 'N' && c <= 'Z'&&Character.isUpperCase(c)) 
            {
               c -= 13;
            }
             sb.append(c);
         }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a string to encode: ");
        String input = keyboard.nextLine();
        String encoded = rot13(input);
        System.out.println("Your string encoded is  : " + encoded);
        keyboard.close();
    }

}