package model;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, PlayerHistory history) {
        super(name, history);
    }

    public String getAlgorithm() {
        return null;
    }

    int[] move(int asMover, String gameBoard) {
        return new int[0];
    }

}

