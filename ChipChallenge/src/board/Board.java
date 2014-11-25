package board;

import level.*;
import tiles.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Kelas ini berfungsi untuk mengatur tampilan permainan.
 * @author i08023
 */
public class Board {
    
    /**
     * Menyimpan tiles.
     */
    private Tile[][] tiles;
    
    /**
     * Menyimpan lebar board.
     */
    private int width;
    
    /**
     * Menyimpan panjang board.
     */
    private int length;
    
    /**
     * Menyimpan panjang board.
     */
    private Chip chip;
    
    /**
     * Menyimpan jumlah IC yang diperlukan.
     */
    private int ICRequired;
    
    /**
     * Menyimpan objek Level untuk menentukan level setiap board.
     */
    private Levels level;
    
    /**
     * Menyimpan benda-benda yang diambil oleh chip.
     */
    private Tile[][] inven;
    
    /**
     * Menyimpan informasi posisi level chip
     */
    private int iLevel;

    public Board() {
        this.inven = new Tile[4][2];
        for (int i = 0; i < inven.length; i++) {
            for (int j = 0; j < inven[i].length; j++) {
                inven[i][j] = new Tile();
            }
        }
        this.iLevel = 1;
        this.level = new Levels();
        this.set();
    }
    
    /**
     * Mengembalikan array of tile di dalam board.
     * @return array dua dimensi berisi objek Tile.
     */
    public Tile[][] getArrayOfTile() {
        return this.tiles;
    }
    
    /**
     * Mengembalikan panjang dari board.
     * @return panjang board bertipe integer
     */
    public int getLength() {
        return this.length;
    }
    
    /**
     * Mengembalikan panjang dari board.
     * @return panjang board bertipe integer
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Mengatur arah Chip bergerak sesuai dengan input dari keyboard. <br>
     * w untuk keatas <br>
     * a untuk kekiri <br>
     * d untuk kekanan <br>
     * s untuk kebawah
     * @param dir bertipe string
     */
    public void move(String dir) {
        Tile steppedTile;
        TileObject steppedObject;
        boolean canMove;
        TileObject takenObject;

        if (dir.equals("a")) {
            steppedTile = this.tiles[this.chip.getX() - 1][this.chip.getY()];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), -1, 0);
        } else if (dir.equals("d")) {
            steppedTile = this.tiles[this.chip.getX() + 1][this.chip.getY()];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 1, 0);
        } else if (dir.equals("w")) {
            steppedTile = this.tiles[this.chip.getX()][this.chip.getY() - 1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 0, -1);
        } else {
            steppedTile = this.tiles[this.chip.getX()][this.chip.getY() + 1];
            canMove = this.chip.move(steppedTile.getWhatIsStepped(), 0, 1);
        }

        if (canMove) {
            takenObject = this.chip.takeObject(steppedTile.takeSteppedObject());
            if (takenObject != null) {
                if (takenObject.getClass().equals(Key.class)) {
                    Key keyObj = (Key) takenObject;
                    if (keyObj.getColor().equals(Color.RED)) {
                        this.inven[0][0].setObject(takenObject);
                    } else if (keyObj.getColor().equals(Color.GREEN)) {
                        this.inven[1][0].setObject(takenObject);
                    } else if (keyObj.getColor().equals(Color.BLUE)) {
                        this.inven[2][0].setObject(takenObject);
                    } else {
                        this.inven[3][0].setObject(takenObject);
                    }
                } else if (takenObject.getClass().equals(Shoes.class)) {
                    Shoes shoesObj = (Shoes) takenObject;
                    if (shoesObj.getColor().equals(Color.RED)) {
                        this.inven[0][1].setObject(takenObject);
                    } else if (shoesObj.getColor().equals(Color.BLUE)) {
                        this.inven[1][1].setObject(takenObject);
                    }
                }
            }
        }
    }
    
    /**
     * Mengembalikan kondisi Chip <br>
     * 0 - permainan masih berjalan <br>
     * -1 - kalah <br>
     * 1 - menang
     * @return kondisi Chip bertipe integer
     */
    public int getCondition() {
        return this.chip.getCondition();
    }
    
    /**
     * Mengembalikan object chip.
     * @return Chip
     */
    public Chip getChip() {
        return this.chip;
    }
    
    /**
     * Method untuk pindah ke level selanjutnya.
     */
    public void getNextLevel() {
        if (this.level.goToTheNextLevel()) {
            this.set();
            iLevel++;
        }
    }
    
    /**
     * Method untuk menginisialisasi atribut-atribut yang dimiliki oleh board.
     */
    public void set() {
        this.width = level.getWidth();
        this.length = level.getLength();
        this.ICRequired = this.level.getICRequired();
        this.chip = new Chip(this.level.getInitialChipCoordinate().x, this.level.getInitialChipCoordinate().y, this.ICRequired);
        this.tiles = this.level.getMap();
    }
    
    /**
     * Method untuk mengulangi level saat ini.
     */
    public void reset() {
        this.level.resetLevel();
        this.set();
    }
    
    /**
     * Mengembalikan isi inventori yang disimpan oleh chip.
     * @return inven bertipe array
     */
    public Tile[][] getInven() {
        return inven;
    }
    
    /**
     * Memastikan game sudah berakhir.
     * @return true jika level terakhir dan menang, false jika belum berakhir
     */
    public boolean endGame() {
        return this.getCondition() == 1 && this.getLevel().endLevel();
    }
    
    /**
     * Mengembalikan posisi level chip berada.
     * @return nilai integer yang berisi keterangan level saat ini 
     */
    public int getIndexLevel() {
        return this.iLevel;
    }
    
    /**
     * Mengosongkan inventori saat level dimulai.
     */
    public void clearInven() {
        for (int i = 0; i < this.inven.length; i++) {
            for (int j = 0; j < this.inven[0].length; j++) {
                this.inven[i][j].takeSteppedObject();
            }
        }
    }
    
    /**
     * Untuk mengembalikan objek level.
     * @return objek level saat ini
     */
    public Levels getLevel() {
        return level;
    }
}
