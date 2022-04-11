package hw04;

import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private TileList tileList;


    private List<Share> playerShares;

    private int money;

    public Player(String name) {
        this.name = name;
        this.tileList = new TileList();
        this.money = 6000;
    }


    public void addMoney(int amount) {
        this.money += amount;
    }

    public void removeMoney(int amount) {
        this.money -= amount;
    }

    public String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    public TileList getTileList() {
        return this.tileList;
    }

    public void addTile(Tile t) { this.tileList.add(t); }

    public void removeTile(int n) { this.tileList.remove(n); }

    public void buyShares(Share s) { this.playerShares.add(s);}

    public void seeShares(Share s) { this.playerShares.remove(s);}
    public List<Share> getPlayerShares() {return this.playerShares;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName());
    }
    //&& Objects.equals(getTileList(), player.getTileList()) && Objects.equals(getPlayerShares(), player.getPlayerShares())

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
