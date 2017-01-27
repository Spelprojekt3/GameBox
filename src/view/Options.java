package view;

import javax.swing.JOptionPane;

import model.Enum.Player;

public class Options {

static int size;


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
	    

	    
 
public void askBordSize() {
	        String message = "Write the size of the board";
	        boolean keepGoing = true;
	        while (keepGoing==true) {
	            do {
	                try {
	                    String s = JOptionPane.showInputDialog(null, message,
	                            "Write the size",
	                            JOptionPane.OK_OPTION);
	                    if (s == null) {
	                        int confirmExit = JOptionPane.showConfirmDialog(null,
	                                "Är du säker på att du vill avsluta?", null,
	                                JOptionPane.YES_NO_OPTION);
	                        if (confirmExit == JOptionPane.YES_OPTION) {
	                            System.exit(0);
	                        }
	                    }
	                    size= Integer.parseInt(s);
	                } catch (NumberFormatException e) {
	                	
	                }
	                message = "<html><b style='color:red'>Fel, ange storlek:</b><br>"
	                        + "Ange 1-10";
	                System.out.println("input was: " + size);
	                keepGoing=false;
	            } while (size>10 || size<3 && keepGoing);
	            
	        }         
}
public static int getSize(){

return size; 
}

};



