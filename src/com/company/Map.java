package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

    public void exec(){

        Case c = new Case(16,256,false);
        Case c2 = new Case(320,19*16, false);

        CalculateurDeChemin m = new CalculateurDeChemin(rotate(carte), 1,1,8,3);
        m.bfs();
        System.out.println(Arrays.deepToString(rotate(carte)));
     //   System.out.println(m.chemin.size());
        direction.clear();

        for(int i=1;i<m.chemin.size()-1;i++){
            if (m.chemin.get(i).getX()>m.chemin.get(i+1).getX()){
                direction.add("HAUT");
            }
            if (m.chemin.get(i).getX()<m.chemin.get(i+1).getX()){
                direction.add("BAS");
            }
            if (m.chemin.get(i).getY()>m.chemin.get(i+1).getY()){
                direction.add("GAUCHE");
            }
            if (m.chemin.get(i).getY()<m.chemin.get(i+1).getY()){
                direction.add("DROITE");
            }


        }
    }
    int [][] rotate(int [][] input){

        int n =input.length;
        int m = input[0].length;
        int [][] output = new int [m][n];

        for (int i=0; i<n; i++)
            for (int j=0;j<m; j++)
                output [j][n-1-i] = input[i][j];
        return output;
    }
    public void tick() throws InterruptedException {
        for(Chat chat :chats){
            chat.tick();
        }
    }

    public void render(Graphics graphics){
     //   System.out.println(Arrays.deepToString(rotate(carte)));
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










