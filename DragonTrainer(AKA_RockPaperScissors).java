/**
 * Basically pokemon or rock paper scisssor but with dragons, used methods and classes to create
 * @author Samuel Halsey
 * @version 20/10/2022
 */
import java.util.Random;
import java.util.Scanner;

public class DragonTrainers {
    
    /**
     * Constant array to hold the types of the dragon in order. 0 - Plant, 1 -
     * Water, 2 - Fire. Make sure your code does not change these values!
     */
    private static final String[] DRAGONS = { "Plant", "Water", "Fire" };

    /**
     * Prompts the user with the message: "How many matches will we play? " and
     * takes in an integer as input. If the user enters a value that is 0 or
     * negative, displays the error message: "ERROR - number of matches must
     * be positive!" and asks again. Continues looping until the user enters a
     * positive number.
     *
     * @param input
     *            - Scanner to read values from the keyboard
     * @return - an integer value strictly larger than zero.
     */
    public static int getNumberOfMatches(Scanner input) {
        System.out.print("How many matches will we play? ");
  int numMatches = input.nextInt();
   //Interestingly enough I had to make this variable for ablank line
   //Because the rest of the line kept messing up my next input value
   String isBlank = input.nextLine();
  
   while(numMatches<=0)
   {
        
   System.out.println("ERROR - number of matches must be positive!");
   System.out.print("How many matches will we play? ");
   numMatches = input.nextInt();
   
   //Interestingly enough I had to make this variable for ablank line
   //Because the rest of the line kept messing up my next input value
   isBlank = input.nextLine();
   }
    return numMatches;
    }

    
   
    public static String promptForDragon(Scanner input) {
        System.out.print("Please select a dragon [Plant/Water/Fire]: ");
        String dragonType= input.nextLine();

        while(dragonType.equals("")|| dragonType==null)//Checking to see if input is just a blank line, loops until input is provided
    {
       System.out.println("ERROR - Dragon prompt cannot be empty.");
        System.out.print("Please select a dragon [Plant/Water/Fire]: ");
        dragonType = input.nextLine();
       }
      
      return dragonType;
    }

    /**
     * Takes a single UPPERCASE character. If it is a 'W','P' or 'F' returns the
     * appropriate numeric value given the dragon types in the array DRAGON
     * (i.e. 0 for 'P', 1 for 'W', 2 for 'F'). If it is none of these returns a
     * -1 to represent an invalid value.
     *
     * @param dragon
     *            - the UPPERCASE character to look up a value for.
     * @return 0 if dragon is 'P', 1 if dragon is 'W', 2 if dragon is 'F', -1
     *         otherwise
     */
   
    public static int dragonToNumber(char dragon) 
    {
      int numChosen; //I found the easiest way to do this was just initialize new variable.
      
      if(dragon=='P')
     {
         numChosen = 0;
         return numChosen;
      }
       if(dragon=='W')
     {
         numChosen = 1;
         return numChosen;
      }
       if(dragon=='F')
     {
         numChosen = 2;
         return numChosen;
      }
       return -1;
    }

    /**
     * Takes a number representing the player's choice and another representing
     * the computer's choice. Returns a 0 if they tie, a 1 if the player wins,
     * and a -1 if the player loses. Note that the values map to the indexes of
     * the array DRAGONS above (0 is a Plant dragon, 1 is a Water dragon, 2 is a
     * Fire Dragon).
     *
     * @param player
     *            - value 0-2 representing player dragon choice
     * @param cpu
     *            - value 0-2 representing computer dragon choice
     * @return 1 if the player wins, -1 if the computer wins, 0 if they tie
     */
    public static int determineWinner(int player, int cpu) {
      
      // System.out.print("Player = "+player+" cpu = "+cpu); 
      //Used this when I was trying to figure out why my code didnt work
        if(player == 0 && cpu ==2)
        {
           return -1;
         }
         if(player==1 && cpu==0)
         {
            return -1;
            }
         if(player==2&&cpu==1)
         {
            return-1;
            }
         if(player==cpu)
         {
            return 0;
            }
            if(player == 2 && cpu ==0)
        {
           return 1;
         }
         if(player==0 && cpu==1)
         {
            return 1;
            }
         if(player==1&&cpu==2)
         {
            return 1;
            }   
       return 5;//Had to add this return statement or code wouldn't compile,
       //I made it 5 so when I was checking the numbers while coding I could tell if something was off
       //Since technically it should never return 5
    }

