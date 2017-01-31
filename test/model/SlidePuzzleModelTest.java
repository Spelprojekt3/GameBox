package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by CRL on 2017-01-30.
 */
class SlidePuzzleModelTest {

    @Test
    void getInstance() {
        SlidePuzzleModel puzzleTest = SlidePuzzleModel.getInstance();
        Assertions.assertNotNull(puzzleTest.getInstance());
    }

    @Test
    void reset() {

        SlidePuzzleModel testModel = SlidePuzzleModel.getInstance();
        Assertions.assertNotNull(testModel);
        testModel.reset();
        Assertions.assertNull(testModel.getFirstInstance());

    }

    @Test
    void move() {
    SlidePuzzleModel testModel = SlidePuzzleModel.getInstance();
    testModel.move(1,2);
    }

    @Test
    void getStatus() {
        SlidePuzzleModel testModel = SlidePuzzleModel.getInstance();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Assertions.assertNotNull(testModel.getStatus(i,j));
            }

        }

    }

    @Test
    void getMessage() {
    SlidePuzzleModel testModel = SlidePuzzleModel.getInstance();
    Assertions.assertEquals(" ", testModel.getWinner());
    }

}