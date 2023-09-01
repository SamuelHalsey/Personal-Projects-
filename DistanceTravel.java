/**
 * This is a program that says how far
 an object moves based on its intial speed and trajectory, 
I am going to use a for loop for simplicity
 * 
 * @author Samuel Halsey
 * @version 03102022
 **/
 import java.util.Scanner;
public class TrajectoryModelingIntro {

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
      System.out.print("Enter an initial speed: ");
      double intSpeed = input.nextDouble();
      System.out.print("\n");
      
for(int degrees = 25; degrees<=85;degrees+=5)
{
   double cos = Math.cos(Math.toRadians(degrees));
   double sin = Math.sin(Math.toRadians(degrees));
   //System.out.format("cos("+degrees+") = %.2f%n", cos);
   //System.out.format("sin("+degrees+") = %.2f%n", sin);
     // System.out.println(intSpeed); Made this print statement while creating code to make sure the variable was correct
      
      double airTime = ((2*intSpeed)*sin)/9.8;
      //System.out.println(airTime); Made this print statement while creating code to make sure the variable was correct
      
      double distanceTravel =intSpeed*airTime*cos;
      System.out.printf("At angle "+degrees +".00 projectile travels %.2f meters\n",distanceTravel);

   }

	}

}
