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
public class Door extends TileObject {

    private Color color;

    public Door(Color color) {
        this.image = new Image[1];
        this.color = color;
        try {
            if (color.equals(Color.RED)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/door_red.png"));
            } else if (color.equals(Color.GREEN)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/door_green.png"));
            } else if (color.equals(Color.BLUE)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/door_blue.png"));
            } else if (color.equals(Color.YELLOW)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/door_yellow.png"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean openDoor(Chip chip) {
        if (chip.getColoredKeyAcquired(this.color) > 0) {
            chip.useKey(color);
            return true;
        }
        return false;
    }

    @Override
    public Image getImage() {
        return this.image[0];
    }
}
