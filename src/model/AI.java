package model;

import java.util.Random;

import exception.GameException;

public class AI{

TicTacToeModel model; 
private int column;
private int random;
private Random rand; 
int k; 


int[]aiBoard = new int [16];
int counter; 
	
public AI(){
	
	analyseBoard(); 
	makeMove(createRandom(k)); 
}


public int createRandom(int k){
	
	Random rand= new Random(); 
	random=rand.nextInt(k)+0;
	int nummer =aiBoard[random]; 
	return nummer; 
	
}
 

public int analyseBoard(){
	
	try {
		model= TicTacToeModel.getInstance();
	} catch (GameException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	k=0; 
	
	for(int i=0;i<model.getBoard().length;i++){
		
		for(int j=0; j<model.getBoard().length;j++){
			
	         if(model.getBoard()[i][j].equals(" ")||model.getBoard()[i][j].equals(" ")){
	         aiBoard[k]=((i*10)+j);
		     k=k+1;
	         }
	        
		 }
	 
    }
	System.out.println(k);
	return k; 
}



public void makeMove(int nummer)
{
	int x=nummer/10;
	int y=nummer%10; 
	
model.getBoard()[x][y]="O";
}



};


