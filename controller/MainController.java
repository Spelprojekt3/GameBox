package controller;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import gamebox.GameBox;
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
	
private MainController(){
	
	MainView mainview= new MainView(); 
	GameBox box=new GameBox();
	MainMenu main=new MainMenu(box);
	TicTacToe tGame= new TicTacToe(box); 
	SlidePuzzle sGame =new SlidePuzzle(box); 
  
	
	
	
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

	public static void main(String[] arg) {
        try {
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            // start application
        } catch (Exception ex) {
            ex.printStackTrace();
} 
          
           MainController controller =MainController.getInstance(); 
	}
	
public class GameButtonListener implements ActionListener {

	    MainView view;
	    TicTacToe game1;
	    SlidePuzzle game2; 
	    MainMenu menu;
	    SlidePuzzleModel gameS;
	    TicTacToeModel gameT; 
	    

public GameButtonListener(MainView view ,TicTacToe game1,SlidePuzzle game2) {
	        
		this.view = view;
		this.game1= game1; 
		this.game2=game2; 
		
	      
	    }

public void actionPerformed(ActionEvent e) {
	       	
       for (int i= 0; i< view.mainButtons.length; i++) {
	        
	        	
	                if(e.getSource()==view.mainButtons[0]) {
	                	game1.run();
	               
	                    }
	               if (e.getSource()==view.mainButtons[1]) {
		                game2.run();
		                
	                    }
	                	
	                	
	                }
	        	}
	    }
}




