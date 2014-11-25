package level;

import tiles.*;
import java.awt.*;
import tiles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Berfungsi sebagai parent class dari level yang ada.
 * @author i08023
 */
public abstract class Level {
    
    /**
     * Menyimpan tiles.
     */
    protected Tile[][] tiles;
    
    /**
     * Menyimpan lebar map.
     */
    protected int width;
    
    /**
     * Menyimpan panjang map.
     */
    protected int length;
    
    /**
     * Menyimpan jumlah IC yang diperlukan.
     */
    protected int ICRequired;
    
    /**
     * Menyimpan penghalang chip sebelum masuk finish.
     */
    protected Barrier barrier;
    
    /**
     * Menyimpan pintu merah.
     */
    protected Door redDoor;
    
    /**
     * Menyimpan pintu hijau.
     */
    protected Door greenDoor;
    
    /**
     * Menyimpan pintu biru.
     */
    protected Door blueDoor;
    
    /**
     * Menyimpan pintu kuning.
     */
    protected Door yellowDoor;
    
    /**
     * Menyimpan kunci merah.
     */
    protected Key redKey;
    
    /**
     * Menyimpan kunci hijau.
     */
    protected Key greenKey;
    
    /**
     * Menyimpan kunci biru.
     */
    protected Key blueKey;
    
    /**
     * Menyimpan kunci kuning.
     */
    protected Key yellowKey;
    
    /**
     * Menyimpan IC yang harus diambil chip.
     */
    protected IC IC;
    
    /**
     * Menyimpan dinding penghalang yang tidak bisa ditembus.
     */
    protected Wall wall;
    
    /**
     * Menyimpan sepatu merah yang tahan api.
     */
    protected Shoes redShoes;
    
    /**
     * Menyimpan sepatu biru yang tahan air.
     */
    protected Shoes blueShoes;
    
    /**
     * Menyimpan pesan untuk di akhir level.
     */
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
    
    /**
     * Mengembalikan grid dari map.
     * @return Tile bertipe array 2 dimensi
     */
    public Tile[][] getMap() {
        return this.tiles;
    }
    
    /**
     * Mengembalikan jumlah IC yang diperlukan.
     * @return jumlah IC betipe integer
     */
    public int getICRequired() {
        return this.ICRequired;
    }
    
    /**
     * Mengembalikan lebar map.
     * @return lebar bertipe integer
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Mengembalikan panjang map.
     * @return panjang bertipe integer
     */
    public int getLength() {
        return this.length;
    }
    
    /**
     * Method untuk mengembalikan koordinat pertama chip.
     * @return kordinat yang bertipe Point
     */
    public abstract Point getInitialChipCoordinate();
    
    /**
     * Method untuk membuat map pada level.
     */
    protected abstract void createMap();
    
    /**
     * Method untuk menginisialisasi level.
     */
    public abstract void initializeLevel();
    
    /**
     * Untuk menampilkan message setelah level berakhir (karena jatuh atau menang)
     * @return array dari string yang berisi message
     */
    public abstract String[] getMessage();
    
    /**
     * Mengembalikan nama level 
     * @return return nama level bertipe int
     */
    public abstract int getLevelName();
}
