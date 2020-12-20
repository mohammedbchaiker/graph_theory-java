package com.company;

import java.awt.*;

public class Fromage extends Rectangle {

    public Fromage(int t_x, int t_y){
        setBounds(t_x,t_y,16,16);
    }



    public void render(Graphics graphics, Color color){
            graphics.setColor(color);
            graphics.fillRect(x+3,y+3,10,10);
        }

}
