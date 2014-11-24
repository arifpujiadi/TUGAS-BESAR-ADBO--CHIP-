package board;

import tiles.TileObject;
import tiles.Tile;
import tiles.Chip;
import level.Levels;
import level.*;
import tiles.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Board {

    private Tile[][] tiles;
    private int width;
    private int length;
    private Chip chip;
    private int ICRequired;
    private Levels level;
    private int iLevel;

    public Board() {
        this.iLevel = 1;
        this.level = new Levels();
        this.set();
    }

    public Tile[][] getArrayOfTile() {
        return this.tiles;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public void move(String dir) {
        Tile steppedTile;
        TileObject steppedObject;
        boolean canMove;

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
            this.chip.takeObject(steppedTile.takeSteppedObject());
        }
    }

    public int getCondition() {
        return this.chip.getCondition();
    }

    public Chip getChip() {
        return this.chip;
    }

    public void getNextLevel() {
        if (this.level.goToTheNextLevel()) {
            this.set();
        }
    }

    public void set() {
        this.width = level.getWidth();
        this.length = level.getLength();
        this.ICRequired = this.level.getICRequired();
        this.chip = new Chip(this.level.getInitialChipCoordinate().x, this.level.getInitialChipCoordinate().y, this.ICRequired);
        this.tiles = this.level.getMap();
    }

    public void reset() {
        this.level.resetLevel();
        this.set();
    }
    
    public boolean endGame() {
        return this.getCondition() == 1 && this.getLevel().endLevel();
    }
    
    public int getIndexLevel() {
        return this.iLevel;
    }
    
    public Levels getLevel() {
        return level;
    }
}
