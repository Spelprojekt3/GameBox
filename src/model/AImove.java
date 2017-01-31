package model;

import java.util.Random;
import exception.GameException;
import view.Options;

class AImove {

    TicTacToeModel model;
    private int column;
    private Random rand;
    Options option = new Options();
    int k;


    int[] aiBoard = new int[Options.getSize() * Options.getSize()];
    int counter;

    AImove() {

        analyseBoard();
        makeMove(createRandom(k));
    }


    private int createRandom(int k) {

        Random rand = new Random();
        int random = rand.nextInt(k);
        return aiBoard[random];
    }


    private int analyseBoard() {

        try {
            model = TicTacToeModel.getInstance();
        } catch (GameException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        k = 0;

        for (int i = 0; i < model.getBoard().length; i++) {

            for (int j = 0; j < model.getBoard().length; j++) {

                if (model.getBoard()[i][j].equals(" ") || model.getBoard()[i][j].equals(" ")) {
                    aiBoard[k] = ((i * 10) + j);
                    k = k + 1;
                }

            }

        }
        System.out.println(k);
        return k;
    }


    private void makeMove(int nummer) {
        int x = nummer / 10;
        int y = nummer % 10;

        model.getBoard()[x][y] = "O";
    }

}
