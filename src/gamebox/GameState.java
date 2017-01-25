package gamebox;

import exception.GameException;

public interface GameState {
	
	void run() throws GameException; 
	void exit(); 

}
