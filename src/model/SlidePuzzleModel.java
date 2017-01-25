package model;

import java.util.ArrayList;
import java.util.Collections;

import controller.Controller;
import controller.Update;
import view.View;

public class SlidePuzzleModel implements Game
{
	private ArrayList<String> numberList = new ArrayList<String>();
	private String[][] board = new String[4][4]; 
	View view; 
	private static SlidePuzzleModel firstInstance = null; 

	private SlidePuzzleModel()
	{ 
		createNumberList();
		shuffleNumberList();
		createGameBoard(numberList);
		currentBoard(); 
	}
	
	public static SlidePuzzleModel getInstance(){
		if(firstInstance ==null){
			
			firstInstance = new SlidePuzzleModel(); 
		}
		return firstInstance; 
	}
	


	public static void reset(){
		
		firstInstance=null; 
	}

	public void createNumberList()
	{
		for (int i = 0; i < 16; i++) {
		    String a =Integer.toString(i);
			numberList.add(a);
		}
	}

	public void shuffleNumberList()
	{
		Collections.shuffle(numberList);
	}

	public void createGameBoard(ArrayList<String> list)
	{
		int index = 0;
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				board[i][j] = list.get(index);
				index++;
			}
		}

	}

	public void currentBoard()
	{
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				System.out.print(" " + board[i][j] + " ");
			}
			
			System.out.println("");
		}
		
		System.out.println("");
	}
	
	public int getPositionZero()
	{
		
		for (int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(board[i][j].equals("0")){
					return  (i*10)+j ; 
				}
				
			}
		}
		return 0;	
	}
	
	

	public String[][] getBoard() {
		
		return board;
	}
	
	

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public void swap(int i ,int j, int k, int l){
	
	String z=getValue(i,j);
	String h=getValue(k,l);
	
	board[i][j]=h;
	board[k][l]=z; 
		 
		
	}
	
	public String getValue(int i, int j){
		
		return board[i][j]; 
			
	}
	
	
public void updateView(String number){
		
		int x=getPositionZero()/10;
		int y=getPositionZero()%10; 
		
		view.getGameButtons()[x][y].setText(number);
		updateView(); 
		view.setButtonInvisible(); 
		
	}

public  void updateView(){
		
		for(int i=0; i<board.length;i++)
		{
			
			for(int j=0; j<board.length;j++){
			view.getGameButtons()[i][j].setText(board[i][j]);	
		}
	}
}	
	
	
@Override
public boolean move(int i, int j) {
		
		int x=getPositionZero()/10; 
		int y=getPositionZero()%10; 
		
		if(i==(x-1)&&j==y||i==(x+1)&&j==y||i==(x)&&j==(y+1)||i==(x)&&j==(y-1))
		{
		swap(x, y, i, j);
		currentBoard();
		return true; 
		}
		return false;
	}
	
	
@Override
public String getStatus(int i, int j) 
{
			return board[i][j];
}
	

	
	   
	

@Override
public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}

