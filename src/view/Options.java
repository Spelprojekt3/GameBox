package view;

import javax.swing.JOptionPane;

import model.Enum.Player;
/**
 * Handles inputs from the user  
 * @author Marcus, Christoffer 
 *
 */
public class Options {


public static final String[]sizeS= { "3", "4", "5", "6","7","8","9","10" };


public static int size; 


String message; 
private static String opponent;
/**
 * Asks if the opponent should bee a computer or a human player
 * @return the  chosen opponent  
 */

public static String askForOpponent()
{
	Object[] options = {"Human", "Ai"};
	        int choice = JOptionPane.showOptionDialog(null,
	                "Do you want to play against a human or Ai?", "Choose your opponent:",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                null, options, options[0]);

	        if(choice == JOptionPane.YES_OPTION)
	        {
	            opponent=Player.HUMAN;
	        }
	        else if(choice == JOptionPane.NO_OPTION)
	        {
	            opponent =Player.AI;
	        }
	        else if(choice == JOptionPane.CLOSED_OPTION)
	        {
	            opponent = Player.HUMAN;
	        }
	        return opponent;
	    }

	    
	    public static String getOpponent()
	    {
	        return opponent;
	    }
	    

	 
/**
 * Size of the TicTacToe board
 * @return the size as an integer
 */
public static int getSize(){
	
return size; 
}
 /**
  * Asks the user to choose the size of the TicTacToe-board 
  */
public void askBoardSize()
{
   
    String choise= (String) JOptionPane.showInputDialog( 
        null, "Choose a size",
        "Boardsize",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        sizeS,null);
        if(choise ==null){
        JOptionPane.getRootFrame().dispose();   
        }
        size= Integer.parseInt(choise); 
        System.out.println("Size was: "+size);      
}

public static void showWinner(String winner)
{
	String winnerO="Winner is player O",winnerX="Winner is player X",winnerD="It´s a tie!" 
	,winnerS="Congratulations, you have solved the puzzle";
	if(winner=="X")
	{
	JOptionPane.showMessageDialog(null, winnerX);
	}
	if(winner=="O")
	{
	JOptionPane.showMessageDialog(null, winnerO);	
	}
	if(winner=="D")
	{
	JOptionPane.showMessageDialog(null, winnerD);	
	}
	if(winner=="WS")
	{
	JOptionPane.showMessageDialog(null,winnerS);
	}
	
}







};



