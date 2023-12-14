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

public class ReverseFileInput
{
	 
	   /**
	     * No argument constructor--private to prevent instantiation.
	     */
	 private ReverseFileInput() {
	        // no code needed here
	    }
 
   public static void displayFile(String fname) {
	 
	   
	    
        
	   //Creates input streams to transport data from source to the code
      FileInputStream fileByteStream = null;
      Scanner inFS = null;   
        
      try {
           
         fileByteStream = new FileInputStream(fname);
         inFS = new Scanner(fileByteStream);
         
         while (inFS.hasNext()) 
         {
        	 //Reverses each string line by line
               String filedata = inFS.nextLine();
               System.out.println(reverse(filedata));
         }
         
         System.out.println("");
       
         inFS.close(); 
         
        } 
      catch (FileNotFoundException e) 
        {
            System.err.println("ERROR - File "+fname+" not found!");
        }
   }
   
  
   public static String reverse(String str) {
	  
	   String reversed = "";
	   //Appends each character in backwards order to a new string
	   for(int i =str.length()-1; i>=0; i--)
	   {
		   reversed+=str.charAt(i);
	   }
	   return reversed;
   }

    public static void main(String[] args) {
       
         Scanner input = new Scanner(System.in);
         String fname = " ";
         //loop that only runs as long as the input is not a blank line
         while(!fname.equals(""))
         {
        	 
         System.out.print("Enter a filename (blank line to quit): "); 
         fname = input.nextLine();
         //Ensure that the method only runs if the input is not blank
         if(!fname.equals(""))
         {
         displayFile(fname); 
         }
            
         }
            
         System.out.println("\nGoodbye!");
            input.close();
         }
       
    }
