package gamebox;
import controller.*;

import model.TicTacToeModel;

public class TicTacToe implements GameState{

GameBox gameBox; 
TicTacToeModel model; 
	
public TicTacToe(GameBox newgameBox ){
	
	gameBox=newgameBox; 
    System.out.println("TicTacToe is online");
}

	@Override
	public void run() {
	Controller controller = new Controller(model); 
	}

	@Override
	public void exit(){
		
	}

}
