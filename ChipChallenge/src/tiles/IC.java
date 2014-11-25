package tiles;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import tiles.TileObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Menyimpan informasi mengenai object IC.
 * @author i08023
 */
public class IC extends TileObject {

    public IC() {
        this.image = new Image[1];
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/IC.png"));
        } catch (IOException ex) {
        }
    }

    @Override
    public int canBeStepped() {
        return 0;
    }

    @Override
    public boolean canBeTaken() {
        return true;
    }

    @Override
    public Image getImage() {
        return this.image[0];
    }
}
