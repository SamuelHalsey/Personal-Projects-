/**
 * Program to copy one file into another, using command line arguments
 *
 * @author Samuel Halsey

 * @version 10312022
 *
 */
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;

public class ReadingTextFileInput {
   
   /**
    * Displays the file given by fname to the screen
    * 
    * @param fname file to be displayed
    */
   public static void displayFile(String fname) {
      FileInputStream fileByteStream = null;
      Scanner inFS = null;   
        //TODO: Open the file and print each line to the screen.
        //TODO: Don't forget to close the file when you are done.
        try {
           
      fileByteStream = new FileInputStream(fname);
      inFS = new Scanner(fileByteStream);
      String username = inFS.nextLine();
      System.out.print(username);
      
    
      
      while (inFS.hasNextLine()) {
         
         
         
       String filedata = inFS.nextLine();
       
       
          
       System.out.print("\n");
       System.out.print(filedata);
       
    }
    

    }
         catch (FileNotFoundException e) {
          System.out.println("ERROR - File "+fname+" not found!");
        }
   }
   

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a filename: "); 
      String fname = input.nextLine();
      displayFile(fname);
      
      

    }

}
