package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.GameModel;
import model.HumanPlayer;
import model.Player;
import view.MainAreaPanel;
import view.MainWindow;

import javax.swing.*;

public class GameController extends WindowAdapter {
    MainWindow view;
    GameModel model;

    public GameController() {
    }

    @Override
    public void windowClosing(WindowEvent event) {
        quit();
    }


    public void start() {
        this.view = new MainWindow(this);
        this.model = new GameModel(this);
        this.view.addWindowListener(this);
        this.view.setVisible(true);

    }

    public void done() {
        this.view.getTopPanel().getDoneBtn().setEnabled(true);

    }


    public void quit() {
        System.out.println("Adios Amigos...");
        System.exit(0);
    }

    public void quitWindow() {
        System.out.println("New game!!");
        view.dispose();
    }

    public void selectPlayer(Player p, int pos) {
        this.model.selectPlayer(p, pos);
        System.out.println("Player " + pos + " set to " + p.getName());
        this.view.getTopPanel().getStartBtn().setEnabled(model.ready());
    }

    public void addNewPlayer() {
        String newPlayersName = JOptionPane.showInputDialog("Type the players name: ");
        if (newPlayersName.toCharArray().length > 20 || newPlayersName.startsWith(" ") || newPlayersName.endsWith(" ")) {
            JOptionPane.showMessageDialog(null, "Player's name is longer than 20 characters or it starts or ends with space!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        this.model.getPlayerRoster().add(new HumanPlayer(newPlayersName, null));
        this.getModel().getPlayerRoster().storePlayers();
    }


    public void startGame() {
        this.model.setGameBoard(new String[3][3]);
        this.view.getTopPanel().getStartBtn().setEnabled(false);
        this.view.getMainPanel().showCard(MainAreaPanel.BOARD);
        this.view.getLeftPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
        this.view.getRightPanel().getSelectPlayerBtn().setEnabled(model.NoPlay());
        this.view.getTopPanel().getAddPlayerBtn().setEnabled(model.NoPlay());
        this.model.playerMove();
    }

    public GameModel getModel() {
        return model;
    }

    public MainWindow getView() {
        return view;
    }


}