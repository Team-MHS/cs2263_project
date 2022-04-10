package hw04;

import java.util.Iterator;
import java.util.List;

interface ClientInterface {

     void addPlayer(String name);

     String getName();

     List<TileList> getTiles();

     void buyShares();

     void sellShares();

     void holdShares();

     void tradeShares();

     void saveGame();

     void loadGame();

     void endTurn();

     void quitGame();




}
