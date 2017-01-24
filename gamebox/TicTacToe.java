package gamebox;
import controller.*;

import model.TicTacToeModel;

public class TicTacToe implements GameState{

GameBox gameBox; 
TicTacToeModel model; 
MainMenu menu;
int index=1; 

	
public TicTacToe(GameBox newgameBox){
	
	gameBox=newgameBox; 
    System.out.println("TicTacToe is online");
}

	@Override
	public void run() {
	System.out.println("TicTacToe is running");
	Controller controller =Controller.getInstance(index);
	
	}

	@Override
	public void exit(){
		
	}

}
