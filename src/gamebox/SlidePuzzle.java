package gamebox;

import controller.*;
import exception.GameException;
import model.SlidePuzzleModel;
import model.TicTacToeModel;
import view.View;


public class SlidePuzzle implements GameState {
	

 
int index=2; 
	
public SlidePuzzle(){
}

	@Override
	public void run() throws GameException {
		System.out.println("SlidePuzzle is running");
		Controller controller = Controller.getInstance(index);	
	}

	@Override
	public void exit() {
		System.out.println("SlidePuzzle has ended");
		SlidePuzzleModel.reset();
		View.setInstance(); 
	    View.closeWindow();		
	}

}
