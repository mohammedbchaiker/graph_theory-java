package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

public class Map {

    public int width;
    public int height;
    ArrayList<Enemie> enemies;
    Case[][] cases;
    Tresor tresor;
    ArrayList<Case> chemin;



    public Map(String path) throws IOException {
           BufferedImage bufferedImage = ImageIO.read(getClass().getResource(path));
           this.height = bufferedImage.getHeight();
           this.width = bufferedImage.getWidth();
           enemies = new ArrayList<>();
           chemin = new ArrayList<>();
           cases = new Case[width][height];
           tresor = new Tresor(0,0);
           int[] pixels = new int[width*height];
           bufferedImage.getRGB(0,0, width, height, pixels, 0, width);
        int cont =0;
           for(int i =0;i<width;i++){
               for(int j=0;j<height;j++){
                   int pixel_color = pixels[i+j*width];
                       if(pixel_color==0xFFFF0000){
                           Fenetre.espion.pac_x=i*16;
                           Fenetre.espion.pac_y=j*16;
                       }

                       else if(pixel_color == 0xFF000000){
                           cases[i][j] = new Case(i * 16, j * 16,true);
                       }

                       else if(pixel_color == 0xFFFF6A00){
                           enemies.add(new Enemie(i*16,j*16));


                      }
                      else if(pixel_color == 0xFF00FF00){
                          tresor=new Tresor(i*16,j*16);
                          System.out.println("done");
                      }

                      else if(pixel_color == 0xFFFFFFFF) {

                          cases[i][j] = new Case(i*16,j*16,false);
                        //  System.out.println(cont+++" : "+cases[i][j]);
                      }
                   }
           }


    }











    public void render(Graphics graphics){
        /*
        System.out.println(height+"  "+width);
        for( int row = 0; row < height ; row++){
            System.out.println("");
            for(int col =0; col<width;col++){
                if(cases[col][row] != null && cases[col][row].estMur){
                    System.out.print(" (|) ");
                }
                if(cases[col][row] != null && !cases[col][row].estMur){
                    System.out.print(" () ");
                }
            }
        }*/

        for( int i = 0; i < width ; i++){
            for(int j =0; j<height;j++){
                if(cases[i][j] != null && cases[i][j].estMur){
                    cases[i][j].render(graphics);
                }
            }
        }
     /*   int cont=0;
        for( int i = 0; i < width ; i++){
            for(int j =0; j<height;j++){
                if(cases[i][j] != null){
                    System.out.println(cont+++" : "+cases[i][j]);

                }
            }
        }*/



        tresor.render(graphics,new Color(255,215,0));


        for (Enemie enemy : enemies) {
            enemy.render(graphics, new Color(255, 0, 58));
        }



    }



}
