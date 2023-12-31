/**
 * A guessing number game in which a user has to guess the number,using if then else statement
 *
 * @author Sam halsey
 * @version 19092022
 */
import java.util.Scanner;
import java.util.Random;

public class GuessANumber {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
    System.out.print("Enter a random seed: ");
    int seed = input.nextInt();
    //Finds the seed
    String blank = input.nextLine();
    //Making sure the rest of the line is used so I dont have any issues for later variables
    Random rand = new Random(seed);
    //creates the random generator wit the provided seed
 int num = rand.nextInt(200)+1;
 //I have absolutely no idea why I had to do this 
 //but the number was always one less than what it should've been
    //System.out.println("DEBUG: The number picked is: "+num+"\n");
  
   //creates a random number that is less than 200

   int userGuess = 0;
   //Initializes the userGuess so that the loop can run
   //Might not be the most efficient way but it owrks
   int loopCounter=1;
   //Makes sure that the first loop ran is counted toward the toal

      
   while(userGuess !=num)
   {
      System.out.print("Enter a guess between 1 and 200: ");
      userGuess = input.nextInt();
      
       if(userGuess>200||userGuess<0) //Only executes if guess is outside of range
      {
         System.out.println("Your guess is out of range.  Pick a number between 1 and 200.");
         }
      if(userGuess!=num && userGuess <num) //Executes if the wrong number was chosen and was too low
      {
         System.out.println("Your guess was too low - try again.\n");
      }
      if(userGuess!=num && userGuess >num) //Executes if the wrong number was chosen and was too high
      {
         System.out.println("Your guess was too high - try again.\n");
      }
      
       if (userGuess == num) //only executes if the correct number is correct
   {
      System.out.println("Congratulations!  Your guess was correct!");
      System.out.println("\nI had chosen "+num+" as the target number.");
      System.out.println("You guessed it in "+loopCounter+" tries.");
      
      
      if(loopCounter<2)//These loops execute to the number of tries for the correct saying
      {
         System.out.println("That was impossible!");
         }
      else if(loopCounter<4)
      {
         System.out.println("You're pretty lucky!");}
      else if(loopCounter<8)
      {System.out.println("Not bad, not bad...");}
      else if(loopCounter==8)
      {
         System.out.println("That was not very impressive.");}
      else if(loopCounter<11) 
      {
         System.out.println("Are you having any fun at all?");}
      else if (loopCounter>=11)
      {
         System.out.println("Maybe you should play something else.");
      }
      }  
      
      
     
      loopCounter+=1;
      //Adds one count everytime the loop executes
      
      }
    input.close();
    }
}
