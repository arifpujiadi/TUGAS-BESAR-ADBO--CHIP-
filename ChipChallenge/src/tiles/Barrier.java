package tiles;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.*;
import javax.imageio.ImageIO;
import tiles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Barrier extends TileObject implements Conditional {

    public Barrier() {
        this.image = new Image[1];
        try {
            this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/barrier.png"));
        } catch (IOException ex) {
            Logger.getLogger(Barrier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int canBeStepped() {
        return 3;
    }

    @Override
    public boolean canBeTaken() {
        return true;
    }

    @Override
    public boolean check(Chip chip) {
        if (chip.getICAcquired() >= chip.getICRequired()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Image getImage() {
        return this.image[0];
    }
}
