package model;

import control.GameController;

import java.io.File;
import java.util.*;
import javax.swing.JOptionPane;

public class GameModel {
    Random random = new Random();
    Player[] gamePlayers;
    PlayerRoster playerRoster;
    public String[][] gameBoard;
    GameController gc;
    int mover = 100;
    Boolean end = false;

    public GameModel(GameController gc) {
        this.gc = gc;
        gamePlayers = new Player[2];
        gameBoard = null;
        playerRoster = new PlayerRoster();
        File file = new File("C:tuctactoe.ser");
        if (file.length() == 0)
            playerRoster.initialize();
        else
            playerRoster.loadPlayers();
        mover = random.nextInt(2);
    }

    public void checkDimValidity(int row, int col) {
        if (row < 0 || col < 0 || row > 2 || col > 2) {
            throw new IndexOutOfBoundsException(row + "," + col + " is not a valid board cell");
        }
    }

    public void checkMoveValidity(int row, int col) {
        checkDimValidity(row, col);
        if (gameBoard[row][col] != null) {
            throw new IllegalArgumentException("Non playable cell");
        }
    }

    public String getBoardMark(int row, int col) {
        checkDimValidity(row, col);
        return gameBoard[row][col];
    }

    public void makeMove(int row, int col) {
        checkMoveValidity(row, col);
        gameBoard[row][col] = getMoverMark();
        checkIfWon();
        if (inPlay()) {
            if (mover == 0) {
                mover = 1;
            } else mover = 0;

            playerMove();
        }
    }

    public String getMoverMark() {
        return mover != 0 ? "O" : "X";
    }

    public void playerMove() {

        int nextMove[] = gamePlayers[mover].move(mover, gameBoard);
        if (nextMove != null) {
            makeMove(nextMove[0], nextMove[1]);
            gc.getView().getMainPanel().paint(gc.getView().getMainPanel().getGraphics());
        }

    }

    public void selectPlayer(Player player, int pos) {
        if (pos < 0 && pos > 1) return;
        gamePlayers[pos] = player;
    }

    public boolean ready() {
        return (gamePlayers[0] != null && gamePlayers[1] != null);
    }

    public void startGame() {
        gameBoard = new String[3][3];
    }

    public boolean inPlay() {
        return gameBoard != null;
    }

    public boolean NoPlay() {
        return !inPlay();
    }

    public Player[] getGamePlayers() {
        return gamePlayers;
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public PlayerRoster getPlayerRoster() {
        return this.playerRoster;
    }


    public String getPlayerStats(String player) {
        StringBuilder sb = new StringBuilder("");
        sb.append(player).append("\n\n\n");
        sb.append("Total:").append("\t").append(4).append("\n");
        sb.append("Won:").append("\t").append("69%").append("\n");
        sb.append("Lost:").append("\t").append("25%").append("\n");
        return sb.toString();
    }

    public void checkIfWon() {
        if (getBoardMark(0, 0) == "X" && getBoardMark(0, 1) == "X" && getBoardMark(0, 2) == "X" ||
                getBoardMark(1, 0) == "X" && getBoardMark(1, 1) == "X" && getBoardMark(1, 2) == "X" ||
                getBoardMark(2, 0) == "X" && getBoardMark(2, 1) == "X" && getBoardMark(2, 2) == "X" ||

                getBoardMark(0, 0) == "X" && getBoardMark(1, 0) == "X" && getBoardMark(2, 0) == "X" ||
                getBoardMark(0, 1) == "X" && getBoardMark(1, 1) == "X" && getBoardMark(2, 1) == "X" ||
                getBoardMark(0, 2) == "X" && getBoardMark(1, 2) == "X" && getBoardMark(2, 2) == "X" ||

                getBoardMark(0, 0) == "X" && getBoardMark(1, 1) == "X" && getBoardMark(2, 2) == "X" ||
                getBoardMark(0, 2) == "X" && getBoardMark(1, 1) == "X" && getBoardMark(2, 0) == "X") {
            System.out.println("Χ won");
            JOptionPane.showMessageDialog(null, "Χ won! Game Over.");
            setBoardUnusable();
            end = true;
        } else if (getBoardMark(0, 0) == "O" && getBoardMark(0, 1) == "O" && getBoardMark(0, 2) == "O" ||
                getBoardMark(1, 0) == "O" && getBoardMark(1, 1) == "O" && getBoardMark(1, 2) == "O" ||
                getBoardMark(2, 0) == "O" && getBoardMark(2, 1) == "O" && getBoardMark(2, 2) == "O" ||

                getBoardMark(0, 0) == "O" && getBoardMark(1, 0) == "O" && getBoardMark(2, 0) == "O" ||
                getBoardMark(0, 1) == "O" && getBoardMark(1, 1) == "O" && getBoardMark(2, 1) == "O" ||
                getBoardMark(0, 2) == "O" && getBoardMark(1, 2) == "O" && getBoardMark(2, 2) == "O" ||

                getBoardMark(0, 0) == "O" && getBoardMark(1, 1) == "O" && getBoardMark(2, 2) == "O" ||
                getBoardMark(0, 2) == "O" && getBoardMark(1, 1) == "O" && getBoardMark(2, 0) == "O") {
            System.out.println("O won");
            JOptionPane.showMessageDialog(null, "O won! Game Over.");
            setBoardUnusable();
            end = true;
        } else if ((getBoardMark(0, 0) != (null)) &&
                (getBoardMark(0, 1) != (null)) &&
                (getBoardMark(0, 2) != (null)) &&
                (getBoardMark(1, 0) != (null)) &&
                (getBoardMark(1, 1) != (null)) &&
                (getBoardMark(1, 2) != (null)) &&
                (getBoardMark(2, 0) != (null)) &&
                (getBoardMark(2, 1) != (null)) &&
                (getBoardMark(2, 2) != (null))) {
            end = true;
            System.out.println("Its a tie");
            JOptionPane.showMessageDialog(null, "Its's a Tie! Game Over.");
        }

        if (end == true) {
            System.out.println("End true");
            gc.done();

        }

    }


    public void setBoardUnusable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == null)
                    gameBoard[i][j] = "A";
            }
        }
    }
}