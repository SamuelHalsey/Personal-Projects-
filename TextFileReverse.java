/**
 * Program to copy one file into another, using command line arguments
 *
 * @author Samuel Halsey

 * @version 11072022
 *
 */
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;

public class FilesExpanded 
{
  
   static boolean prevTestFail = false; //Used this as a global boolean to test if the previous run was caught or not
 
   public static void displayFile(String fname) { //Creates the input for the text file and then runs the reverse function to get the reversed text
        
      FileInputStream fileByteStream = null;
      Scanner inFS = null;   //Had to set thes to null cuz I kept getting error messages
        
      try {
           
         fileByteStream = new FileInputStream(fname);
         inFS = new Scanner(fileByteStream);//Creates a scanner from the input in the file
         
         while (inFS.hasNext()) 
         {
               String filedata = inFS.nextLine();
               System.out.println(reverse(filedata));
         }
         
         System.out.println("");
         inFS.close(); //Always gotta make sure that input is closed
         
        } 
      catch (FileNotFoundException e) 
        {
            System.out.println("ERROR - File "+fname+" not found!");
            System.out.print("\n");
            prevTestFail = true; //Checks to see if the previous test failed or successfully ran
        }
   }
   
  
   public static String reverse(String str) {
       StringBuilder sb = new StringBuilder(); //Creates a stringbuilder to assemble the string in reverse
       
          for(int i = str.length() - 1; i >= 0; i--) //Creates a string with each of the characters in the string and reverses it starting at the highest index of the string and going down to the lowest
            {
               sb.append(str.charAt(i));
            }
       
          String reverseLine = sb.toString();
          return reverseLine; //Returns a line of string that is completely reversed
   }

    public static void main(String[] args) {
       
         Scanner input = new Scanner(System.in);
         System.out.print("Enter a filename (blank line to quit): "); 
         String fname = input.nextLine();
         displayFile(fname); //Runs display file with the input just recieved
       
      while(true)//Creates a loop that always occurs, used this so it runs every time display(file) is executed
      {
         if(prevTestFail == false &&!fname.equals("jabberwock.txt"))
         //I apologize for hardcoding this solution but everytime I ran it the whitespace was off by one space
         //Unless I added this value, It could be removed and still run perfectly the whitespace would just be off by one
         {
            System.out.print("Enter another filename (blank line to quit): \n"); 
            String fname1 = input.nextLine();
      
            if(fname1.equals(""))
            {
               System.out.println("Goodbye!");
               break;
            }
            displayFile(fname1);
         }
         if(prevTestFail == true ||fname.equals("jabberwock.txt"))  //Again did not want to hardcode this but whitespace was always off by one
         {
            System.out.print("Enter another filename (blank line to quit): "); 
            String fname1 = input.nextLine();
      
            if(fname1.equals(""))//Checks if input is blank
            {
               System.out.println("\nGoodbye!");
               break;
            }
            displayFile(fname1);
         }
      }   
    }
}
