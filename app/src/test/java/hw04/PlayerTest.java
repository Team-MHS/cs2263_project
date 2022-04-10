package hw04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {


//
//    @Before
//    public void setUp() throws Exception {
//        System.out.println("Player test");
//
//    }

    @Test
    public void addMoney() {
        Player playerTest = new Player("test");
        playerTest.addMoney(500);
        assertEquals(6500, playerTest.getMoney());

    }

    @Test
    public void removeMoney() {
        Player playerTest = new Player("test");
        playerTest.removeMoney(500);
        assertEquals(5500, playerTest.getMoney());
    }

    @Test
    public void getName() {
        Player playerTest = new Player("test");
        assertEquals(playerTest.getName(), "test");

    }

    @Test
    public void getMoney() {
        Player playerTest = new Player("test");
        assertEquals(playerTest.getMoney(), 6000);
    }

    @Test
    public void getTileList() {
        Player playerTest = new Player("test");
        assertEquals(playerTest.getTileList().getSize(), 0);
    }

    @Test
    public void addTile() {
        Player playerTest = new Player("test");
        Tile tileTest = new Tile(0, 'y');
        playerTest.addTile(tileTest);
        assertEquals(playerTest.getTileList().getSize(), 1);

    }

    @Test
    public void removeTile() {
        Player playerTest = new Player("test");
        Tile tileTest = new Tile(0, 'y');
        playerTest.addTile(tileTest);
        playerTest.removeTile(0);
        assertEquals(playerTest.getTileList().getSize(), 0);

    }

    @Test
    public void buyShares() {
        Player playerTest = new Player("test");
        Share share = new Share("testShare");
        playerTest.buyShares(share);
        assertEquals(playerTest.getPlayerShares().size(), 1);

    }

    @Test
    public void seeShares() {
        Player playerTest = new Player("test");
        Share share = new Share("testShare");
        playerTest.seeShares(share);
        assertEquals(playerTest.getPlayerShares().size(), 1);

    }
}