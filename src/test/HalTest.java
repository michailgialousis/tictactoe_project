package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Hal;

class HalTest {

    Hal hal;

    @BeforeEach
    void setUp() {
        hal = new Hal("Hal",null);
    }

    //From halTest1_1_1 to halTest1_1_5 its being tested if the function 'move' returns the correct row of best move.
    @Test
    void halTest1_1_1() {

        String[][] board= {{"X","X",null},
                {"O",null,null},
                {"O",null,null}};

        assertEquals(0, hal.move(1, board)[0]);
    }

    @Test
    void halTest1_1_2() {

        String[][] board= {{"X","X",null},
                {null,null,"O"},
                {null,null,"O"}};

        assertEquals(0, hal.move(0, board)[0]);
    }

    @Test
    void halTest1_1_3() {

        String[][] board= {{"X","X","O"},
                {null,"O",null},
                {null,null,null}};

        assertEquals(2, hal.move(0, board)[0]);
    }

    @Test
    void halTest1_1_4() {

        String[][] board= {{"O","O","X"},
                {null,null,null},
                {"X",null,null}};

        assertEquals(1, hal.move(1, board)[0]);
    }

    @Test
    void halTest1_1_5() {

        String[][] board= {{"X","O",null},
                {null,"O",null},
                {null,"X","X"}};

        assertEquals(2, hal.move(1, board)[0]);
    }



    //From halTest1_2_1 to halTest1_2_5 its being tested if the function 'move' returns the correct column of best move.
    @Test
    void halTest1_2_1() {

        String[][] board= {{"X","X",null},
                {"O",null,null},
                {"O",null,null}};

        assertEquals(2, hal.move(1, board)[1]);
    }

    @Test
    void halTest1_2_2() {

        String[][] board= {{"X","X",null},
                {null,null,"O"},
                {null,null,"O"}};

        assertEquals(2, hal.move(0, board)[1]);
    }

    @Test
    void halTest1_2_3() {

        String[][] board= {{"X","X","O"},
                {null,"O",null},
                {null,null,null}};

        assertEquals(0, hal.move(0, board)[1]);
    }

    @Test
    void halTest1_2_4() {

        String[][] board= {{"O","O","X"},
                {null,null,null},
                {"X",null,null}};

        assertEquals(1, hal.move(1, board)[1]);
    }

    @Test
    void halTest1_2_5() {

        String[][] board= {{"X","O",null},
                {null,"O",null},
                {null,"X","X"}};

        assertEquals(0, hal.move(1, board)[1]);
    }
// The function 'move' works perfectly while it returns the expected coordinates (columns & rows) of best move.
//-------------------------------------------------------------------------------------------


    //From halTest2_1_1 to halTest2_1_5 its being tested if the function 'minimax' returns the correct row of best move.
    @Test
    void halTest2_1_1() {

        String[][] board= {{"X","X",null},
                {"O",null,null},
                {"O",null,null}};

        assertEquals(0, hal.minimax(0, 0, board)[1]);
    }

    @Test
    void halTest2_1_2() {

        String[][] board= {{"X","X",null},
                {null,null,"O"},
                {null,null,"O"}};

        assertEquals(0, hal.minimax(0, 0, board)[1]);
    }

    @Test
    void halTest2_1_3() {

        String[][] board= {{"X","X","O"},
                {null,"O",null},
                {null,null,null}};

        assertEquals(2, hal.minimax(0, 0, board)[1]);
    }

    @Test
    void halTest2_1_4() {

        String[][] board= {{"O","O","X"},
                {null,null,null},
                {"X",null,null}};

        assertEquals(1, hal.minimax(1, 1, board)[1]);
    }

    @Test
    void halTest2_1_5() {

        String[][] board= {{"X","O",null},
                {null,"O",null},
                {null,"X","X"}};

        assertEquals(2, hal.minimax(1, 1, board)[1]);
    }



    //From halTest2_2_1 to halTest2_2_5 its being tested if the function 'minimax' returns the correct column of best move.
    @Test
    void halTest2_2_1() {

        String[][] board= {{"X","X",null},
                {"O",null,null},
                {"O",null,null}};

        assertEquals(2, hal.minimax(1, 1, board)[2]);
    }

    @Test
    void halTest2_2_2() {

        String[][] board= {{"X","X",null},
                {null,null,"O"},
                {null,null,"O"}};

        assertEquals(2, hal.minimax(0, 0, board)[2]);
    }

