/**
 * Encodes or decodes a ciphered alphabet based on how shifted the alphabet or the text file is.
 * @author Samuel Halsey
 * @version 11182022
 */
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.IOException; 
public class SubstitutionCipher {

    /**
     * Private constants used to shift characters for the substitution cipher.
     */
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constructs a new String where each letter in the String input is shifted
     * by the amount shift to the right, preserving whether the original
     * character was uppercase or lowercase. For example, the String "ABC" with
     * shift 3 would cause this method to return "DEF". A negative value should
     * shift to the left. For example, the String "ABC" with shift -3 would
     * cause this method to return "XYZ". Punctuation, numbers, whitespace and
     * other non-letter characters should be left unchanged. NOTE: For full
     * credit you are REQUIRED to use a StringBuilder to build the String in
     * this method rather than using String concatenation.
     *
     * @param input
     *            String to be encrypted
     * @param shift
     *            Amount to shift each character of input to the right
     * @return the encrypted String as outlined above
     */
    public static String shift(String input, int shift) {
       String shiftedString = "";
        for (int i = 0; i < input.length(); i++) 
        {
            char ch = input.charAt(i);
            if (Character.isUpperCase(ch)) 
              {
                 int letter = UPPERCASE.indexOf(ch);
                 if(shift>=0)
                 {
                 int shifted = (letter+shift)%26;
                  ch = UPPERCASE.charAt(shifted);
                  shiftedString+=ch;
                 }
                 else if (shift<0)
                 {
                    int shifted=(letter+(shift+26))%26;
                     ch = UPPERCASE.charAt(shifted);
                shiftedString+=ch;
                    }
                
              } 
            else if (Character.isLowerCase(ch))
            
            {
                 int letter = LOWERCASE.indexOf(ch);
                 if(shift>=0)
                 {
                 int shifted = (letter+shift)%26;
                  ch = LOWERCASE.charAt(shifted);
                 shiftedString+=ch;
                 }
                 else if (shift<0)
                 {
                    int shifted=(letter+(shift+26))%26;
                     ch = LOWERCASE.charAt(shifted);
                 shiftedString+=ch;
                    }
            }
            else{
                shiftedString+=ch;
               }
               
            
         }
       return shiftedString;
    }

    /**
     * Displays the message "promptMsg" to the user and reads the next full line
     * that the user enters. If the user enters an empty string, reports the
     * error message "ERROR! Empty Input Not Allowed!" and then loops,
     * repeatedly prompting them with "promptMsg" to enter a new string until
     * the user enters a non-empty String
     *
     * @param in
     *            Scanner to read user input from
     * @param promptMsg
     *            Message to display to user to prompt them for input
     * @return the String entered by the user
     */
    public static String promptForString(Scanner in, String promptMsg) {
      
        System.out.print(promptMsg);
        
        String userResponse = in.nextLine();
        if(userResponse.equals(""))
        {
           System.out.println("ERROR! Empty Input Not Allowed!");
           promptForString(in,promptMsg);
           }
           return userResponse;
        
        
    }

    /**
     * Opens the file inFile for reading and the file outFile for writing,
     * reading one line at a time from inFile, shifting it the number of
     * characters given by "shift" and writing that line to outFile. If an
     * exception occurs, must report the error message: "ERROR! File inFile not
     * found or cannot write to outFile" where "inFile" and "outFile" are the
     * filenames given as parameters.
     *
     * @param inFile
     *            the file to be transformed
     * @param outFile
     *            the file to write the transformed output to
     * @param shift
     *            the amount to shift the characters from inFile by
     * @return false if an exception occurs and the error message is written,
     *         otherwise true
     */
    public static boolean transformFile(String inFile, String outFile,int shift) throws java.io.IOException
            {
      FileInputStream fileByteStream = null;
      Scanner inFS = null;   
        try {
      fileByteStream = new FileInputStream(inFile);
      inFS = new Scanner(fileByteStream);
      PrintWriter out = null;
      try {
          out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
      } catch (IOException e) {
          System.err.println("Invalid file due to " + e);
      }
      
      
      
      while (inFS.hasNextLine()) {
         
       String filedata = inFS.nextLine(); 
       out.println(shift(filedata,shift)+"\n");
    }
     out.close();
      System.out.println("Finished writing to file.");
       return true;
    }
         catch (FileNotFoundException e) {
          System.err.println("ERROR - File "+inFile+" not found!");
          e.printStackTrace();
          return false;
        }
   }
       
    

    /**
     * Prompts the user to enter a single character choice. The only allowable
     * values are 'E', 'D' or 'Q'. All other values are invalid, including all
     * values longer than one character in length, however the user is allowed
     * to enter values in either lower or upper case. If the user enters an
     * invalid value, the method displays the error message "ERROR! Enter a
     * valid value!" and then prompts the user repeatedly until a valid value is
     * entered. Returns a single uppercase character representing the user's
     * choice.
     *
     * @param in
     *            Scanner to read user choices from
     * @return the user's choice as an uppercase character
     */
    public static char getChoice(Scanner in) {
      
   
      
        System.out.print("Enter your choice: ");
        String choice = in.nextLine();
        
        if(choice.equals(""))
        {
     
      return ' ';
           }
     
      
       char charUpper = Character.toUpperCase(choice.charAt(0));
          return charUpper;
   
      
       
    }

    /**
     * Displays the menu of choices to the user.
     */
     
    public static void displayMenu() 
    {
        System.out.println("[E]ncode a file");
        System.out.println("[D]ecode a file");
        System.out.println("[Q]uit");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        displayMenu();
       char choice = ' ';
        choice = getChoice(input);
        boolean hasQuit = false;
        while (true)
        {
        if(choice=='E'&& hasQuit == false)
        {
         String inFile =(promptForString(input,"Enter an input file: "));
         String outFile = (promptForString(input,"Enter an output file: "));
         int shift = Integer.parseInt((promptForString(input,"Enter a shift amount: ")));
         
         try{
            transformFile(inFile,outFile,shift);
            main(null);
            }
            catch(IOException e)
            {
               System.out.println("File not found");
               }

     
        }
         if(choice=='D'&&hasQuit == false)
        {
           String inFile =(promptForString(input,"Enter an input file: "));
         String outFile = (promptForString(input,"Enter an output file: "));
          int shift = Integer.parseInt((promptForString(input,"Enter a shift amount: ")));
          
          try{
            transformFile(inFile,outFile,(-shift));
            
            main(null);
            }
            catch(IOException e)
            {
               System.out.println("File not found");
               }

           }
        
          if(choice==' ')
            {
         System.out.println("ERROR! Enter a valid value!\n");
            
         choice = getChoice(input);
          
            }
         if(choice=='Q')
         {
    
            System.out.println("\nGoodbye!");
                    choice='Q';
            hasQuit = true;
            break;
         }
        }
       
       
    }

}
