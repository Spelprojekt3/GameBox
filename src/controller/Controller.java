package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


import exception.GameException;
import gamebox.GameBox;
import gamebox.GameState;
import gamebox.SlidePuzzle;
import gamebox.TicTacToe;
import model.Enum.Player.Board;
import model.Game;
import model.SlidePuzzleModel;
import model.TicTacToeModel;
import view.Options;
import view.View;


public class Controller
{
	GameButtonListener gamebuttonlistner; 
	TicTacToeModel model; 
	View view; 	 
	Game game; 
	GameState state;
	GameBox box; 
	Options option; 
	private static Controller firstInstance = null; 

	

public static Controller getInstance(int i) throws GameException{

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



public static void endGameIfWin(Game game, View view) throws GameException{
	
 String winner="W"; 
	if(game.getMessage()==winner){
		view.disableButtons(); 
	}
	
}

private Controller(int gameNumber)throws GameException{

	

	box =new GameBox();
	option =new Options(); 
	
	if(gameNumber==1){

	option.askBoardSize();

	View view= new View(Options.getSize());
	game = TicTacToeModel.getInstance();
	state=new TicTacToe();
	Options.askForOpponent(); 
	box.setGameState(state);
	
	this.view=view; 
    this.game=game; 

	}
	if(gameNumber==2){
	View view= new View(Board.SIZE);
	game = SlidePuzzleModel.getInstance();
	state=new SlidePuzzle(); 
	box.setGameState(state);
	updateView(view);
	view.setButtonInvisible();
	
	this.view=view; 
    this.game=game; 

	}	

	 		
			
		  GameButtonListener gamebuttonlistener = new GameButtonListener(view,game);
		  this.gamebuttonlistner = gamebuttonlistener; 
		
		 for (int i = 0; i< view.getGameButtons().length; i++) {
			
		
		 for (int j= 0; j< view.getGameButtons().length; j++) {
	         view.getGameButtons()[i][j].addActionListener(gamebuttonlistner);
	        }
	      }
		
		   view.getExitButton().addActionListener(e -> {
            int confirmExit = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to exit?", null, JOptionPane.YES_NO_OPTION);
            if (confirmExit == JOptionPane.YES_OPTION) {
                firstInstance=null; 
                state.exit();   
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
	                 
	        		 try {
						Controller.endGameIfWin(game, view);
					} catch (GameException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		 
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

}


