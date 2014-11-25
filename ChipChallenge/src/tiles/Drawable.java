package tiles;

import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Berfungsi untuk mengembalikan image dari object yang mengimplementasikannya.
 * @author i08023
 */
public interface Drawable {
    
    /**
     * Mengembalikan sebuah image.
     * @return Image
     */
    public Image getImage();
}
