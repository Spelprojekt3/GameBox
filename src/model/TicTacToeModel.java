package model;

import java.util.ArrayList;


import controller.Update;
import exception.GameException;
import model.Enum.Player;
import view.Options;
import view.View;


public class TicTacToeModel implements Game{
	
	private static int click=0;
	private String player1,player2;
	private int size;  
	private String player;
	private static int score1,score2,dscore1,dscore2,lscore1,lscore2; 
	private ArrayList<Integer>score=new ArrayList<Integer>(); 
	private ArrayList<Integer>dscore=new ArrayList<Integer>();
	private View view; 
	private  static TicTacToeModel firstInstance=null; 
	private Options option = new Options(); 
	private String[][] board = new String [option.getSize()][option.getSize()];
	private String winner; 
	
public ArrayList<Integer> getScore() {
		return score;
	}

private TicTacToeModel() throws GameException{
	
	newBoard(); 
	currentBoard();  
		
}

public static TicTacToeModel getInstance()throws GameException{
	
	if(firstInstance ==null){
		
		firstInstance = new TicTacToeModel(); 
	}
	return firstInstance; 
}

public static void reset(){
	
	firstInstance=null; 
}

private void newBoard()throws GameException{
	
	int x= option.getSize();
	
	if(x>10){
		throw new GameException("Storleken är större än 10"); 
	}
  
	for(int s=0; s<x; s++){
		
	 for(int f=0; f<x; f++){
	   board[s][f]=" ";
	}
	player="X";
	}
};


public String currentBoard(){
	
	 int x=option.getSize(); 
	 
	 System.out.print("\n");
	 printCol(); 	
	 
    for(int i=0; i<x; i++){
   	  
   	 for(int j=0; j<x; j++){
			if(j!=x-1){
			  System.out.print(" "+board[i][j]+" |");
			} else{
			  System.out.print(" "+board[i][j]);
			}
			}
   	      System.out.println("   "+i);
   	 
   	    if(i<(x-1)){
   	      System.out.print("---");
   	    } if(i<(x-1)){	
	      for(int z=1; z<x; z++)
	          System.out.print("+---"); 
	          System.out.println("");
           }
   	 }
     System.out.print("\n");
     return "currentBoard"; 
};

private void printCol(){
	
	for(int r=0;r<3;r++){
		System.out.print(" "+r+"  ");
		}System.out.println("\n");
};

final int maxx=Options.getSize();
final int maxy=Options.getSize();

public String checkwin(String board[][]){

	char winner = 0; 
	    int[][] directions = {{1,0}, {1,-1}, {1,1}, {0,1}};
	    for (int[] d : directions) {

	    	int dx = d[0];
	        int dy = d[1];
	        for (int x = 0; x < maxx; x++) {
	            for (int y = 0; y < maxy; y++) {
	                int lastx = x + 2*dx;
	                int lasty = y + 2*dy;
	                if (0 <= lastx && lastx < maxx && 0 <= lasty && lasty < maxy) {
	                    String w = board[x][y];
	                    if (w != " " && w == board[x+dx][y+dy] 
	                                 && w == board[x+2*dx][y+2*dy] 
	                                 && w == board[lastx][lasty]) {
	                    	System.out.println("Winner");
	                        return w;
	                    }
	                }
	            }
	        }
	    }
	    return " "; 
	}
	
public boolean addCoordinatate(int x,int y )
{
if(board[x][y]!=" ")
{
	System.out.println("Error, position is already taken");
	return false;
}
else if(board[x][y]==" ")
board[x][y]=player;
return true; 

}

public String winnerIs(){ 

	if (checkwin(board)=="X")
	{
		System.out.println("X"+" wins!"+"\n");
		scoreBoard("X"); 
		winner="X"; 
		
	} 
	if (checkwin(board)=="O")
	{	
		System.out.println("O"+" wins!"+"\n"); 
		scoreBoard("O");
		winner="O";
		
	} 

	  if (checkwin(board)=="D")
	{
	    System.out.println("It's a tie!"+"\n");
	    scoreBoard("T"); 
	    winner="D";
	}
	return winner; 
}

public void scoreBoard(String name){
	 
	ArrayList<String>userName=new ArrayList<String>(); 
	score=new ArrayList<Integer>(); 
	setDscore(new ArrayList<Integer>()); 
	ArrayList<Integer>lscore=new ArrayList<Integer>(); 
	
    //Check winner and give points if win
	if(name.equals("X")){
		score1=score1+1; 
	    lscore2=lscore2+1;
	    } else if(name.equals("O")) {
	    score2=score2+1;
	    lscore1=lscore1+1;
	    } else {
	    dscore2=dscore2+1;
	    dscore1=dscore1+1; 
	    }
	
	//Add players and scores to separate array-lists 
	userName.add("X");
	score.add(score1);
	getDscore().add(dscore1);
	lscore.add(lscore1);
	userName.add("O");
	score.add(score2); 
	getDscore().add(dscore2);
	lscore.add(lscore2);
	
	//Put the "Scoreboard" to the console
	System.out.println("Player     W          D          L");
	System.out.println("+--------------------------------+");
	
	for (int index = 0; index<2; index++){
	   System.out.printf("%-11s",userName.get(index));
       System.out.printf("%-11s",score.get(index));
       System.out.printf("%-11s",getDscore().get(index));
       System.out.printf("%-11s",lscore.get(index));
       System.out.println(""); 
       }
       System.out.println("");
		
		
};

public void emptyModel() throws GameException{

	newBoard(); 
	currentBoard(); 
}

public String getPlayer() {

	return player;
}

public String nextPlayer(){
	
	if (player=="X"){
	       return player="O";
	       } else{
		   return player="X";
		   }
};


public void opponentMove(){
		
	
	if (Options.getOpponent().equals(Player.AI)){
		AImove ai =new AImove(); 
	}
	if (Options.getOpponent().equals(Player.HUMAN)){
		nextPlayer(); 
	}
	
}

public void setPlayer(String player) {
	this.player = player;
}

public String[][] getBoard() {
	return board;
}

public void setBoard(String[][] board) {
	this.board = board;
}


public ArrayList<Integer> getDscore() {
	return dscore;
}



public void setDscore(ArrayList<Integer> dscore) {
	this.dscore = dscore;
}



@Override
public boolean move(int i, int j) {
	

	if(addCoordinatate(i,j)==true && checkwin(board)!="X"){
	currentBoard();
	opponentMove(); 
	currentBoard();
	}
	else	
    currentBoard();
	return true;
	
}


@Override
public String getStatus(int i, int j) {
	
	return board[i][j];
}


@Override
public String getMessage() {


	if(checkwin(board)=="X"||checkwin(board)=="D"||checkwin(board)=="O"){
		winnerIs(); 
		winner="W"; 
	}
	else 
		winner="NW"; 
  
return winner; 
}

};