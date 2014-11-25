package tiles;

import tiles.Chip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sebuah interface yang berfungsi untuk melakukan pemeriksaan terhadap kondisi chip.
 * @author i08023
 */
public interface Conditional {
    
    /**
     * Memeriksa apakah persyaratan-persyaratan sudah terpenuhi atau belum.
     * @param chip player
     * @return true jika sudah, false jika sebaliknya
     */
    public boolean check(Chip chip);
}
