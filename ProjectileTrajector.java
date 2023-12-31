/**
 * A program to calculate the best trajectory of an object to a given distance. I am unsure if this was the most effective strategy,
 * Perhaps an array couldve been used to make this easier but I am not sure
 * 
 * @author Samuel Halsey
 * @version 06102022
 **/

import java.util.*;//Importing everything incase I use more than just scanner
public class TrajectoryModeling {

	
	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
      System.out.print("Enter a distance to target: ");
      double distance = input.nextDouble();
      System.out.print("\n");
      double distanceOff=100;//I had to set all of these values super high or else the program would just say the best value was 0
      double bestHit = 100;
      int bestDegree = 100;
      int bestSpeed = 100;
      double bestTravel = 100;
for(int degrees = 90; degrees>=25;degrees-=5)//Starts an outerloop for every degree possible
{
   double cos = Math.cos(Math.toRadians(degrees));//Converts radians into degrees
   double sin = Math.sin(Math.toRadians(degrees));//Converts radians into degrees
   
   for(int speed = 0; speed<=30; speed++)//Creates the inner loop for every speed possible
   {
      double airTime = ((2*speed)*sin)/9.8;//Calculates how long its in the air
      double lastDistance=0;//Had to set this to 0 since there is no last distance, I used this variable to find the best distance off
      double distanceTravel =speed*airTime*cos;//Calculates the total distance the projectile travels
      lastDistance = distanceOff;//Sets the last distance to the last instance of distanceOff before a new one is created
      distanceOff=distanceTravel-distance;//Calculates how far the target was off by
      
      if(distanceOff<0)distanceOff=-distanceOff;//Made sure there was no negative values
    

     // System.out.printf("Projectile with "+speed+" speed and "+degrees+" degrees went %.2f%n",distanceOff);
     //Used these two print statements to help a lot when creating this program
  //   System.out.printf("Last distance was %.2f%n",lastDistance);
      
      if((distanceOff<=lastDistance&&distanceOff<=bestHit))//This seems like a very dumb way to approach this but it works
      {
         bestHit = distanceOff;
         bestSpeed = speed;//Sets the best speed to the one on that loop
         bestDegree = degrees;//Sets the best degree to the one on that loop
         bestTravel = distanceTravel;
         }
      
         
     
}
   }


 System.out.println("Best angle: "+ bestDegree+".00");
 System.out.println("Best speed: "+ bestSpeed+".00");
 System.out.printf("Distance travelled: %.2f%n",bestTravel);
 System.out.printf("Missed the target center by: %.2f%n",bestHit);
 
 
 input.close();
	}


}
