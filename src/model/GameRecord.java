package model;

import java.time.LocalDateTime;

public class GameRecord {
    private LocalDateTime gameDateTime;
    private String XPlayerName;
    private String OPlayerName;
    private String result;
    private double Xscore;
    private double Oscore;

    public GameRecord(String xPlayerName, String oPlayerName, String result, float xscore, float oscore,
                      LocalDateTime gameDateTime) {
        super();
        XPlayerName = xPlayerName;
        OPlayerName = oPlayerName;
        this.result = result;
        Xscore = xscore;
        Oscore = oscore;
        this.gameDateTime = gameDateTime;
    }

    public GameRecord(String xPlayerName, String oPlayerName, String result, float xscore, float oscore) {
        super();
        XPlayerName = xPlayerName;
        OPlayerName = oPlayerName;
        this.result = result;
        Xscore = xscore;
        Oscore = oscore;
        this.gameDateTime = LocalDateTime.now();
    }

    public String opponent(Player player) {
        if (player.equals(XPlayerName)) {
            return OPlayerName;
        } else return XPlayerName;
    }


}