package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    public int width;
    public int height;
    ArrayList<Chat> chats;
    Case[][] cases;
    Fromage fromage;
    int[][] carte;



    public Map(String path) throws IOException {
           BufferedImage bufferedImage = ImageIO.read(getClass().getResource(path));
           this.height = bufferedImage.getHeight();
           this.width = bufferedImage.getWidth();
           chats = new ArrayList<>();
           cases = new Case[width][height];
           carte = new int[width][height];

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



    Case c = new Case(16,256,false);
    Case c2 = new Case(320,19*16, false);

    int [][] rotate(int [][] input){

        int n =input.length;
        int m = input[0].length;
        int [][] output = new int [m][n];

        for (int i=0; i<n; i++)
            for (int j=0;j<m; j++)
                output [j][n-1-i] = input[i][j];
        return output;
    }

    public void render(Graphics graphics){



        CalculateurDeChemin m = new CalculateurDeChemin(rotate(carte), 1,1,8,3);
        m.bfs();
        m.print(rotate(carte));
        System.out.println("---------------------------"+m.chemin.size());

            for( int i = 0; i < width ; i++){
                for(int j =0; j<height;j++){
                    if(cases[i][j] != null && cases[i][j].estMur){
                        cases[i][j].render(graphics);
                    }
                }
            }



            fromage.render(graphics,new Color(255,215,0));


            for (Chat chat : chats) {
                chat.render(graphics, Color.blue);
            }



        }




};










