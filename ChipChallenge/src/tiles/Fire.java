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
public class Fire extends TileObject implements Conditional {

    private int imageIterator;

    public Fire() {
        this.image = new Image[6];
        this.imageIterator = 0;
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/fire1.png"));
            this.image[1] = ImageIO.read(getClass().getClassLoader().getResource("images/fire2.png"));
            this.image[2] = ImageIO.read(getClass().getClassLoader().getResource("images/fire3.png"));
            this.image[3] = ImageIO.read(getClass().getClassLoader().getResource("images/fire4.png"));
            this.image[4] = ImageIO.read(getClass().getClassLoader().getResource("images/fire5.png"));
            this.image[5] = ImageIO.read(getClass().getClassLoader().getResource("images/fire6.png"));
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
        this.imageIterator = (this.imageIterator + 1) % 6;
        return i;
    }

    @Override
    public boolean check(Chip chip) {
        if (chip.hasShoes(Color.RED)) {
            return true;
        } else {
            return false;
        }
    }
}
