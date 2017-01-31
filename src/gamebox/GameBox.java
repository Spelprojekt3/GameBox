package gamebox;

import controller.Controller;
import exception.GameException;
import model.SlidePuzzleModel;
import model.TicTacToeModel;

public class GameBox {
	
	GameState mainMenu; 
	GameState ticTacToe; 
	GameState slidePuzzle;
	GameState state; 

	
	
public GameBox(){
	
	      mainMenu= new MainMenu(this); 
	      ticTacToe = new TicTacToe(this); 
	      slidePuzzle = new SlidePuzzle(this);
	      state = mainMenu; 
}
	
	
public void setGameState(GameState newGameState) throws NullPointerException
{
		state=newGameState; 	
}
	
public void run() throws GameException{
	
	state.run(); 
}
public void exit(){
	
	state.exit(); 
}
}

