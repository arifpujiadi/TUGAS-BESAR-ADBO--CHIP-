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
 * Menyimpan informasi mengenai object water.
 * @author i08023
 */
public class Water extends TileObject implements Conditional {

    /**
     * Penunjuk gambar sekarang.
     */
    private int imageIterator;

    public Water() {
        this.image = new Image[8];
        this.imageIterator = 0;
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/water1.png"));
            this.image[1] = ImageIO.read(getClass().getClassLoader().getResource("images/water2.png"));
            this.image[2] = ImageIO.read(getClass().getClassLoader().getResource("images/water3.png"));
            this.image[3] = ImageIO.read(getClass().getClassLoader().getResource("images/water4.png"));
            this.image[4] = ImageIO.read(getClass().getClassLoader().getResource("images/water5.png"));
            this.image[5] = ImageIO.read(getClass().getClassLoader().getResource("images/water6.png"));
            this.image[6] = ImageIO.read(getClass().getClassLoader().getResource("images/water7.png"));
            this.image[7] = ImageIO.read(getClass().getClassLoader().getResource("images/water8.png"));
        } catch (IOException ex) {
            Logger.getLogger(Fire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int canBeStepped() {
        return 1;
    }

    @Override
    public boolean canBeTaken() {
        return false;
    }

    @Override
    public Image getImage() {
        Image i = this.image[this.imageIterator];
        this.imageIterator = (this.imageIterator + 1) % 8;
        return i;
    }

    @Override
    public boolean check(Chip chip) {
        if (chip.hasShoes(Color.BLUE)) {
            return true;
        } else {
            return false;
        }
    }
}
