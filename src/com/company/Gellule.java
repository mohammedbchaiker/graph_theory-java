package com.company;

import java.awt.*;

public class Gellule extends Rectangle {

    public boolean effet_gellule;
    Gellule(int g_x, int g_y, boolean effet_gellule){
            setBounds(g_x,g_y,16,16);
            this.effet_gellule=effet_gellule;
    }


    public void render(Graphics graphics){

        if (this.effet_gellule) {
            graphics.setColor(new Color(255,241,97));
            graphics.fillRect(x+5,y+5,8,8);
        }
        if(!this.effet_gellule){
            graphics.setColor(new Color(255,241,97));
            graphics.fillRect(x+5,y+5,4,4);
        }

    }

}
