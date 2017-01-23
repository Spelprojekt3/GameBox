package controller;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.UIManager;
import gamebox.GameBox;
import gamebox.MainMenu;
import gamebox.SlidePuzzle;
import gamebox.TicTacToe;
import view.MainView;


public class MainController {
	
	GameButtonListener gamebuttonlistener; 
	static MainMenu main; 
	
public MainController(){
	
	MainView main= new MainView(); 
	GameBox box=new GameBox();
	TicTacToe tGame= new TicTacToe(box); 
	SlidePuzzle sGame =new SlidePuzzle(box); 
	
	
GameButtonListener gamebuttonlistener = new GameButtonListener(main,tGame,sGame);
	
	this.gamebuttonlistener = gamebuttonlistener; 
	
	for (int i= 0; i< main.mainButtons.length; i++) {
	
         main.mainButtons[i].addActionListener(gamebuttonlistener);
     }
}

	
	public static void main(String[] arg) {
        try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // start application
        } catch (Exception ex) {
            ex.printStackTrace();
} 
           GameBox box = new GameBox(); 
           main=new MainMenu(box);
           main.run();
	}
	
public class GameButtonListener implements ActionListener {

	    MainView view;
	    TicTacToe game1;
	    SlidePuzzle game2; 
	    MainMenu menu;
	    
	    

public GameButtonListener(MainView view ,TicTacToe game1,SlidePuzzle game2) {
	        
		this.view = view;
		this.game1= game1; 
		this.game2=game2; 
	      
	    }

public void actionPerformed(ActionEvent e) {
	       	
       for (int i= 0; i< view.mainButtons.length; i++) {
	        
	        	
	                if (e.getSource()==view.mainButtons[0]) {
	                	game1.run();
	                    }
	               if (e.getSource()==view.mainButtons[1]) {
		                game2.run();
	                    }
	                	
	                	
	                }
	        	}
	    }
}




