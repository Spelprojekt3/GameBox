package gamebox;

import controller.*;
import model.SlidePuzzleModel;


public class SlidePuzzle implements GameState {
	
GameBox gameBox;
SlidePuzzleModel model; 
	
public SlidePuzzle(GameBox newGameBox){
	
	gameBox= newGameBox; 
}

	@Override
	public void run() {
		Controller controller = new Controller(model);
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

}
