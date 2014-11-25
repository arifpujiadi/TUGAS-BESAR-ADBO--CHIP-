package level;

import tiles.*;
import java.awt.Point;
import level.Level;
import tiles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Menyimpan desain level kedua yang akan chip mainkan.
 * @author i08023
 */
public class Level2 extends Level {

    public Level2() {
        this.initializeLevel();
        this.message = new String[2];
        message[0] = "YOU WIN";
        message[1] = "Tekan spasi untuk ke level selanjutnya";
    }

    @Override
    public void initializeLevel() {
        this.width = 25;
        this.length = 25;
        this.ICRequired = 9;
        this.tiles = new Tile[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
        createMap();
    }

    @Override
    protected void createMap() {
        //horizontalWall
        for (int i = 9; i <= 15; i++) {
            this.tiles[3][i].setObject(this.wall);
        }
        for (int i = 3; i <= 21; i++) {
            this.tiles[9][i].setObject(this.wall);
        }
        for (int i = 3; i <= 21; i++) {
            this.tiles[15][i].setObject(this.wall);
        }
        for (int i = 9; i <= 15; i++) {
            this.tiles[21][i].setObject(this.wall);
        }
        
        //finishWall
        for (int i = 4; i <= 5; i++) {
            this.tiles[11][i].setObject(this.wall);
        }
        for (int i = 4; i <= 5; i++) {
            this.tiles[13][i].setObject(this.wall);
        }
        
        //verticalWall
        for (int i = 9; i <= 15; i++) {
            this.tiles[i][3].setObject(this.wall);
        }
        for (int i = 3; i <= 21; i++) {
            this.tiles[i][9].setObject(this.wall);
        }
        for (int i = 3; i <= 21; i++) {
            this.tiles[i][15].setObject(this.wall);
        }
        for (int i = 9; i <= 15; i++) {
            this.tiles[i][21].setObject(this.wall);
        }
        
        
        //Barrier
        this.tiles[12][5].setObject(this.barrier);
        
        //Finish
        this.tiles[12][4].setObject(new Finish());
        
        
        //Door
        this.tiles[12][9].setObject(this.blueDoor);
        this.tiles[9][12].setObject(this.greenDoor);
        this.tiles[12][15].setObject(this.yellowDoor);
        this.tiles[15][12].setObject(this.redDoor);
        
        
        //key
        this.tiles[5][12].setObject(this.blueKey);
        this.tiles[20][10].setObject(this.greenKey);
        this.tiles[14][8].setObject(this.yellowKey);
        this.tiles[14][10].setObject(this.redKey);
        
        
        //Fire
        for (int i = 10; i <= 14; i++) {
            this.tiles[i][7].setObject(new Fire());
        }
        this.tiles[11][8].setObject(new Fire());
        for (int i = 10; i <= 11; i++) {
            this.tiles[19][i].setObject(new Fire());
        }
        for (int i = 17; i <= 18; i++) {
            this.tiles[i][12].setObject(new Fire());
        }
        this.tiles[16][14].setObject(new Fire());
        this.tiles[11][18].setObject(new Fire());
        
        
        
        //Water
        for (int i = 5; i <= 7; i++) {
            this.tiles[i][11].setObject(new Water());
        }
        for (int i = 6; i <= 7; i++) {
            this.tiles[i][12].setObject(new Water());
        }
        for (int i = 4; i <= 7; i++) {
            this.tiles[i][13].setObject(new Water());
        }
        for (int i = 11; i <= 13; i++) {
            this.tiles[i][17].setObject(new Water());
        }
        for (int i = 10; i <= 11; i++) {
            this.tiles[i][19].setObject(new Water());
        }
        for (int i = 18; i <= 19; i++) {
            this.tiles[13][i].setObject(new Water());
        }
        
        
        //IC
        this.tiles[10][8].setObject(this.IC);
        this.tiles[4][14].setObject(this.IC);
        this.tiles[10][20].setObject(this.IC);
        this.tiles[18][10].setObject(this.IC);
        this.tiles[18][11].setObject(this.IC);
        this.tiles[19][12].setObject(this.IC);
        this.tiles[10][10].setObject(this.IC);
        this.tiles[10][14].setObject(this.IC);
        this.tiles[14][14].setObject(this.IC);
        
        //shoes
        this.tiles[12][18].setObject(this.redShoes);
    }

    @Override
    public Point getInitialChipCoordinate() {
        return new Point(12, 12);
    }

    @Override
    public String[] getMessage() {
        return message;
    }

    @Override
    public int getLevelName() {
        return 2;
    }
}
