package view;

import javax.swing.JOptionPane;

import model.Enum.Player;

public class Options {


public static final String[]sizeS= { "3", "4", "5", "6","7","8","9","10" };


public static int size; 


String message; 
private static String opponent;

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
	    

	 

public static int getSize(){
	
return size; 
}
  
public void askBoardSize()
{
   
    String choise= (String) JOptionPane.showInputDialog( 
        null, "Choose a size",
        "Boardsize",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        sizeS,null);
        size= Integer.parseInt(choise); 
        System.out.println("Size was: "+size);      
}

public void showWinner()
{
	
}







};



