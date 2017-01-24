package controller;

import model.SlidePuzzleModel;
import view.View;

public class Update {

static SlidePuzzleModel model; 
static View view; 
	
public static void updateView(){
	
	    View view =View.getInstance(); 
	    SlidePuzzleModel model = SlidePuzzleModel.getInstance(); 

		for(int i=0; i<model.getBoard().length;i++)
		{
			
			for(int j=0; j<model.getBoard().length;j++){
			view.getGameButtons()[i][j].setText(model.getBoard()[i][j]);
				
		}

    }
}	

}
