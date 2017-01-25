package gamebox;
import controller.*;
import exception.GameException;
import model.TicTacToeModel;
import view.View;

public class TicTacToe implements GameState{


int index=1; 

	
public TicTacToe(){
	 
}

	@Override
	public void run() throws GameException {
	System.out.println("TicTacToe is running");
	Controller controller =Controller.getInstance(index);
	}

	@Override
	public void exit(){
	System.out.println("TicTacToe has ended");
	TicTacToeModel.reset();
	View.setInstance(); 
    View.closeWindow();	
		
	}

}
