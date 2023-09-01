/**
 * This is a program to fill an array with input given by the user
 * 
 * @author Samuel Halsey
 * * @version 09102022
 */
import java.util.*;

public class FillArray {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numDigits = 0;
   
    
     System.out.print("Please enter the number of digits to be stored: ");
     numDigits = input.nextInt();
    while (numDigits<-1)
    {
       System.out.println("ERROR! You must enter a non-negative number of digits!");
       System.out.println("");
       System.out.print("Please enter the number of digits to be stored: ");
     numDigits = input.nextInt();
       }
    if (numDigits>0)
    {
   //System.out.print("Please enter the number of digits to be stored: ");
     //numDigits = input.nextInt();
    int[] storedDigits = new int[numDigits];
   for(int i = 0; i<numDigits;i++)
   {
      int digit;
      System.out.print("Enter integer "+i+": ");
      digit = input.nextInt();
      storedDigits[i] = digit;
     // System.out.print(digit);
      
      }
      System.out.println("The contents of your array:");
      System.out.println("Number of digits in array: "+storedDigits.length);
      System.out.print("Digits in array:");
      
   for(int j = 0; j<storedDigits.length;j++)
   {     
       System.out.print(" ");
      System.out.print(storedDigits[j] );
     
         
   }
  
   
    }
   if(numDigits == 0)
   {
      System.out.print("No digits to store? Goodbye!");
      }
        System.out.println("");
  
  }
  
}
