package gamebox;

import controller.MainController;
import view.MainView;
/**
 * State that represents the main menu
 * @author Marcus
 *
 */

public class MainMenu implements GameState {
	

	
	public MainMenu(GameBox gameBox){		
		 
		System.out.println("MainMenu is online");
	}

	@Override
	/**
	 * runs the state "Main Menu"
	 */
	public  void run() {	
		MainController main = MainController.getInstance(); 
		System.out.println("MainMenu is running");
	}
	/**
	 * exits the game 
	 */
	
	@Override
	public void exit() {
		 System.exit(0);
		// TODO Auto-generated method stub
		
	}

}
