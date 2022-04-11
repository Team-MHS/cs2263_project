package hw04;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class TileList {
    private List<Tile> tiles = new ArrayList();


    public void add(Tile t) {
        this.tiles.add(t);
    }

    public void add(TileList t) {
        this.tiles.addAll(t.tiles);
    }

    public Tile remove(int n) {return this.tiles.remove(n);}

    public void shuffle() {
        Collections.shuffle(this.tiles);
    }

    public int getSize() {
        return this.tiles.size();
    }

    public Tile getTile(int n) {
        return (Tile)this.tiles.get(n);
    }



}
