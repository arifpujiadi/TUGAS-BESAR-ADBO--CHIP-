package tiles;

import java.awt.Image;
import tiles.Drawable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Memeriksa object yang berada di atas tile.
 * @author i08023
 */
public abstract class TileObject implements Drawable {
    
    /**
     * Menyimpan gambar.
     */
    protected Image[] image;
    
    /**
     * Apakah objek ini dapat diinjak atau tidak.
     * @return
     * -1 objek tidak dapat diinjak, 
     * 0 objek dapat langsung diinjak, 
     * 1 dapat diinjak, tetapi jika terinjak, pengingjak akan mati dan permainan berakhir, 
     * 2 dapat diinjak, jika terinjak, penginjak menang dan permainan berakhir, 
     * 3 dapat diinjak, tetapi harus ada pengecekan terlebih dahulu apakah persyaratan penginjak memenuhi atau tidak.
     */
    public abstract int canBeStepped();
    
    /**
     * Method untuk mengecek apakah objek ini dapat diambil atau tidak.
     * @return true jika objek dapat diambil, false jika sebaliknya
     */
    public abstract boolean canBeTaken();
}
