package com.company;

import java.awt.*;

public class Case extends Rectangle {
    int x;
    int y;
    public boolean estMur;
    public Case(int case_x,int case_y, boolean estMur){
        x=case_x;
        y=case_y;
        setBounds(case_x,case_y,16,16);
        this.estMur = estMur;
    }


    public void render(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.fillRect(x,y,width,height);
    }
}
