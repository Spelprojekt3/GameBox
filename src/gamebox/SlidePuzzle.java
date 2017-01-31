package gamebox;

import controller.*;
import exception.GameException;
import model.Enum.Player.Game;
import model.SlidePuzzleModel;
import model.TicTacToeModel;
import view.Options;
import view.View;


public class SlidePuzzle implements GameState {
	


	
public SlidePuzzle(GameBox gameBox){
}

	public SlidePuzzle() {
	// TODO Auto-generated constructor stub
}

	@Override
	public void run() throws GameException {
		System.out.println("SlidePuzzle is running");
		Controller controller = Controller.getInstance(Game.SLIDEPUZZLE);	
	}

	@Override
	public void exit() {
		System.out.println("SlidePuzzle has ended");
		SlidePuzzleModel.reset();
	    View.closeWindow();		
	}

}
