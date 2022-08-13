package view;

import java.awt.*;
import java.util.Collection;

import javax.swing.*;
import javax.swing.border.LineBorder;

import control.GameController;
import model.Player;

public class HallOfFame extends GamePanel {
    private JTextArea topPlayers;


    public HallOfFame(GameController gc) {
        super(gc);//}
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(MainWindow.WIDTH - 2 * MainWindow.PLAYER_WIDTH, MainWindow.HEIGHT - MainWindow.TOP_HEIGHT));
        this.setBorder(new LineBorder(Color.magenta, 2));

        this.topPlayers = new JTextArea(20, 100);
        this.topPlayers.setDisabledTextColor(Color.black);
        this.topPlayers.setBackground(Color.WHITE);
        this.topPlayers.setAlignmentX(CENTER_ALIGNMENT);
        this.topPlayers.setFont(new Font("Sans Sherif", Font.BOLD, 20));
        this.topPlayers.setEnabled(false);
        this.topPlayers.setVisible(true);
        this.topPlayers.setMargin(new Insets(10, 10, 10, 10));
        this.add(topPlayers);
    }

    private void setTopPlayers() {
        StringBuilder sb = new StringBuilder("");
        sb.append("\t          ").append("HALL OF FAME").append("\n\n");
        getModel().getPlayerRoster().findHallOfFame(10);
    }


}