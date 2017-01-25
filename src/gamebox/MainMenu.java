package gamebox;

import controller.MainController;
import view.MainView;


public class MainMenu implements GameState {
	

	
	public MainMenu(){		
		 
		System.out.println("MainMenu is online");
	}

	@Override
	public  void run() {	
		MainController main = MainController.getInstance(); 
		System.out.println("MainMenu is running");
	}
	
	@Override
	public void exit() {
		 System.exit(0);
		// TODO Auto-generated method stub
		
	}

}
