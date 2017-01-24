package main;
import org.junit.Assert;
import org.junit.Test;

import model.TicTacToeModel;
public class TicTacToeModelTest {
	
	
	TicTacToeModel model = TicTacToeModel.getInstance();
	
	
@Test
public void testReset(){
	
	TicTacToeModel.reset();
}

@Test
public void testNewBoard(){
	
	model.newBoard(); 
}

@Test
public void currentBoard(){
	Assert.assertEquals("currentBoard",model.currentBoard());
}


}
