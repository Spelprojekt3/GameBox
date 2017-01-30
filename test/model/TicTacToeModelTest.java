package model;

import exception.GameException;
import gamebox.TicTacToe;
import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by CRL on 2017-01-25.
 */
class TicTacToeModelTest {

    @Test
    void getScore() throws GameException {
        TicTacToeModel testModel = TicTacToeModel.getInstance();
        ArrayList<Integer> testArray = new ArrayList<>();

        Assertions.assertEquals(testArray,testModel.getScore());
        testModel.reset();
    }

    @Test
    void getInstance() throws GameException {
        TicTacToeModel testModel = TicTacToeModel.getInstance();
        Assertions.assertEquals(testModel, TicTacToeModel.getInstance());
        testModel.reset();
    }

    @Test
    void reset() throws GameException {
        //FRÅGA MARTIN
        /*
        TicTacToeModel testModel = TicTacToeModel.getInstance();
        TicTacToeModel.reset();

        Assertions.assertNull(testModel);
        */

        TicTacToeModel testModel = TicTacToeModel.getInstance();
        Assertions.assertNotEquals(null, testModel.getFirstInstance());
        testModel.reset();
        Assertions.assertNull(testModel.getFirstInstance());
    }

    @Test
    void emptyModel() throws GameException {
        TicTacToeModel testModel = TicTacToeModel.getInstance();

        testModel.move(2,2);
        testModel.emptyModel();
        //testModel.reset();
        String[][] testBoard = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                testBoard[i][j] = " ";
            }

        }
        Assertions.assertEquals(Arrays.deepToString(testBoard), Arrays.deepToString(testModel.getBoard()));
        testModel.reset();
    }

    @Test
    void getPlayer() throws GameException {
        TicTacToeModel testModel = TicTacToeModel.getInstance();
        testModel.reset();
        Assertions.assertEquals("X", testModel.getPlayer());
    }

    @Test
    void getBoard() throws GameException {
        TicTacToeModel testModel = TicTacToeModel.getInstance();
        String[][] testBoard = new String[4][4];
        testModel.emptyModel();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                testBoard[i][j] = " ";
            }
        }
        Assertions.assertEquals(Arrays.deepToString(testBoard), Arrays.deepToString(testModel.getBoard()));
        testModel.reset();
    }

    @Test
    void move() throws GameException {
        TicTacToeModel testModel = TicTacToeModel.getInstance();
        String[][] testBoard = new String[4][4];
        testModel.emptyModel();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                testBoard[i][j] = " ";
            }
        }
        Assertions.assertEquals(Arrays.deepToString(testBoard), Arrays.deepToString(testModel.getBoard()));

        testModel.move(1,2);
        String[][] board2={{" "," "," "," "},
                {" "," ","X"," "},
                {" "," "," "," "},
                {" "," "," "," "}};
        Assertions.assertEquals(Arrays.deepToString(board2), Arrays.deepToString(testModel.getBoard()));
        testModel.reset();
    }

    @Test
    void getStatus() throws GameException {
        TicTacToeModel testModel2 = TicTacToeModel.getInstance();
        testModel2.move(1,1);
        Assertions.assertEquals("X", testModel2.getStatus(1,1));
    }

    @Test
    void getMessage() {
    //Not used
    }

}