package gamebox;

import controller.*;
import model.SlidePuzzleModel;


public class SlidePuzzle implements GameState {
	
GameBox gameBox;
SlidePuzzleModel model; 
	
public SlidePuzzle(GameBox newGameBox){
	
	System.out.println("SlidePuzzle is online");
	gameBox= newGameBox; 
}

	@Override
	public void run() {
		Controller controller = Controller.getInstance(model);
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

}
