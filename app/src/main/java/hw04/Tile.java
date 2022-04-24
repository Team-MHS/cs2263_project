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

import java.util.Objects;

public class Tile {
    private int x;
    private char y;
    private String name;


    public Tile(int x, char y) {
        this.x = x;
        this.y = y;
        this.name = x + "-" + y;
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
