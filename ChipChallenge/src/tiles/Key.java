package tiles;

import java.awt.*;
import java.io.IOException;
import java.util.logging.*;
import javax.imageio.ImageIO;
import tiles.TileObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Key extends TileObject {

    private Color color;

    public Key(Color color) {
        this.image = new Image[1];
        this.color = color;
        try {
            if (this.color.equals(Color.RED)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/key_red.png"));
            } else if (this.color.equals(Color.GREEN)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/key_green.png"));
            } else if (this.color.equals(Color.BLUE)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/key_blue.png"));
            } else if (this.color.equals(Color.YELLOW)) {
                this.image[0] = ImageIO.read(getClass().getClassLoader().getResource("images/key_yellow.png"));
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

    public Color getColor() {
        return this.color;
    }

    @Override
    public Image getImage() {
        return this.image[0];
    }
}
