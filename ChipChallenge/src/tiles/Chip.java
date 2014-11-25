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
public class Chip implements Drawable {

    private int x;
    private int y;
    private int win;
    private int ICAcquired;
    private final int ICRequired;
    private int[] coloredKey;
    private Shoes[] shoes;
    private Image image;
    private Image up;
    private Image down;
    private Image left;
    private Image right;
    private Image burnt;
    private Image drown;

    public Chip(int x, int y, int ICRequired) {
        this.x = x;
        this.y = y;
        this.ICAcquired = 0;
        this.ICRequired = ICRequired;
        this.win = 0;
        this.coloredKey = new int[4];
        this.shoes = new Shoes[2];

        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("images/chip_down2.png"));
            this.up = ImageIO.read(getClass().getClassLoader().getResource("images/chip_up1.png"));
            this.down = ImageIO.read(getClass().getClassLoader().getResource("images/chip_down1.png"));
            this.left = ImageIO.read(getClass().getClassLoader().getResource("images/chip_left1.png"));
            this.right = ImageIO.read(getClass().getClassLoader().getResource("images/chip_right1.png"));
            this.burnt = ImageIO.read(getClass().getClassLoader().getResource("images/chip_burnt.png"));
            this.drown = ImageIO.read(getClass().getClassLoader().getResource("images/chip_drown.png"));
        } catch (IOException ex) {
            Logger.getLogger(Chip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean move(TileObject object, int moveX, int moveY) {
        this.changeDirection(moveX, moveY);
        if (object != null && object.canBeStepped() == -1) {
            return false;
        } else {
            if (object == null) {
                this.move(moveX, moveY);
            } else {
                if (object.canBeStepped() == 0) {
                    this.move(moveX, moveY);
                } else if (object.canBeStepped() == 1) {
                    this.move(moveX, moveY);
                    if (object.getClass().equals(Fire.class)) {
                        if (!((Fire) object).check(this)) {
                            this.image = this.burnt;
                            this.win = -1;
                        }
                    } else if (object.getClass().equals(Water.class)) {
                        if (!((Water) object).check(this)) {
                            this.image = this.drown;
                            this.win = -1;
                        }
                    }
                } else if (object.canBeStepped() == 2) {
                    this.move(moveX, moveY);
                    this.win = 1;
                } else if (object.canBeStepped() == 3) {
                    if (object.getClass().equals(Barrier.class)) {
                        if (((Barrier) object).check(this)) {
                            this.move(moveX, moveY);
                        } else {
                            return false;
                        }
                    } else {
                        if (((Door) object).openDoor(this)) {
                            this.move(moveX, moveY);
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    private void changeDirection(int moveX, int moveY) {
        if (moveX > 0) {
            this.image = right;
        } else if (moveX < 0) {
            this.image = left;
        } else if (moveY > 0) {
            this.image = down;
        } else if (moveY < 0) {
            this.image = up;
        }
    }

    private void move(int moveX, int moveY) {
        this.x += moveX;
        this.y += moveY;
    }

    public TileObject takeObject(TileObject object) {
        if (object != null) {
            if (object.getClass().equals(IC.class)) {
                this.ICAcquired++;
            } else if (object.getClass().equals(Key.class)) {
                Key keyObj = (Key) object;
                if (keyObj.getColor().equals(Color.RED)) {
                    this.coloredKey[0]++;
                } else if (keyObj.getColor().equals(Color.GREEN)) {
                    this.coloredKey[1]++;
                } else if (keyObj.getColor().equals(Color.BLUE)) {
                    this.coloredKey[2]++;
                } else if (keyObj.getColor().equals(Color.YELLOW)) {
                    this.coloredKey[3]++;
                }
            } else if (object.getClass().equals(Shoes.class)) {
                Shoes shoesObj = (Shoes) object;
                if (shoesObj.getColor().equals(Color.RED)) {
                    this.shoes[0] = shoesObj;
                } else if (shoesObj.getColor().equals(Color.BLUE)) {
                    this.shoes[1] = shoesObj;
                }
            }
        }
        return object;
    }

    public int getICAcquired() {
        return this.ICAcquired;
    }

    public int getICRequired() {
        return this.ICRequired;
    }

    public int getColoredKeyAcquired(Color color) {
        if (color.equals(Color.RED)) {
            return this.coloredKey[0];
        } else if (color.equals(Color.GREEN)) {
            return this.coloredKey[1];
        } else if (color.equals(Color.BLUE)) {
            return this.coloredKey[2];
        } else if (color.equals(Color.YELLOW)) {
            return this.coloredKey[3];
        }
        return 0;
    }

    public boolean hasShoes(Color color) {
        if (color.equals(Color.RED)) {
            return !(this.shoes[0] == null);
        } else if (color.equals(Color.BLUE)) {
            return !(this.shoes[1] == null);
        }
        return false;
    }

    public void useKey(Color color) {
        if (color.equals(Color.RED)) {
            this.coloredKey[0]--;
        } else if (color.equals(Color.GREEN)) {
            this.coloredKey[1]--;
        } else if (color.equals(Color.BLUE)) {
            this.coloredKey[2]--;
        } else if (color.equals(Color.YELLOW)) {
            this.coloredKey[3]--;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCondition() {
        return this.win;
    }

    public void setDefaultCondition() {
        this.win = 0;
    }

    @Override
    public Image getImage() {
        return this.image;
    }
}
