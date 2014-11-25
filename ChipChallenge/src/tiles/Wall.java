package tiles;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.*;
import javax.imageio.ImageIO;
import tiles.TileObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Menyimpan informasi mengenai object wall.
 * @author i08023
 */
public class Wall extends TileObject {

    public Wall() {
        this.image = new Image[1];
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/wall.png"));
        } catch (IOException ex) {
            Logger.getLogger(Wall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int canBeStepped() {
        return -1;
    }

    @Override
    public boolean canBeTaken() {
        return false;
    }

    @Override
    public Image getImage() {
        return this.image[0];
    }
}
