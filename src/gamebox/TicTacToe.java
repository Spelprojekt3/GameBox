package gamebox;
import controller.*;
import exception.GameException;
import model.Enum.Player.Game;
import model.TicTacToeModel;
import view.Options;
import view.View;

public class TicTacToe implements GameState{




	
public TicTacToe(GameBox gameBox){
	 
}

	@Override
	public void run() throws GameException {
	System.out.println("TicTacToe is running");
	Controller controller =Controller.getInstance(Game.TICTACTOE);
	}

	@Override
	public void exit(){
	System.out.println("TicTacToe has ended");
	TicTacToeModel.reset();
    View.closeWindow();	
		
	}

}
