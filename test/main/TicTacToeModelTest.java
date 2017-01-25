package main;
import org.junit.Assert;
import org.junit.Test;

import exception.GameException;
import model.TicTacToeModel;
public class TicTacToeModelTest{

TicTacToeModel model;

public TicTacToeModelTest(){
	
}	

@Test
public void TestcurrentBoard(){
	
	
		try {
			model = TicTacToeModel.getInstance();
		} catch (GameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	Assert.assertEquals("currentBoard",model.currentBoard());
}

@Test
public void TestcheckWin() throws GameException{
	
model = TicTacToeModel.getInstance();

String[][] board={{"X","","",""},
		          {"","X","",""},
                  {"","","X",""}, 
                  {"","","","X"}}; 
		
Assert.assertEquals('X', model.checkwin(board));

String[][] board2={{"O","","",""},
                   {"O","X","",""},
                   {"O","","X",""}, 
                   {"O","","","X"}}; 

Assert.assertEquals('O', model.checkwin(board2));

String[][]board3={{"O","X","X","X"},
                  {"O","X","X","O"},
                  {"O","O","X","O"}, 
                  {"O","O","X","X"}}; 

Assert.assertEquals('D', model.checkwin(board3));


}

}
