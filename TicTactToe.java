import java.util.Scanner;
/*
A program to simulate tic tac toe
I would like to preface with an apology 
if anyone reads this code it might be some the ugliest 
and worst code I have ever written but at least it runs ;).
*/
public class TicTacToe {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int row;
      int col;
      Board board = new Board();
       board.print();
      while(true)
      {
      
       System.out.print("x player: Enter row and column numbers:");
       while(true)
       {
       row = input.nextInt();
       col = input.nextInt();
       
       if(row==0||col==0)
       {
          System.out.println("Incorrect cell. Try again!");
          System.out.print("Enter row and column numbers:");
          continue;
          }
      if(board.setRowCol(row-1,col-1)==false)
      {
         System.out.println("Incorrect cell. Try again!");
          System.out.print("Enter row and column numbers:");
         continue;
         }
       break;
          }
       
      
        board.print();
      if(board.isWin())
      {
         System.out.println("x player wins!\nGoodbye!");
         break;
         }
      if(board.isFull())
      {
         System.out.println("Board is full!");
         }
         
      board.changePlayer();
      /////////////////////////////////////////////////////////
       System.out.print("o player: Enter row and column numbers:");
       while(true)
       {
        
          row = input.nextInt();
          col = input.nextInt();
          
          if(row==0||col==0)
          {
             System.out.println("Incorrect cell. Try again!");
             System.out.print("Enter row and column numbers:");
             continue;
         }
         else if(board.setRowCol(row-1,col-1)==false)
         {
             System.out.println("Incorrect cell. Try again!");
             System.out.print("Enter row and column numbers:");
            continue;
            }
       break;
          }
          
      
      board.print();
      if(board.isWin())
      {
         System.out.println("o player wins!\nGoodbye!");
         break;
         }
      board.changePlayer();
      
      if(board.isFull())
      {
         System.out.println("Board is full!");
         }
      }
   }
}
import java.util.*;
import java.io.*;

public class Board {

    private char[][] board = new char [3][3]; 
    private char currentPlayer;
	
	   /**
     * This is the constructor for the class. It initializes the board so all cells in the board are equal to '-'. The currentPlayer 
     * is initialized to 'x'.
     *
     */
     public Board()
     {
        currentPlayer='x';
        for (int k = 0; k<board.length;k++)
        {
        for(int i = 0; i<board.length;i++)
        {
           board[k][i] = '-'; 
           }
        }

     }
	
	  /**
     * The method outputs the board in the following format. First the message "Current board" underligned is printed. 
     * Then the content of the board is printed as a 3 by 3 matrix.
     */
     public void print()
     {
       System.out.println("Current Board");
       System.out.println("-------------");
   
      for (int row = 0; row<3; row++) 
         {
          for (int col = 0; col<3; col++) 
          {
              System.out.print(board[row][col]+"  ");
          }
         System.out.println();
        }
     
     }
	
	  /**
     * The method checks if all the positions on the board have been played.
     *
     * @return true if all the cells in the board are different than '-', false otherwise.
     */
     public boolean isFull() 
     {
         for (int row = 0; row<3; row++) 
         {
          for (int col = 0; col<3; col++) 
          {
              if(board[row][col]=='-')
              {
                 return false;
                 }
          }
         
        }
        return true;
     }
	
	  /**
     * The method checks if there is a winner.
     *
     * @return true if either a column, a row or a diagonal is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     public boolean isWin()
     {
        
      if(checkRows()==true)
      {
         return true;
         }
      if(checkColumns()==true)
      {
         return true;
         }
      if(checkDiagonals()==true)
      {
         return true;
         }
            return false;
     }
    
	  /**
     * The method checks if at least one row is occupied by the same player.
     *
     * @return true if any row is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     private boolean checkRows() 
     {
        for(int row = 0; row<3; row++)
      {
         if(board[row][0]==board[row][1]&&board[row][1]==board[row][2]&&(board[row][2]=='x'||board[row][2]=='o'))
         {
            return true;
         }
       
      }
        return false;
     }
	 
	  /**
     * The method checks if at least one column is occupied by the same player.
     *
     * @return true if any column is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     private boolean checkColumns() 
     {
          for(int col = 0; col<3; col++)
      {
         if(board[0][col]==board[1][col]&&board[1][col]==board[2][col]&&(board[2][col]=='x'||board[2][col]=='o'))
         {
            return true;
         }
      }
     return false;
     }
	
	  /**
     * The method checks if at least one diagonal is occupied by the same player.
     *
     * @return true if any diagonal is filled by the same character and the character is different than '-',
     * false otherwise.
     */
     private boolean checkDiagonals() 
     {
      
      if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&(board[2][2]=='x'||board[2][2]=='o'))
      {
         return true;
         }
      if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&(board[2][0]=='x'||board[2][0]=='o'))
      {
         return true;
         }
        
     return false;
     }
     
     /**
     * The method changes the currentPlayer. If the currentPlayer is 'x', it changes to 'o'.  
     * If the currentPlayer is 'o', it changes to 'x'. 
     *
     */
     public void changePlayer()
     {
        
        if(currentPlayer == 'x')
        {
           currentPlayer = 'o';
           }
      else if(currentPlayer=='o')
      {
         
         currentPlayer='x';
         }

     }
     
	  /**
     * The method attempts to set the cell on the position indicated by the row and column given to the currentPlayer value if
     * the cell is unoccupied (equal to '-') in which case returns true. If the position is occupied (not equal to '-') the cell
     * remains unchanged and the method returns false.
     *
     */
     public boolean setRowCol(int row, int col) 
     {
       
      if(board[row][col]!='-')
      {
         return false;
         }
      else
      {
       
         board[row][col]= currentPlayer;
      return true;
      }
	
     }
}

