package gui;

import board.Board;
import java.awt.*;
import java.util.logging.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Gui extends JPanel {

    private final Board board = new Board();
    private final int tileSize;
    private static int WINDOWSIZE_WIDTH = 648;
    private static int WINDOWSIZE_HEIGHT = 460;

    public Gui() {
        setBackground(Color.black);
        setFocusable(true);
        KeyListener listener = new KeyListener();
        addKeyListener(listener);
        this.tileSize = 48;
    }

    private class KeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent evt) {
            if (board.getCondition() == 0) {
                if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_A) {
                    board.move("a");
                } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_D) {
                    board.move("d");
                } else if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_S) {
                    board.move("s");
                } else if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_W) {
                    board.move("w");
                }
            } else if (board.getCondition() == 1) {
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                    board.getNextLevel();
                }
            } else if (board.getCondition() == -1) {
                if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                    board.reset();
                }
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                g2d.drawImage(this.board.getArrayOfTile()[i + (this.board.getChip().getX() - 4)][j + (this.board.getChip().getY() - 4)].getImage(), i * tileSize, j * tileSize, this);
            }
        }
        g2d.drawImage(board.getChip().getImage(), 192, 192, this);
        if (this.board.getCondition() != 0) {
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 48));
            if (this.board.getCondition() == 1) {
                g2d.drawString("YOU WIN!", getWidth() / 4, getHeight() / 2);
            } else {
                g2d.drawString("YOU LOSE!", getWidth() / 4, getHeight() / 2);
            }
        }

        try {
            Thread.sleep(45);
        } catch (InterruptedException ex) {
            Logger.getLogger(gui.Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame game = new JFrame();
        game.setTitle("Chip's Challenge");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(WINDOWSIZE_WIDTH, WINDOWSIZE_HEIGHT);
        game.setResizable(false);
        game.add(new gui.Gui());
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
