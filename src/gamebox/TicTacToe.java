package gamebox;
import controller.*;

import exception.GameException;

import model.Enum;
import model.TicTacToeModel;
import view.Options;
import view.View;

/**
 * TicTacToestate 
 * @author Marcus, Christoffer
 *
 */
public class TicTacToe implements GameState{





	
public TicTacToe(GameBox gameBox){
	 
}
/**
 * Runs TicTacToe and sets the index of the controller instance 
 */
	@Override
	public void run() throws GameException {
	System.out.println("TicTacToe is runing");
	Controller controller =Controller.getInstance(Enum.TICTACTOE.value());
	}
/**
 * Exits TicTacToe
 */
	@Override
	public void exit(){
	System.out.println("TicTacToe has ended");
	TicTacToeModel.reset();
    View.closeWindow();	
		
	}

}
