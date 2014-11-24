package level;

import tiles.*;
import java.awt.*;
import tiles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public abstract class Level {

    protected Tile[][] tiles;
    protected int width;
    protected int length;
    protected int ICRequired;
    protected Barrier barrier;
    protected Door redDoor;
    protected Door greenDoor;
    protected Door blueDoor;
    protected Door yellowDoor;
    protected Key redKey;
    protected Key greenKey;
    protected Key blueKey;
    protected Key yellowKey;
    protected IC IC;
    protected Wall wall;
    protected Shoes redShoes;
    protected Shoes blueShoes;
    protected String[] message;

    public Level() {
        this.barrier = new Barrier();
        this.redDoor = new Door(Color.red);
        this.greenDoor = new Door(Color.green);
        this.blueDoor = new Door(Color.blue);
        this.yellowDoor = new Door(Color.yellow);
        this.redKey = new Key(Color.red);
        this.greenKey = new Key(Color.green);
        this.blueKey = new Key(Color.blue);
        this.yellowKey = new Key(Color.yellow);
        this.IC = new IC();
        this.wall = new Wall();
        this.redShoes = new Shoes(Color.red);
        this.blueShoes = new Shoes(Color.blue);
    }

    public Tile[][] getMap() {
        return this.tiles;
    }

    public int getICRequired() {
        return this.ICRequired;
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
    }

    public abstract Point getInitialChipCoordinate();

    protected abstract void createMap();

    public abstract void initializeLevel();
    
    public abstract String[] getMessage();

    public abstract int getLevelName();
}
