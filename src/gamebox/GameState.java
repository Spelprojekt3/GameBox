package gamebox;

import exception.GameException;
/**
 * Interface of the states
 * @author Marcus, Christoffer
 *
 */

public interface GameState {
	
	void run() throws GameException;
	void exit(); 

}
