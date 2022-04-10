package hw04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShareTest {

    @Test
    public void changeOwner() {
        Share shareTest = new Share("testOwner");
        shareTest.changeOwner("newTestOwner");
        assertEquals("newTestOwner", shareTest.getOwner());
    }

    @Test
    public void getOwner() {
        Share shareTest = new Share("testOwner");
        assertEquals("testOwner", shareTest.getOwner());
    }


}