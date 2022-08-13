package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import control.GameController;
import model.GameModel;

class GameModelTest {

    GameModel gm;
    GameController gc;

    @BeforeEach
    void setUp() {
        gm = new GameModel(gc);
        gm.startGame();
    }

    // From gmTest1_1 to gmTest1_3 its being tested if the function 'getBoardMark' returns the correct mark that the cell contains.
    @Test
    void gmTest1_1() {
        gm.gameBoard[0][0]="X";
        assertEquals("X", gm.getBoardMark(0, 0));
    }

    @Test
    void gmTest1_2() {
        gm.gameBoard[2][2]="O";
        assertEquals("O", gm.getBoardMark(2, 2));
    }

    @Test
    void gmTest1_3() {
        gm.gameBoard[2][1]=null;
        assertEquals(null, gm.getBoardMark(2, 1));
    }
//While the tests run with no errors the function 'getBoardMark' returns the correct mark that the cell asked contains.

    //------------------------------------------------------------------------------------------------------------------------------------
    //From gmTest2_1 to gmTest2_3 its being tested if the function 'checkDimValidity' throws Index Out Of Bounds Exception for values different than 0, 1 or 2.
    @Test
    void gmTest2_1() {
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    gm.checkDimValidity(1,3);
                });
    }

    @Test
    void gmTest2_2() {
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    gm.checkDimValidity(-1,2);
                });
    }

    @Test
    void gmTest2_3() {
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    gm.checkDimValidity(-231,12);
                });
    }

//And as the tests run well we can see that the function works as expected.
//----------------------------------------------------------------------------------------------------------


    //From gmTest3_1 to gmTest3_3 its being tested if the function 'checkMoveValidity' throws Illegal Argument Exception for cells that contain values.
    @Test
    void gmTest3_1() {
        gm.gameBoard[2][1]="X";
        assertThrows(IllegalArgumentException.class,
                ()->{
                    gm.checkMoveValidity(2,1);
                });
    }

    @Test
    void gmTest3_2() {
        gm.gameBoard[0][2]="O";
        assertThrows(IllegalArgumentException.class,
                ()->{
                    gm.checkMoveValidity(0,2);
                });
    }
    //And as the tests run well we can see that the function works as expected.
}