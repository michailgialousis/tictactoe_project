package model;

import java.util.ArrayList;

public class Hal extends ComputerPlayer {

    public Hal(String name, PlayerHistory history) {
        super(name, history);
    }

    public int[] move(int asMover, String[][] gameBoard) {

        int[] result = minimax(asMover, asMover, gameBoard);
        return new int[]{result[1], result[2]};
    }

    public int[] minimax(int asMover, int minmaxPlayer, String[][] gameBoard) {

        int bestScore;
        int opponent = (asMover != 0) ? 0 : 1;
        int bestRow = -1;
        int bestCol = -1;
        int status = evaluation(gameBoard);

        if (status == 0 || status == 1 || status == 2) {
            bestScore = -1;
            if (status == asMover) bestScore = 1;
            else if (status == opponent) bestScore = -1;
            else if (status == 2) bestScore = 0;
            return new int[]{bestScore, bestRow, bestCol};
        } else {
            ArrayList<int[]> freeCells = new ArrayList<int[]>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameBoard[i][j] == null) {
                        freeCells.add(new int[]{i, j});
                    }
                }
            }

            bestScore = (asMover != minmaxPlayer) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            for (int[] move : freeCells) {
                gameBoard[move[0]][move[1]] = getPlayerMark(minmaxPlayer);
                if (asMover == minmaxPlayer) {
                    int curScore = minimax(asMover, opponent, gameBoard)[0];
                    if (curScore > bestScore) {
                        bestScore = curScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                } else {
                    int curScore = minimax(asMover, asMover, gameBoard)[0];
                    if (curScore < bestScore) {
                        bestScore = curScore;
                        bestRow = move[0];
                        bestCol = move[1];
                    }
                }

                gameBoard[move[0]][move[1]] = null;
            }

            return new int[]{bestScore, bestRow, bestCol};
        }
    }

    public int evaluation(String[][] gameBoard) {
        if (gameBoard[0][0] == "X" && gameBoard[0][1] == "X" && gameBoard[0][2] == "X" ||
                gameBoard[1][0] == "X" && gameBoard[1][1] == "X" && gameBoard[1][2] == "X" ||
                gameBoard[2][0] == "X" && gameBoard[2][1] == "X" && gameBoard[2][2] == "X" ||

                gameBoard[0][0] == "X" && gameBoard[1][0] == "X" && gameBoard[2][0] == "X" ||
                gameBoard[0][1] == "X" && gameBoard[1][1] == "X" && gameBoard[2][1] == "X" ||
                gameBoard[0][2] == "X" && gameBoard[1][2] == "X" && gameBoard[2][2] == "X" ||

                gameBoard[0][0] == "X" && gameBoard[1][1] == "X" && gameBoard[2][2] == "X" ||
                gameBoard[0][2] == "X" && gameBoard[1][1] == "X" && gameBoard[2][0] == "X")
            return 0;

        else if (gameBoard[0][0] == "O" && gameBoard[0][1] == "O" && gameBoard[0][2] == "O" ||
                gameBoard[1][0] == "O" && gameBoard[1][1] == "O" && gameBoard[1][2] == "O" ||
                gameBoard[2][0] == "O" && gameBoard[2][1] == "O" && gameBoard[2][2] == "O" ||

                gameBoard[0][0] == "O" && gameBoard[1][0] == "O" && gameBoard[2][0] == "O" ||
                gameBoard[0][1] == "O" && gameBoard[1][1] == "O" && gameBoard[2][1] == "O" ||
                gameBoard[0][2] == "O" && gameBoard[1][2] == "O" && gameBoard[2][2] == "O" ||

                gameBoard[0][0] == "O" && gameBoard[1][1] == "O" && gameBoard[2][2] == "O" ||
                gameBoard[0][2] == "O" && gameBoard[1][1] == "O" && gameBoard[2][0] == "O")
            return 1;

        else if (checkIfBoardIsFull(gameBoard))
            return 2;

        else
            return 3;

    }

    public boolean checkIfBoardIsFull(String[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    String getPlayerMark(int player) {
        if (player == 0)
            return "X";
        else if (player == 1)
            return "O";
        else
            return null;

    }
}