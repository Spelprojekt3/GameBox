package model;

import java.util.Random;

import exception.GameException;
import view.Options;
/**
 * Class that sets a move on the board of TicTacToeModel
 * @author Marcus,Christoffer
 * 
 */
public class AImove{

TicTacToeModel model; 
private int column;
private int random;
private Random rand; 
Options option = new Options();
int k; 


int[]aiBoard = new int [Options.getSize()*Options.getSize()];
int counter; 
	
public AImove(){
	
	analyseBoard(); 
	makeMove(createRandom(k)); 
}

/**
 * Creates random number
 * @param k is the number of available positions in the board 
 * @return the random number 
 */
private int createRandom(int k){
	
	Random rand= new Random(); 
	random=rand.nextInt(k)+0;
	int nummer =aiBoard[random]; 
	return nummer; 
	
}
/**
 *Finds available spots and stores its coordinates  
 * @return the number of the available spots 
 */

private int analyseBoard(){
	
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

/**
 * sets the letter O on a spot on the board 
 * @param nummer
 */

private void makeMove(int nummer)
{
	int x=nummer/10;
	int y=nummer%10; 
	
model.getBoard()[x][y]="O";
}



};
