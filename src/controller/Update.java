package controller;

import model.SlidePuzzleModel;
import model.TicTacToeModel;
import view.View;

public class Update {

static SlidePuzzleModel modelS; 
static TicTacToeModel modelT;
static View view; 
	
public static void empty(){
	
	TicTacToeModel model =TicTacToeModel.getInstance();
	View view = View.getInstance();
	model.emptyModel(); 
	view.emptyView();
 }



}