package gamebox;

import controller.Controller;
import exception.GameException;
import model.SlidePuzzleModel;
import model.TicTacToeModel;
/**
 * Concrete class that sets the state of the program 
 * 
 * @author Marcus, Christoffer
 *
 */
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
	
/**
 * Sets the state	
 * @param newGameState current state 
 * @throws NullPointerException if no state is selected
 */
public void setGameState(GameState newGameState) throws NullPointerException
{
		state=newGameState; 	
}
/**
 * Runs the gamebox 
 * @throws GameException
 */
public void run() throws GameException{
	
	state.run(); 
}
/**
 * Exits the gamebox 
 */
public void exit(){
	
	state.exit(); 
}
}

