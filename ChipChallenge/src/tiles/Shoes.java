package tiles;

import java.awt.*;
import java.io.IOException;
import java.util.logging.*;
import javax.imageio.ImageIO;
import tiles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Menyimpan informasi mengenai object shoes.
 * @author i08023
 */
public class Shoes extends TileObject {

    /**
     * warna sepatu (Red , Blue)
     */
    private Color color;

    public Shoes(Color color) {
        this.image = new Image[1];
        this.color = color;
        try {
            if (this.color.equals(Color.RED)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/shoes_red.png"));
            } else if (this.color.equals(Color.BLUE)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/shoes_blue.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Key.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * Mendapatkan warna sepatu.
     * @return warna bertipe Color
     */
    public Color getColor() {
        return this.color;
    }

    @Override
    public Image getImage() {
        return this.image[0];
    }
}
