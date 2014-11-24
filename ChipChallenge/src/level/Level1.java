package level;

import tiles.Water;
import tiles.Tile;
import tiles.Fire;
import tiles.Finish;
import java.awt.Point;
import level.Level;
import tiles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Level1 extends Level {

    public Level1() {
        this.initializeLevel();
    }

    @Override
    public void initializeLevel() {
        this.width = 25;
        this.length = 25;
        this.ICRequired = 13;
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
        this.tiles[10][10].setObject(this.blueKey);
        this.tiles[14][4].setObject(this.greenKey);
        this.tiles[8][14].setObject(this.yellowKey);
        this.tiles[14][20].setObject(this.redKey);

        //water
        this.tiles[11][6].setObject(new Water());
        for (int i = 6; i <= 7; i++) {
            this.tiles[13][i].setObject(new Water());
        }
        for (int i = 10; i <= 11; i++) {
            this.tiles[i][8].setObject(new Water());
        }
        for (int i = 12; i <= 14; i++) {
            this.tiles[i][18].setObject(new Water());
        }
        this.tiles[11][16].setObject(new Water());
        this.tiles[13][16].setObject(new Water());
        this.tiles[11][20].setObject(new Water());
        this.tiles[13][20].setObject(new Water());
        this.tiles[10][18].setObject(new Water());

        //fire
        for (int i = 5; i <= 7; i++) {
            this.tiles[i][11].setObject(new Fire());
        }
        for (int i = 6; i <= 8; i++) {
            this.tiles[i][13].setObject(new Fire());
        }
        this.tiles[6][12].setObject(new Fire());
        this.tiles[4][13].setObject(new Fire());

        //IC
        this.tiles[10][4].setObject(this.IC);
        this.tiles[4][10].setObject(this.IC);
        this.tiles[7][12].setObject(this.IC);
        this.tiles[4][14].setObject(this.IC);
        this.tiles[10][20].setObject(this.IC);
        this.tiles[17][11].setObject(this.IC);
        this.tiles[19][11].setObject(this.IC);
        this.tiles[18][12].setObject(this.IC);
        this.tiles[17][13].setObject(this.IC);
        this.tiles[19][13].setObject(this.IC);
        this.tiles[14][10].setObject(this.IC);
        this.tiles[14][14].setObject(this.IC);
        this.tiles[10][14].setObject(this.IC);
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
        return 1;
    }
}