    @Test
    void halTest2_2_3() {

        String[][] board= {{"X","X","O"},
                {null,"O",null},
                {null,null,null}};

        assertEquals(0, hal.minimax(0, 0, board)[2]);
    }

    @Test
    void halTest2_2_4() {

        String[][] board= {{"O","O","X"},
                {null,null,null},
                {"X",null,null}};

        assertEquals(1, hal.minimax(1, 1, board)[2]);
    }

    @Test
    void halTest2_2_5() {

        String[][] board= {{"X","O",null},
                {null,"O",null},
                {null,"X","X"}};

        assertEquals(0, hal.minimax(1, 1, board)[2]);
    }



    //From halTest2_3_1 to halTest2_3_5 its being tested if the function 'minimax' returns the correct best score.
    @Test
    void halTest2_3_1() {

        String[][] board= {{"X","X",null},
                {"O",null,null},
                {"O",null,null}};

        assertEquals(-1, hal.minimax(1, 1, board)[0]);
    }

    @Test
    void halTest2_3_2() {

        String[][] board= {{"X","X",null},
                {null,null,"O"},
                {null,null,"O"}};

        assertEquals(1, hal.minimax(0, 0, board)[0]);
    }

    @Test
    void halTest2_3_3() {

        String[][] board= {{"X","X","O"},
                {null,"O",null},
                {null,null,null}};

        assertEquals(0, hal.minimax(0, 0, board)[0]);
    }

    @Test
    void halTest2_3_4() {

        String[][] board= {{"O","O","X"},
                {null,null,null},
                {"X",null,null}};

        assertEquals(1, hal.minimax(1, 1, board)[0]);
    }

    @Test
    void halTest2_3_5() {

        String[][] board= {{"X","O",null},
                {null,"O",null},
                {null,"X","X"}};

        assertEquals(0, hal.minimax(1, 1, board)[0]);
    }

// The function 'minimax' works perfectly while it returns the expected coordinates (columns & rows) of best move and the score of that move.
//------------------------------------------------------------------------------------


    //From halTest3_1_1 to halTest3_1_4 its being tested if the function 'evaluation' returns the correct value based on game status.
    @Test
    void halTest3_1_1() {

        String[][] board=  {{"O","O","X"},
                {null,"X",null},
                {null,null,"O"}};

        assertEquals(3, hal.evaluation(board));
    }

    @Test
    void halTest3_1_2() {

        String[][] board=  {{"O","O","X"},
                {"X","X","O"},
                {"O","X","O"}};

        assertEquals(2, hal.evaluation(board));
    }

    @Test
    void halTest3_1_3() {

        String[][] board=  {{"O","O","X"},
                {"O","X","X"},
                {"O","X","O"}};

        assertEquals(1, hal.evaluation(board));
    }

    @Test
    void halTest3_1_4() {

        String[][] board=  {{"O","O","X"},
                {"O","X","O"},
                {"X","X","O"}};

        assertEquals(0, hal.evaluation(board));
    }
//The function 'evaluation' works correctly while returning 3 for still going game, 2 for tie, 1 for 'O' win and 0 for 'X' win.
//------------------------------------------------------------------------


    //From halTest4_1_1 to halTest4_1_5 its being tested if the function 'checkIfBoardIsFull' works.
    @Test
    void halTest4_1_1() {

        String[][] board=  {{"O","O","X"},
                {"O","X","O"},
                {"X","X","O"}};

        assertTrue(hal.checkIfBoardIsFull(board));
    }

    @Test
    void halTest4_1_2() {

        String[][] board=  {{"X","O","X"},
                {"O","O","O"},
                {"X","X","O"}};

        assertTrue(hal.checkIfBoardIsFull(board));
    }

    @Test
    void halTest4_1_3() {

        String[][] board=  {{"O",null,null},
                {"O","X","O"},
                {"X","X","O"}};

        assertFalse(hal.checkIfBoardIsFull(board));
    }

    @Test
    void halTest4_1_4() {

        String[][] board=  {{"O",null,null},
                {"O","X","O"},
                {null,"X",null}};

        assertFalse(hal.checkIfBoardIsFull(board));
    }

    @Test
    void halTest4_1_5() {

        String[][] board=  {{"O",null,null},
                {null,null,null},
                {null,"X",null}};

        assertFalse(hal.checkIfBoardIsFull(board));
    }
}