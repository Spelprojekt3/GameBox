package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.Game;
import model.SlidePuzzleModel;
import model.TicTacToeModel;
import view.View;


public class Controller
{
	GameButtonListener gamebuttonlistner; 
    SlidePuzzleModel model;  
	View view; 	 
	Game game; 
	private static Controller firstInstance = null; 

	
public static Controller getInstance(int i){
	

	if(firstInstance ==null){
		
		firstInstance = new Controller(i); 
	}
	return firstInstance; 
}

public void updateView(View view){

	 for(int i=0; i< view.getGameButtons().length;i++)
	 {  
		for(int j=0; j<view.getGameButtons().length;j++){
	     view.getGameButtons()[i][j].setText(game.getStatus(i,j));
		 }
	  }
			
}

private Controller(int gameNumber){
	
	
	View view= View.getInstance();
	
	if(gameNumber==1){
	game = TicTacToeModel.getInstance(); 
	}
	if(gameNumber==2){
	game = SlidePuzzleModel.getInstance();
	updateView(view);
	view.setButtonInvisible();
	}	
	this.view=view; 
    this.game=game; 
	 		
			
		  GameButtonListener gamebuttonlistener = new GameButtonListener(view,game);
		  this.gamebuttonlistner = gamebuttonlistener; 
		
		 for (int j = 0; j< view.getGameButtons().length; j++) {
			
		
		 for (int i = 0; i < view.getGameButtons().length; i++) {
	         view.getGameButtons()[i][j].addActionListener(gamebuttonlistner);
	        }
	      }
		
		   view.getExitButton().addActionListener(e -> {
            int confirmExit = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit?", null, JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                firstInstance=null; 
                TicTacToeModel.reset();
                SlidePuzzleModel.reset(); 
                View.setInstance(); 
                View.closeWindow();
                
            }
        });
		
}


public static class GameButtonListener implements ActionListener {

	    View view;
	    Game game; 
	
public GameButtonListener(View view ,Game game) {
	
	this.game=game; 
	this.view=view; 
	
}
public void actionPerformed(ActionEvent e) {
	   	
	    	
	  for (int i = 0; i< view.getGameButtons().length; i++) {
	        	
	         for(int j=0; j< view.getGameButtons().length;j++){
	        		
	        	 if (e.getSource() == view.getGameButtons()[i][j]){
	                 game.move(i,j);
	        		 game.getMessage();
	        		 
	        	 for(int k=0; k< view.getGameButtons().length;k++)
	        	 {  
	        		for(int l=0; l<view.getGameButtons().length;l++){
	        	     view.getGameButtons()[k][l].setText(game.getStatus(k,l));
	        		 }
	        	  }
	        	}
	 	  	
	          }
	        }
	view.setButtonInvisible();
}
}
}; 