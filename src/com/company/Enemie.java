package com.company;

import java.awt.*;

public class Enemie extends Rectangle {



    Enemie(int enemie_x, int enemie_y){
        setBounds(enemie_x,enemie_y,16,16);
    }

    public void render(Graphics graphics, Color color){
        graphics.setColor(color);
        graphics.fillRect(x,y,16,16);
    }

}
