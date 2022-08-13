package model;


public class PlayerHistory {
    int numOfGames;
    int numOfWins;
    int numOfLoses;
    GameRecord[] recentGames;
    GameRecord[] bestGames;

    public PlayerHistory(int numOfGames, int numOfWins, int numOfLoses) {
        super();
        this.numOfGames = numOfGames;
        this.numOfWins = numOfWins;
        this.numOfLoses = numOfLoses;
        this.recentGames = new GameRecord[5];
        this.bestGames = new GameRecord[5];
    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfGames(int numOfGames) {
        this.numOfGames = numOfGames;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumOfLoses() {
        return numOfLoses;
    }

    public void setNumOfLoses(int numOfLoses) {
        this.numOfLoses = numOfLoses;
    }

    public GameRecord[] getRecentGames() {
        return recentGames;
    }

    public void setRecentGames(GameRecord[] recentGames) {
        this.recentGames = recentGames;
    }

    public GameRecord[] getBestGames() {
        return bestGames;
    }

    public void setBestGames(GameRecord[] bestGames) {
        this.bestGames = bestGames;
    }

    public int getNumOfDraws() {
        return numOfGames - numOfWins - numOfLoses;
    }

    public void addRecentGame(GameRecord gr) {
        int nRecentGames = Math.min(4, numOfGames);
        for (int i = nRecentGames; i > 0; i--) {
            recentGames[i] = recentGames[i - 1];
        }
        recentGames[0] = gr;

    }


}