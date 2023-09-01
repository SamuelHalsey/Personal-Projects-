/**
 * Fun with Strings
 * 
 * @author Samuel Halsey
 * @version 09132022
 **/
import java.util.Random;
import java.util.Scanner;

public class FunWithBranching {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String seed;
     
      
      System.out.print("Enter a random number seed: ");
       seed = input.nextLine();
      int seed1 = Integer.parseInt(seed);
      System.out.print("Enter your name: ");
      String name = input.nextLine();
      System.out.println("Hello "+name+"!");
      System.out.println("Please answer the following questions");
      //seed = input.nextLine();
      //int seed1 = Integer.parseInt(seed);
      System.out.println(seed1);
      Random rnd = new Random(seed1);
      int num1 = rnd.nextInt(20);
      int num2 = rnd.nextInt(20);
      
      int answerA = num1+num2;
      System.out.print(num1+" + "+num2 + " = ");
      String userAnswerA = input.nextLine();
      int userAnswerAI = Integer.parseInt(userAnswerA);
      if(userAnswerAI == answerA)
      {
         System.out.println("Correct!");}
      else if (userAnswerAI != answerA)
      {
         System.out.println("Wrong!\nThe correct answer is: "+answerA);}
      
      
      int numa1 = rnd.nextInt(20);
      int numa2 = rnd.nextInt(20);
      int answer2 = numa1-numa2;
      System.out.print(num1+"-"+numa2+" = ");
       String userAnswerB = input.nextLine();
      int userAnswerBI = Integer.parseInt(userAnswerB);
      if(userAnswerBI == answer2)
      {
         System.out.println("Correct!");}
      else if (userAnswerBI != answer2)
      {
         System.out.println("Wrong!\nThe correct answer is: "+answer2);}
      
      
      double numb1 = rnd.nextInt(20);
      double numb2 = rnd.nextInt(20);
      double answerC = numb1/numb2;
      
      
      
   }
}