    /**
     * Takes a number representing the player's choice and another number
     * representing the computer's choice, and a third number that is positive
     * if the player is the winner, negative if the computer is the winner, and
     * 0 if they tied. Then displays the appropriate player defeats computer or
     * computer defeats player or tie message as given in the project
     * description.
     *
     * @param player
     *            index into the DRAGONS array representing the player choice
     * @param cpu
     *            index into the DRAGONS array representing the computer's
     *            choice
     * @param winner
     *            0 for a tie, positive for a player win, negative for a
     *            computer win
     */
    public static void displayMatchResult(int player, int cpu, int winner) 
    {
      
    //  System.out.println(player+" "+cpu+" "+winner);
    //Test statement I used while coding to see what numbers were being inputed
    
    //CPU Wins
      if(winner ==-1&&(cpu ==2&&player==0))
      {
         System.out.println("Fire defeats Plant - you lose!");
         }
      if(winner ==-1&&(cpu ==0&&player==1))
      {
         System.out.println("Plant defeats Water - you lose!");
         }
      if(winner ==-1&&(cpu ==1&&player==2))
      {
         System.out.println("Water defeats Fire - you lose!");
      }
       //Tie  
      if(winner==0)
      {
         System.out.println("A Tie!");
      }
         
       //Player Wins  
      if(winner ==1&&(cpu ==0&&player==2))
      {
         System.out.println("Fire defeats Plant - you win!");
      }
      if(winner ==1&&(cpu ==1&&player==0))
      {
         System.out.println("Plant defeats Water - you win!");
      }
      if(winner ==1&&(cpu ==2&&player==1))
      {
         System.out.println("Water defeats Fire - you win!");
      }  
    }

    /**
     * Takes the number of wins, losses and ties and displays the final message
     * and summary statistics as given in the project description.
     *
     * @param wins
     *            number of total wins for the player
     * @param losses
     *            number of total losses for the player
     * @param ties
     *            number of ties
     */
    public static void displayFinalResult(int wins, int losses, int ties) 
    {
      //End of tourney print statemetns that will display everytime
      System.out.println("The tournament is over!");
      System.out.println("We tied "+ties+" matches.");
      System.out.println("I won "+losses+" matches.");
      System.out.println("You won "+wins+" matches.");
      
      
      if(wins==losses) //Makes sures in any case that the ties will execute
         {
         System.out.println("Neither of us can claim victory here!");
         }
      
      if(losses>wins&&losses>ties) //Makes sure that there are more losses than wins and ties
         {
         System.out.println("I am the winner!");
         }
      if(wins>losses&&wins>ties)//Makes sure that there are more wins than lossses and ties
         {
         System.out.println("You are the winner!");
         }
    }

    /**
     * NOTE: The main method has been completed for you. If you correctly
     * complete the methods above, the main method will "just work" and produce
     * the correct output.
     */
    public static void main(String[] args) {
        // Prompt for a random number seed
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a random seed: ");
        int seed = Integer.parseInt(keyboard.nextLine());
        // Create a Random instance with the seed
        Random rnd = new Random(seed);
        // Prompt for number of matches to play
        int totalMatches = getNumberOfMatches(keyboard);

        // Start with wins, losses and ties at 0.
        // Repeat until all matches have been played (use the sum of the
        // results so we don't need another variable)
        int wins = 0, losses = 0, ties = 0;
        while ((wins + losses + ties) < totalMatches) {
            // Ask the user for a dragon to use
            String input = promptForDragon(keyboard);

            // Get the first character of the user's input as an uppercase
            // value.
            char dChar = input.toUpperCase().charAt(0);

            // Convert the user's input to an index for the DRAGONS array
            int playerDragon = dragonToNumber(dChar);

            // Generate a choice between 0 and 2 for the computer
            int cpuDragon = rnd.nextInt(3);

            // Display the results
            System.out.println("I chose: " + DRAGONS[cpuDragon] + " dragon.");

            // If the player didn't enter a valid choice, print out an error
            // message and increase the number of losses.
            if (playerDragon == -1) {
                System.out.println("You don't have the " + input + " dragon.");
                System.out.println("So no dragon fights for you.");
                System.out.println("I win by default!");
                losses++;
            } else {
                // Print out the player's choice.
                System.out.println("You chose: " + DRAGONS[playerDragon] + " dragon.");
                // Determine who won the match.
                int winner = determineWinner(playerDragon, cpuDragon);
                // Display the result of the match.
                displayMatchResult(playerDragon, cpuDragon, winner);

                // Increase the count of wins, losses or ties according to
                // who won the match.
                if (winner > 0) {
                    wins++;
                } else if (winner < 0) {
                    losses++;
                } else {
                    ties++;
                }
            }
            System.out.println();
        }
        // Display the final summary of the match to the screen.
        displayFinalResult(wins, losses, ties);

        // Don't forget to close the Scanner!
        keyboard.close();
    }

}
