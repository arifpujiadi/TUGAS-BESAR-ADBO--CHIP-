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
public class Finish extends TileObject {

    private int imageIterator;

    public Finish() {
        this.image = new Image[4];
        this.imageIterator = 0;
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/finish1.png"));
            this.image[1] = ImageIO.read(getClass().getClassLoader().getResource("images/finish2.png"));
            this.image[2] = ImageIO.read(getClass().getClassLoader().getResource("images/finish3.png"));
            this.image[3] = ImageIO.read(getClass().getClassLoader().getResource("images/finish4.png"));
        } catch (IOException ex) {
            Logger.getLogger(Finish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int canBeStepped() {
        return 2;
    }

    @Override
    public boolean canBeTaken() {
        return false;
    }

    @Override
    public Image getImage() {
        Image i = this.image[this.imageIterator];
        this.imageIterator = (this.imageIterator + 1) % 4;
        return i;
    }
}
