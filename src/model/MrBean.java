package model;

import java.util.Random;

public class MrBean extends ComputerPlayer {

    public MrBean(String name, PlayerHistory history) {
        super(name, history);

    }

    @Override
    public int[] move(int asMover, String[][] gameBoard) {

        Random random = new Random();
        int i = 0, j = 0;

        do {
            i = random.nextInt(3);
            j = random.nextInt(3);
        } while (gameBoard[i][j] != null && !checkForFullBoard(gameBoard));

        int freeCell[] = {i, j};
        return freeCell;
    }

    boolean checkForFullBoard(String[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == null)
                    return false;
            }
        }
        return true;
    }
}