package hw04;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void newGame() {
    }

    @Test
    public void playerNum() {
        Game gameTest = new Game();
        gameTest.playerNum(5);
        assertEquals(gameTest.getPlayers().size(), 5);
    }


    @Test
    public void makeCorporations() {
        Game gameTest = new Game();
        gameTest.makeCorporations();
        assertEquals(gameTest.getCorporations().size(), 7);
    }

//    @Test
//    public void nextPlayer(){
//        Game gameTest = new Game();
//        gameTest.nextPlayer();
//        assertEquals(gameTest.getPlayers().size(), 5);
//    }
//

}