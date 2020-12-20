package com.company;

import java.awt.*;

public class Chat extends Rectangle {



    Chat(int chat_x, int chat_y){
        setBounds(chat_x,chat_y,16,16);
    }

    public void render(Graphics graphics, Color color){
        graphics.setColor(color);
        graphics.fillRect(x,y,16,16);
    }

}
