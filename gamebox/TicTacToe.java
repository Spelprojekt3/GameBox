package gamebox;
import controller.*;

import model.TicTacToeModel;

public class TicTacToe implements GameState{

GameBox gameBox; 
TicTacToeModel model; 
MainMenu menu;
	
public TicTacToe(GameBox newgameBox){
	
	gameBox=newgameBox; 
    System.out.println("TicTacToe is online");
}

	@Override
	public void run() {
	System.out.println("TicTacToe is running");
	Controller controller =Controller.getInstance(model);
	
	}

	@Override
	public void exit(){
		
	}

}
