package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import controller.Controller;
import view.View;

public class SlidePuzzleModel implements Game {
    private ArrayList<String> numberList = new ArrayList<String>();
    private String[][] board = new String[4][4];
    private String[][] sortedBoard = new String[4][4];
    private static SlidePuzzleModel firstInstance = null;

    private SlidePuzzleModel() {
        createNumberList();
        shuffleNumberList();
        createGameBoard(numberList);
        currentBoard();
        createSortedBoard();
    }

    /**
     * Creates an instance of SlidePuzzleModel
     *
     * @return Instance of SlidePuzzleModel
     */
    public static SlidePuzzleModel getInstance() {
        if (firstInstance == null) {

            firstInstance = new SlidePuzzleModel();
        }
        return firstInstance;
    }

    SlidePuzzleModel getFirstInstance() {
        return firstInstance;
    }

    /**
     * Resets the SlidePuzzleModel instance
     */
    public static void reset() {

        firstInstance = null;
    }

    private void createNumberList() {
        for (int i = 0; i < 16; i++) {
            String a = Integer.toString(i);
            numberList.add(a);
        }
    }

    private void shuffleNumberList() {
        Collections.shuffle(numberList);
    }

    private void createGameBoard(ArrayList<String> list) {
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = list.get(index);
                index++;
            }
        }

    }

    private void createSortedBoard() {
        int k = 1;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                sortedBoard[i][j] = Integer.toString(k);
                k++;
            }
        sortedBoard[3][3] = Integer.toString(0);
    }

    private boolean isPuzzleSolved() {
        return (Arrays.deepEquals(board, sortedBoard));
    }

    private boolean doWinnerCheck() {
        return (board[0][0].equals(sortedBoard[0][0]) && board[3][2].equals(sortedBoard[3][2]) &&
                board[3][3].equals(sortedBoard[3][3]));
    }

    private void currentBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + board[i][j] + " ");
            }

            System.out.println("");
        }

        System.out.println("");
    }

    private int getPositionZero() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals("0")) {
                    return (i * 10) + j;
                }

            }
        }
        return 0;
    }

    private void swap(int i, int j, int k, int l) {

        String z = getValue(i, j);
        String h = getValue(k, l);

        board[i][j] = h;
        board[k][l] = z;


    }

    private String getValue(int i, int j) {

        return board[i][j];

    }

    /**
     * Checks if the Slide puzzle game has been solved
     *
     * @return String "WS" if the puzzle is solved
     */
    public String getWinner() {

        if (isPuzzleSolved() == true) {
            return "WS";
        } else
            return " ";
    }

    /**
     * Checks if the button pressed is valid to move. Swaps the button if valid
     * @param i Coordinate on the x-axis
     * @param j Coordinate on the y-axis
     * @return The current board after the move has been done
     */
    @Override
    public boolean move(int i, int j) {

        int x = getPositionZero() / 10;
        int y = getPositionZero() % 10;

        if (i == (x - 1) && j == y || i == (x + 1) && j == y || i == (x) && j == (y + 1) || i == (x) && j == (y - 1)) {
            swap(x, y, i, j);
            currentBoard();
            if (doWinnerCheck() == true) {
                isPuzzleSolved(); //Show popup, show elapsed time(?).
            }

            return true;
        }
        return false;
    }

    /**
     * Returns the number of the button on the chosen coordinate
     * @param i Coordinate on the x-axis
     * @param j Coordinate on the y-axis
     * @return int
     */
    @Override
    public String getStatus(int i, int j) {
        return board[i][j];
    }

    /**
     * Returns if the puzzle has been solved or not
     *
     * @return String "WS" if the puzzle has been solved
     */
    @Override
    public String getMessage() {

        return getWinner();

    }
}

