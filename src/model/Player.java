package model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Player implements Serializable {
    String name;
    PlayerHistory history;

    public int[] move(int asMover, String[][] gameBoard) {
        System.out.println("this is default Player strategy for " + this.getClass());
        return null;
    }

    public Player(String name, PlayerHistory history) {
        super();
        this.name = name;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerHistory getHistory() {
        return history;
    }

    public void setHistory(PlayerHistory history) {
        this.history = history;
    }

    public float getScore() {
        if (history.numOfGames > 0)
            return 50 * (2 * history.getNumOfWins() + history.getNumOfDraws()) / history.getNumOfGames();
        else
            return 0;
    }


}