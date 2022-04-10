package hw04;

import java.util.Objects;

public class Tile {
    private int x;
    private char y;
    private String name;


    public Tile(int x, char y) {
        this.x = x;
        this.y = y;
        this.name = y + "-" + x;
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return x;
    }


    public char getY() {
        return y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile)) return false;
        Tile tile = (Tile) o;
        return x == tile.x && y == tile.y && Objects.equals(getName(), tile.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, getName());
    }
}
