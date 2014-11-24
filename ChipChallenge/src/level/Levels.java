package level;

import java.awt.Point;
import java.util.*;
import level.*;
import tiles.Tile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Levels {

    private LinkedList<Level> listLevel;

    private Level currentLevel;

    private ListIterator li;

    public Levels() {
        this.listLevel = new LinkedList<Level>();
        this.listLevel.add(new Level1());
        this.li = this.listLevel.listIterator();
        this.currentLevel = (Level) this.li.next();
    }

    public int getICRequired() {
        return this.currentLevel.getICRequired();
    }

    public int getWidth() {
        return this.currentLevel.getWidth();
    }

    public int getLength() {
        return this.currentLevel.getLength();
    }

    public Tile[][] getMap() {
        return this.currentLevel.getMap();
    }

    public Point getInitialChipCoordinate() {
        return this.currentLevel.getInitialChipCoordinate();
    }

    public boolean goToTheNextLevel() {
        if (li.hasNext()) {
            this.currentLevel = (Level) this.li.next();
            return true;
        } else {
            return false;
        }
    }

    public void resetLevel() {
        this.currentLevel.createMap();
    }
}
