package gamebox;

import controller.Controller;
import model.SlidePuzzleModel;
import model.TicTacToeModel;

public class GameBox {
	
	GameState mainMenu; 
	GameState ticTacToe; 
	GameState slidePuzzle;
	GameState gameState; 

	
	
public GameBox(){
			
	  }
	
	
	public void setGameState(GameState newGameState) throws NullPointerException
	{
		gameState=newGameState; 	
	}
	
	
};

