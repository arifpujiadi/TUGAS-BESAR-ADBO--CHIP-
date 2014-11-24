package tiles;

import java.awt.Image;
import tiles.Drawable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public abstract class TileObject implements Drawable {

    protected Image[] image;

    public abstract int canBeStepped();

    public abstract boolean canBeTaken();
}
