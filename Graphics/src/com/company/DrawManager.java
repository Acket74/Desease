package com.company;

import com.sun.javafx.beans.annotations.NonNull;

import javax.swing.*;
import java.awt.*;


class DrawManager extends JPanel {

    public static int SHIFT_LEFT = 20;

    public static int SHIFT_TOP = 20;

    public static int RECT_SIZE = 20;

    public static int RECTS_COUNT = 50;

    public void drawSkin(@NonNull Graphics g) {
        Color oldColor = g.getColor();
        for (int i = 0; i < RECTS_COUNT; ++i) {
            for (int j = 0; j < RECTS_COUNT; ++j) {
                g.setColor((i + j) % 2 == 0 ? new Color(255, 255, 255) : new Color(0, 0, 0));
                g.fillRect(SHIFT_LEFT + i * RECT_SIZE, SHIFT_TOP + j * RECT_SIZE, RECT_SIZE, RECT_SIZE);
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color oldColor = g2d.getColor();
        drawSkin(g);
        g2d.setColor(oldColor);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        paint(g);
    }
}

class Drawer extends JFrame {

    public Drawer() {
        initUI();
    }

    private void initUI() {
        setTitle("Desease. Booo!!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawManager());
        setSize(350, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Skin skin = DeseaseApi.initSkin();
        for(int i = 0; i < 10; ++i) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Drawer ps = new Drawer();
                    ps.setVisible(true);
                }
            });

        }
    }
}