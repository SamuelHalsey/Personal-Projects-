
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.io.FileInputStream;

public class DataAnalysisLab {
   public static void OrganizeFile(String fname, int numCounties)
   {
      FileInputStream fileByteStream = null;
      Scanner inFS = null;   
      try {
   
         fileByteStream = new FileInputStream(fname);
         inFS = new Scanner(fileByteStream);
      }
      catch (FileNotFoundException e) {
          System.err.println("ERROR - File "+fname+" not found!");
        }
         String header = inFS.nextLine();//Gets rid of the first line which is the header
         String[] firstCountPop = new String[numCounties];
         String[] lastCountPop = new String[numCounties];
         String[] countNames = new String[numCounties];
         
          String[] popNums = new String[11];
         
         for (int i = 0; i<numCounties; i++) { 
            
             String filedata = inFS.nextLine();
            
            popNums = filedata.split(",");
            countNames[i]=popNums[0];
            firstCountPop[i] = popNums[1];
            lastCountPop[i] = popNums[10];
             
         }
        System.out.println(Arrays.toString(countNames));
         System.out.println(Arrays.toString(firstCountPop));
         System.out.println(Arrays.toString(lastCountPop));
         
      FileInputStream fileByteStream1 = null;
      Scanner inFS1 = null;  
    
      fileByteStream1 = new FileInputStream(fname);
      inFS1 = new Scanner(fileByteStream1);
        String header1 = inFS1.nextLine(); //Gets rid of the first line which is the header
      String[] popNums1 = new String[11];
      String[] countNames1 = new String[numCounties];  
     
        
         for (int j = 0; j<numCounties; j++)
       {
           
            
           String filedata1 = inFS1.nextLine();
          
            popNums1 = filedata1.split(",");
    
            countNames[j]=popNums1[0];
            firstCountPop[j] = popNums1[1];
            lastCountPop[j] = popNums1[10];
         
         int firstCountVal =Integer.parseInt(popNums1[1]);
         int finalCountVal = Integer.parseInt(popNums1[10]);
         int netNum = finalCountVal-firstCountVal;
         
    
         System.out.println(countNames[j]+": "+netNum);
          }
       
        
      
         
   }
   public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     
      System.out.print("Enter a filename: ");
      String fname = input.nextLine();
      
      System.out.print("Enter number of counties: ");
      int numCounties = input.nextInt();
      
      
      OrganizeFile(fname,numCounties);
    
      
   }
    
}
