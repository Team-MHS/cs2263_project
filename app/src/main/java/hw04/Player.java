/*
 * MIT License
 *
 * Copyright (c) 2022 Team-MHS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @author Michael Esquivias
 */

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

    public void sellShares(Share s) { this.playerShares.remove(s);}
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
