package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class
PlayerRoster {

    Collection<Player> players;
    private model.Player Player;

    public PlayerRoster() {
        players = new ArrayList<Player>();

    }

    public void add(Player p) {
        if (findPlayer(p.getName()) == null) {
            players.add(p);
        }
    }

    public Collection<String> findPlayerNames() {
        ArrayList<String> playerNames = new ArrayList<String>();
        for (Player varp : players) {
            playerNames.add(varp.getName());
        }
        return playerNames;
    }

    public Player findPlayer(String name) {
        for (Player varp : players) {
            if (varp.getName().equals(name))
                return varp;
        }
        return null;
    }

    class PlayerComparator implements Comparator<Player> {

        boolean reverse;

        public PlayerComparator() {
            reverse = false;
        }

        public PlayerComparator(boolean reverse) {
            this.reverse = reverse;
        }

        @Override
        public int compare(Player arg0, Player arg1) {

            int result;
            if (arg0.getScore() < arg1.getScore()) result = -1;
            else if (arg0.getScore() == arg1.getScore()) result = 0;
            else result = 1;
            if (reverse) result *= -1;
            return result;
        }
    }

    public Collection<Player> findHallOfFame(int n) {
        ArrayList<Player> tmplist = new ArrayList<Player>(players);
        Collections.sort(tmplist, new PlayerComparator(true));
        ArrayList<Player> tmplist_n = new ArrayList<Player>();
        int numAdded = 0;
        for (Player elem : tmplist) {
            if (numAdded >= n) break;
            tmplist_n.add(elem);
            numAdded++;
        }
        return tmplist_n;
    }

    public void initialize() {
        add(new HumanPlayer("Mimis Kalimis", null));
        add(new HumanPlayer("Mike Palousis", null));
        add(new MrBean("Mr Bean", null));
        add(new Hal("Hal", null));
    }

    public Collection<Player> getPlayers() {
        return this.players;
    }

    public void storePlayers() {
        ObjectOutputStream os = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("tuctactoe.ser");
            os = new ObjectOutputStream(fos);
            for (Player player : players) {
                os.writeObject(player);
            }
            System.out.println("All players stored  successfully.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public void loadPlayers() {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        //int pos = 0;
        try {
            fis = new FileInputStream("tuctactoe.ser");
            ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Player player = (Player) ois.readObject();
                this.add(player);
            }
            System.out.println("Loaded players");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (Exception e) {
            }
        }
    }

}