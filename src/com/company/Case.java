package com.company;

import java.awt.*;

public class Case extends Rectangle {

    public Case(int case_x,int case_y){
        setBounds(case_x,case_y,16,16);
    }


    public void render(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.fillRect(x,y,width,height);
    }
}
