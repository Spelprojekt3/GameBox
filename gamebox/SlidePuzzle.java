package gamebox;

import controller.*;
import model.SlidePuzzleModel;


public class SlidePuzzle implements GameState {
	
GameBox gameBox;
SlidePuzzleModel model; 
int index=2; 
	
public SlidePuzzle(GameBox newGameBox){
	
	System.out.println("SlidePuzzle is online");
	gameBox= newGameBox; 
}

	@Override
	public void run() {
		Controller controller = Controller.getInstance(index);
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

}
