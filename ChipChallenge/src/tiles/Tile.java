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
public class Tile implements Drawable {

    private int x;
    private int y;
    private TileObject object;
    private Image image;

    public Tile() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("images/tile.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TileObject getWhatIsStepped() {
        return this.object;
    }

    public TileObject takeSteppedObject() {
        if (this.object != null && this.object.canBeTaken()) {
            TileObject taken = this.object;
            this.object = null;
            return taken;
        } else {
            return null;
        }
    }

    public void setObject(TileObject object) {
        this.object = object;
    }

    @Override
    public Image getImage() {
        if (this.object == null) {
            return this.image;
        } else {
            return this.object.getImage();
        }
    }
}
