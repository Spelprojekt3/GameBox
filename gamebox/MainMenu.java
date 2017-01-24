package gamebox;

import controller.MainController;
import view.MainView;


public class MainMenu implements GameState {
	
	GameBox gameBox; 
	
	public MainMenu(GameBox newgameBox){		
		
		gameBox=newgameBox; 
		System.out.println("MainMenu is online");
	}

	@Override
	public  void run() {	
		MainController main = MainController.getInstance(); 
	}
	
	@Override
	public void exit() {
		 System.exit(0);
		// TODO Auto-generated method stub
		
	}

}