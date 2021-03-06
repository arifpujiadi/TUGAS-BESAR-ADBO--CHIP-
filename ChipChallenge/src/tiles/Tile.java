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
/**
 * Menyimpan informasi mengenai object tile.
 * @author i08023
 */
public class Tile implements Drawable {

    /**
     * posisi horizontal.
     */
    private int x;
    
    /**
     * posisi vertical.
     */
    private int y;
    
    /**
     * Objek yang berada di atas lantai.
     */
    private TileObject object;
    
    /**
     * menyimpan gambar.
     */
    private Image image;

    public Tile() {
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("images/tile.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Mengembalikan object yang ditaruh di lantai.
     * @return object bertipe TileObject
     */
    public TileObject getWhatIsStepped() {
        return this.object;
    }

    /**
     * Mengembalikan objek yang ditaruh di lantai jika objek tersebut dapat diambil.
     * @return TileObject
     */
    public TileObject takeSteppedObject() {
        if (this.object != null && this.object.canBeTaken()) {
            TileObject taken = this.object;
            this.object = null;
            return taken;
        } else {
            return null;
        }
    }

    /**
     * Untuk mengeset object yang akan di taruh di dalam tile.
     * @param object bertipe TileObject
     */
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
