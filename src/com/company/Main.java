package com.company;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // write your code here

        GestionEvenement gestionEvenement;
        gestionEvenement = new GestionEvenement();
        JFrame jFrame = new JFrame();
        jFrame.setTitle(GestionEvenement.TITRE);
        jFrame.add(gestionEvenement);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        gestionEvenement.start();
    }
}
