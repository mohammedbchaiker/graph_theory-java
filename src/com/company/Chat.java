package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;


public class Chat extends Rectangle  {


    int chat_x,chat_y;
    int [][] carte={{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, -1, 0, -1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, 0, -1, 0, -1, -1, 0, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, -1, -1, 0, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, 0, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, -1, -1, 0, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, 0, -1, -1, -1, -1, 0, -1, 0, -1},
            {-1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1},
            {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 0, -1, 0, -1, -1, -1, 0, 0, 0, -1, -1, -1, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1},
            {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
    ArrayList<String> direction;
    Map map = Fenetre.map;

    Chat(int chat_x, int chat_y){
        this.chat_x=chat_x;
        this.chat_y=chat_y;
        direction = new ArrayList<>();
        setBounds(chat_x,chat_y,16,16);

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


    public void wait(int sec) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void exec(){
        CalculateurDeChemin m = new CalculateurDeChemin(rotate(carte), this.chat_x,this.chat_y, Fenetre.souris.souris_x,Fenetre.souris.souris_y);
        m.rechercheEnLargeur();
        System.out.println(m.chemin.size());
        direction.clear();

        for(int i=1;i<m.chemin.size()-1;i++){
            if (m.chemin.get(i).getX()>m.chemin.get(i+1).getX()){
                direction.add("GAUCHE");
            }
            if (m.chemin.get(i).getX()<m.chemin.get(i+1).getX()){
                direction.add("DROITE");
            }
            if (m.chemin.get(i).getY()>m.chemin.get(i+1).getY()){
                direction.add("HAUT");
            }
            if (m.chemin.get(i).getY()<m.chemin.get(i+1).getY()){
                direction.add("BAS");
            }

        }
    }







    public void deplacer(String direction) throws InterruptedException {
        int pas = 16;
        if(Objects.equals(direction, "HAUT")&& ProchaineCaseDispo(this.chat_x, this.chat_y - pas) && ProchaineCaseVide(this.chat_x, this.chat_y - pas) ){
          this.chat_y = this.chat_y - pas;
        }

        if(Objects.equals(direction, "BAS")&& ProchaineCaseDispo(this.chat_x, this.chat_y + pas) && ProchaineCaseVide(this.chat_x, this.chat_y + pas)){
                 this.chat_y = this.chat_y + pas;
        }

        if(Objects.equals(direction, "GAUCHE")&& ProchaineCaseDispo(this.chat_x - pas, this.chat_y)&& ProchaineCaseVide(this.chat_x - pas, this.chat_y) ){
                 this.chat_x = this.chat_x - pas;
        }

        if(Objects.equals(direction, "DROITE")&& ProchaineCaseDispo(this.chat_x + pas, this.chat_y)&& ProchaineCaseVide(this.chat_x + pas, this.chat_y)){
                 this.chat_x = this.chat_x + pas;
        }


    }

    public boolean ProchaineCaseVide(int x, int y){
        Case[][] cases = Fenetre.map.cases;

        for (int i=0;i<cases.length;i++) {
            for (int j = 0; j < cases[0].length; j++) {
                if (cases[i][j]!=null){
                    if (this.chat_x==cases[i][j].x && this.chat_y==cases[i][j].y ){
                        cases[i][j].estDispo=false;
                    }
                    else {
                        cases[i][j].estDispo=true;

                    }
                }

            }}
        if (cases[x/16][y/16].estDispo){
            return true;
        }
        else return false;

    }


    private boolean ProchaineCaseDispo(int x,int y){

        Rectangle caseAdjacente = new Rectangle(x,y,16,16);
        Case[][] cases = Fenetre.map.cases;

        for (int i=0;i<cases.length;i++) {
            for (int j = 0; j < cases[0].length; j++) {
                if (cases[i][j] != null && cases[i][j].estMur) {
                    if (caseAdjacente.intersects(cases[i][j])) {
                        return false;
                    }

                }
            }
        }
        return true;
    }


    public void tick() throws InterruptedException {
            exec();

        if (!direction.isEmpty()){
            for (String s : direction) {
                deplacer(s);
            }
        }

    }



    public void render(Graphics graphics, Color color){
        graphics.setColor(color);
        graphics.fillRect(this.chat_x,this.chat_y,16,16);
    }




}
