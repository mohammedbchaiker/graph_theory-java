package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Map {

    public int width;
    public int height;
    ArrayList<Chat> chats;
    Case[][] cases;
    Fromage fromage;
    int[][] carte;
    ArrayList<String> direction;
    String[] strings;



    public Map(String path) throws IOException {
           BufferedImage bufferedImage = ImageIO.read(getClass().getResource(path));
           this.height = bufferedImage.getHeight();
           this.width = bufferedImage.getWidth();
           chats = new ArrayList<>();
           cases = new Case[width][height];
           carte = new int[width][height];
           direction = new ArrayList<>();


           fromage = new Fromage(0,0);
           int[] pixels = new int[width*height];
           bufferedImage.getRGB(0,0, width, height, pixels, 0, width);
        int cont =0;
           for(int i =0;i<width;i++){
               for(int j=0;j<height;j++){
                   int pixel_color = pixels[i+j*width];
                       if(pixel_color==0xFFFF0000){
                           Fenetre.souris.souris_x =i*16;
                           Fenetre.souris.souris_y =j*16;
                       }

                       else if(pixel_color == 0xFF000000){
                           cases[i][j] = new Case(i * 16, j * 16,true);
                           carte[i][j] = -1;
                       }

                       else if(pixel_color == 0xFFFF6A00){
                           chats.add(new Chat(i*16,j*16));


                      }
                      else if(pixel_color == 0xFF00FF00){
                          fromage =new Fromage(i*16,j*16);
                      }

                      else if(pixel_color == 0xFFFFFFFF) {

                          cases[i][j] = new Case(i*16,j*16,false);
                           carte[i][j] = 0;
                        //  System.out.println(cont+++" : "+cases[i][j]);
                      }
                   }
           }


    }

    public void tick()  {
        chats.get(0).tick();
        chats.get(1).tick();
        chats.get(2).tick();
        chats.get(3).tick();
    }

    public void render(Graphics graphics){
            for( int i = 0; i < width ; i++){
                for(int j =0; j<height;j++){
                    if(cases[i][j] != null && cases[i][j].estMur){
                        cases[i][j].render(graphics);
                    }
                }
            }
            fromage.render(graphics,new Color(255,215,0));
            chats.get(0).render(graphics,Color.green);
            chats.get(1).render(graphics,Color.pink);
            chats.get(2).render(graphics,Color.orange);
            chats.get(3).render(graphics,Color.red);



    }
};










