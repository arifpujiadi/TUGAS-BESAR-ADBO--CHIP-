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
 * Menyimpan informasi mengenai object chip.
 * @author i08023
 */
public class Chip implements Drawable {
    
    /**
     * Menyimpan posisi chip secara horizontal.
     */
    private int x;
    
    /**
     * Menyimpan posisi chip secara vertical.
     */
    private int y;
    
    /**
     * Menyimpan status chip.<br>
     * -1: kalah<br>
     * 1: menang<br>
     * 0: masih bermain
     */
    private int win;
    
    /**
     * Menyimpan jumlah IC yang telah diambil oleh chip.
     */
    private int ICAcquired;
    
    /**
     * Menyimpan jumlah IC yang diperlukan oleh chip untuk menyelesaikan level.
     */
    private final int ICRequired;
    
    /**
     * Menyimpan warna-warna kunci. <br>
     * [0]Red<br>
     * [1]Green<br>
     * [2]Blue<br>
     * [3]Yellow
     */
    private int[] coloredKey;
    
    /**
     * Menyimpan sepatu chip. <br>
     * [0]Red <br>
     * [1]Blue
     */
    private Shoes[] shoes;
    
    /**
     * Menyimpan image gambar chip.
     */
    private Image image;
    
    /**
     * Menyimpan image gambar atas chip.
     */
    private Image up;
    
    /**
     * Menyimpan image gambar bawah chip.
     */
    private Image down;
    
    /**
     * Menyimpan image gambar kiri chip.
     */
    private Image left;
    
    /**
     * Menyimpan image gambar kanan chip.
     */
    private Image right;
    
    /**
     * Menyimpan image chip terbakar.
     */
    private Image burnt;
    
    /**
     * Attribute Image untuk gambar chip tenggelam.
     */
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

    /**
     * Memeriksa apakah chip dapat bergerak atau tidak.
     * @param object objek yang ingin diinjak
     * @param moveX perubahan x
     * @param moveY perubahan y
     * @return true jika chip dapat bergerak.
     */
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
    
    /**
     * Merubah gambar arah gerak chip.
     * @param moveX
     * @param moveY
     */
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
    
    /**
     * Menjalankan chip.
     * @param moveX perubahan x
     * @param moveY perubahan y
     */
    private void move(int moveX, int moveY) {
        this.x += moveX;
        this.y += moveY;
    }
    
    /**
     * Mendapatkan objek yang ada di tile.
     * @param object objek yang diambil di tile
     * @return object bertipe TileObject
     */
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
    
    /**
     * Mengembalikan jumlah IC yang diperoleh chip.
     * @return jumlah IC bertipe integer
     */
    public int getICAcquired() {
        return this.ICAcquired;
    }

    /**
     * Mengembalikan jumlah IC yang diperlukan.
     * @return jumlah IC bertipe integer
     */
    public int getICRequired() {
        return this.ICRequired;
    }

    /**
     * Mengembalikan warna kunci yang diperoleh chip.
     * @param color warna dari key
     * @return jumlah key yang dimiliki chip
     */
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
    
    /**
     * Warna sepatu yang diperoleh chip
     * @param color warna
     * @return true jika ada
     */
    public boolean hasShoes(Color color) {
        if (color.equals(Color.RED)) {
            return !(this.shoes[0] == null);
        } else if (color.equals(Color.BLUE)) {
            return !(this.shoes[1] == null);
        }
        return false;
    }

    /**
     * Jumlah key yang chip butuhkan.
     * @param color bertipe Color
     */
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

    /**
     * Mengembalikan posisi horizontal chip.
     * @return x bertipe integer
     */
    public int getX() {
        return x;
    }

    /**
     * Mengembalikan posisi vertical chip.
     * @return y bertipe integer
     */
    public int getY() {
        return y;
    }

    /**
     * Mengembalikan status chip.
     * @return -1 jika sudah kalah, 1 jika sudah menang, 0 jika belum keduanya
     */
    public int getCondition() {
        return this.win;
    }
    
    /**
     * Method untuk mengembalikan kondisi chip untuk melanjutkan permainan.
     */
    public void setDefaultCondition() {
        this.win = 0;
    }

    @Override
    public Image getImage() {
        return this.image;
    }
}
