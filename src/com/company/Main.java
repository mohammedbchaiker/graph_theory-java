package com.company;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here

        Fenetre fenetre;
        fenetre = new Fenetre();
        JFrame jFrame = new JFrame();
        jFrame.setTitle(Fenetre.TITRE);
        jFrame.add(fenetre);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        fenetre.start();
    }
}
