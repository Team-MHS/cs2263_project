package hw04;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Corporation {
    private final int SAFT_CORPORATION = 11;
    private final int NUMBER_OF_STOCKS = 25;

    private String name;
    @Getter private Integer price;
    private boolean madeCorporation;
    private List<Tile> tiles;
    @Getter private List<Share> shares;
    private HashMap<String, List<Share>> shares2;
    TileList tileList;

    public Corporation(String name, boolean tf , Integer price) {
        this.name = name;
        this.madeCorporation = tf;
        this.price = price;
        this.shares = setShares();
//
//        for(int i = 0; i < this.shares.length; ++i) {
//            this.shares[i] = new Share(name);
//        }

        this.tileList = new TileList();
    }

    /*
       TODO: can we test private methods ?
     */

    private List<Share> setShares(){
        List<Share> share = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_STOCKS; ++i) {
              share.add(new Share(name));
           }
        return share;
    }

    public void sellShares(Player owner){
        Share share = shares.get(0);
        shares.remove(share);
        share.changeOwner(owner.getName());
        owner.buyShares(share);
        owner.removeMoney(price);
    }

    public void returnShares(Player owner, Share share){
        share.changeOwner(null);
        shares.add(share);
        owner.sellShares(share);
        owner.addMoney(price);
    }

    public Boolean isSafe(){
        return tiles.size() >= SAFT_CORPORATION;
    }

    public boolean isMade() { return this.madeCorporation;}
}

