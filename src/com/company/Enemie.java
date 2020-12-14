package com.company;

import java.awt.*;

public class Enemie extends Rectangle {



    Enemie(int fant_x, int fant_y){
        setBounds(fant_x,fant_y,16,16);
    }

    public void render(Graphics graphics, Color color){
        graphics.setColor(color);
        graphics.fillRect(x,y,16,16);
    }

}
