package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    public int width;
    public int height;
    ArrayList<Enemie> enemies;
    Case[][] cases;
    Tresor tresor;



    public Map(String path) throws IOException {
           BufferedImage bufferedImage = ImageIO.read(getClass().getResource(path));
           this.height = bufferedImage.getHeight();
           this.width = bufferedImage.getWidth();
           enemies = new ArrayList<>();
           cases = new Case[width][height];
           tresor = new Tresor(0,0);
           int[] pixels = new int[width*height];
           bufferedImage.getRGB(0,0, width, height, pixels, 0, width);

           for(int i =0;i<width;i++){
               for(int j=0;j<height;j++){
                   int pixel_color = pixels[i+j*width];
                      if(pixel_color==0xFFFF0000){
                           Fenetre.espion.pac_x=i*16;
                           Fenetre.espion.pac_y=j*16;
                       }

                       else if(pixel_color == 0xFF000000){
                           cases[i][j] = new Case(i * 16, j * 16);
                       }

                       else if(pixel_color == 0xFFFF6A00){
                           enemies.add(new Enemie(i*16,j*16));
                        //  System.out.println("done");

                      }
                      else if(pixel_color == 0xFF00FF00){
                          tresor=new Tresor(i*16,j*16);
                          System.out.println("done");
                      }
                   }
           }


    }

    public void render(Graphics graphics){
        for( int i = 0; i < width ; i++){
            for(int j =0; j<height;j++){
                if(cases[i][j] != null){
                    cases[i][j].render(graphics);
                }
            }
        }


        tresor.render(graphics,new Color(255,215,0));


       for (int i=0;i<enemies.size();i++){
           enemies.get(i).render(graphics, new Color(255,0,58));
       }



    }

}
