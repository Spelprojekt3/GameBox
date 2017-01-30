package controller;


import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import exception.GameException;
import gamebox.GameBox;
import gamebox.GameState;
import gamebox.MainMenu;
import gamebox.SlidePuzzle;
import gamebox.TicTacToe;
import model.SlidePuzzleModel;
import model.TicTacToeModel;
import view.MainView;
import view.View;


public class MainController {
	
	GameButtonListener gamebuttonlistener; 
	MainMenu main; 
	private static MainController firstInstance=null;
	static GameBox box;
    private MainView mainview;
    
private MainController(){
	
    mainview= new MainView(); 
	GameBox box = new GameBox(); 
	TicTacToe tGame= new TicTacToe(); 
	SlidePuzzle sGame =new SlidePuzzle(); 
  
	
	
GameButtonListener gamebuttonlistener = new GameButtonListener(mainview,tGame,sGame);
	
	this.gamebuttonlistener = gamebuttonlistener; 
	
	for (int i= 0; i< mainview.mainButtons.length; i++) {
	
         mainview.mainButtons[i].addActionListener(gamebuttonlistener);
     }
}

public static MainController getInstance(){
	
	if(firstInstance == null){
		
		firstInstance = new MainController(); 
	}
	return firstInstance; 
}

public static void main(String[] arg) throws GameException{
        try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // start application
        } catch (Exception ex) {
            ex.printStackTrace();
} 
          
       
        MainMenu state= new MainMenu();
        state.run(); 
        
        
	}
	
public class GameButtonListener implements ActionListener {

	    MainView view;
	    GameState state1,state2; 
	    

public GameButtonListener(MainView view ,GameState state1,GameState state2){
	        
		this.view  = view;
		this.state1=state1; 
		this.state2=state2; 
		
	      
	    }

public void actionPerformed(ActionEvent e) {
	       	
       for (int i= 0; i< view.mainButtons.length; i++) {
	        
	        	
	                if(e.getSource()==view.mainButtons[0]) {
	                	try {
							state1.run();
						} catch (GameException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	               
	                    }
	               if (e.getSource()==view.mainButtons[1]) {
		                try {
							state2.run();
						} catch (GameException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                    }
	                	
	                	
	                }
	        	}
	    }
}




