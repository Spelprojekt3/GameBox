package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

import model.Game;
import model.SlidePuzzleModel;
import model.TicTacToeModel;
import view.View;


public class Controller
{
	GameButtonListener gamebuttonlistner; 
    SlidePuzzleModel sModel;  
	TicTacToeModel tModel; 
	View view; 
	
	 

public Controller(SlidePuzzleModel model){
	
	View view= View.getInstance();
	model = new SlidePuzzleModel(view); 
	this.view=view; 
    this.sModel=model; 
	 
		model.updateView();
		view.setButtonInvisible();
		
		GameButtonListener gamebuttonlistener = new GameButtonListener(view,model);
		this.gamebuttonlistner = gamebuttonlistener; 
		
		for (int j = 0; j< view.getGameButtons().length; j++) {
			
		
		 for (int i = 0; i < view.getGameButtons().length; i++) {
	         view.getGameButtons()[i][j].addActionListener(gamebuttonlistner);
	     }
	}
		
}

public Controller(TicTacToeModel model){
	
	View view= View.getInstance();
	model = new TicTacToeModel(view); 
	this.view=view; 
    this.tModel=model; 
	 
		model.updateView();
		view.setButtonInvisible();
		
		GameButtonListener gamebuttonlistener = new GameButtonListener(view,model);
		this.gamebuttonlistner = gamebuttonlistener; 
		
		for (int j = 0; j< view.getGameButtons().length; j++) {
			
		
		 for (int i = 0; i < view.getGameButtons().length; i++) {
	         view.getGameButtons()[i][j].addActionListener(gamebuttonlistner);
	     }
	}
		
}

public static void main(String[] args)
{
try {
    // select Look and Feel
    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
    // start application
} catch (Exception ex) {
    ex.printStackTrace();
}
       
}


public static class GameButtonListener implements ActionListener {

	    View view;
	    SlidePuzzleModel model1;
	    TicTacToeModel model2; 
	    int index; 
	
public GameButtonListener(View view , SlidePuzzleModel model) {
	
	this.model1=model; 
	this.view=view; 
	index=1; 
}	
public GameButtonListener(View view , TicTacToeModel model) {
	
	this.model2=model; 
	this.view=view; 
	index=2; 
}	
public void actionPerformed(ActionEvent e) {
	   	
	    	
	  for (int j = 0; j< view.getGameButtons().length; j++) {
	        	
	         for(int i=0; i< view.getGameButtons().length;i++){
	        		
	        	 if (index==1 && e.getSource() == view.getGameButtons()[i][j]){
	        	
	                 model1.move(i,j); 
	        		 model1.getMessage();
	        		 model1.updateView(model1.getStatus(i,j)); 
	        		 }
	        	 if (index==2 && e.getSource() == view.getGameButtons()[i][j]){
	        	
	                 model2.move(i,j); 
	        		 model2.getMessage();
	        		 model2.updateView(model2.getStatus(i,j)); 
	        		 }
	        		 
	        	 }
	 	  	
	           }
	        }
        }
}; 