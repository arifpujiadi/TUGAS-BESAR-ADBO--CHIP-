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
/**
 * Menampung seluruh level yang tersedia dalam linked list dan memeriksa apakah 
 * masih tersedia level di dalam list.
 * @author i08023
 */
public class Levels {
    
    /**
     * Menyimpan list level yang tersedia pada permainan.
     */
    private LinkedList<Level> listLevel;
    
    /**
     * Mengembalikan level yang sedang dimainkan saat ini
     */
    private Level currentLevel;
    
    /**
     * List iterator dari list level.
     */
    private ListIterator li;

    public Levels() {
        this.listLevel = new LinkedList<Level>();
        this.listLevel.add(new Level1());
        this.listLevel.add(new Level2());
        this.listLevel.add(new Level3());
        this.li = this.listLevel.listIterator();
        this.currentLevel = (Level) this.li.next();
    }
    
    /**
     * Mengembalikan jumlah IC yang diperlukan.
     * @return jumlah IC bertipe integer
     */
    public int getICRequired() {
        return this.currentLevel.getICRequired();
    }
    
    /**
     * Mengembalikan lebar map.
     * @return lebar bertipe integer
     */
    public int getWidth() {
        return this.currentLevel.getWidth();
    }
    
    /**
     * Mengembalikan panjang map.
     * @return panjang bertipe integer
     */
    public int getLength() {
        return this.currentLevel.getLength();
    }
    
    /**
     * Mengembalikan map.
     * @return Tile bertipe array 2 dimensi
     */
    public Tile[][] getMap() {
        return this.currentLevel.getMap();
    }
    
    /**
     * Mengembalikan posisi awal chip.
     * @return kordinat chip bertipe Point
     */
    public Point getInitialChipCoordinate() {
        return this.currentLevel.getInitialChipCoordinate();
    }
    
    /**
     * Mengembalikan status permainan, true jika berhasil.
     * @return nilai boolean
     */
    public boolean goToTheNextLevel() {
        if (li.hasNext()) {
            this.currentLevel = (Level) this.li.next();
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method untuk mereset level sekarang.
     */
    public void resetLevel() {
        this.currentLevel.createMap();
    }
    
    /**
     * Memastikan game sudah berakhir.
     * @return true jika level sekarang merupakan level terakhir
     */
    public boolean endLevel() {
        return this.getCurrentLevel() == this.listLevel.getLast();
    }
    
    /**
     * Mengembalikan level saat ini
     * @return currentLevel bertipe Level
     */
    public Level getCurrentLevel() {
        return currentLevel;
    }
}
