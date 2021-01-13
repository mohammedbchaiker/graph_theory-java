package com.company;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Souris extends Rectangle {











    private static final long serialVersionUID = 1L;
    int souris_x, souris_y;
    String direction;
    private final Color souris_color = Color.darkGray;

    public Souris(int souris_x, int souris_y){
        this.souris_x = souris_x;
        this.souris_y = souris_y;
    }

    public void tick() throws InterruptedException {

        int timeout = 100;
        Map map = Fenetre.map;
        int pas = 16;
        if(Objects.equals(direction, "Haut") && ProchaineCaseDispo(souris_x, souris_y - pas)){
            souris_y = souris_y - pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(direction, "Bas") && ProchaineCaseDispo(souris_x, souris_y + pas)){
            souris_y = souris_y + pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(direction, "Gauche") && ProchaineCaseDispo(souris_x - pas, souris_y)){
            souris_x = souris_x - pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(direction, "Droite") && ProchaineCaseDispo(souris_x + pas, souris_y)){
            souris_x = souris_x + pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        Rectangle p = new Rectangle(souris_x, souris_y,16,16);

        if (p.intersects(map.fromage)){
            System.out.println("Le souris a gagné");
        }
        for(int i = 0; i < Map.chats.size() ; i++){
            if (p.intersects(Map.chats.get(i))){
                System.out.println("L'souris est attrapé");
            }
            }

        }





    private boolean ProchaineCaseDispo(int x,int y){

        Rectangle caseAdjacente = new Rectangle(x,y,16,16);
        Case[][] cases = Fenetre.map.cases;

        for (int i=0;i<cases.length;i++) {
            for (int j = 0; j < cases[0].length; j++) {
                if (cases[i][j] != null && cases[i][j].estMur) {
                    if (this.souris_x==cases[i][j].x && this.souris_y==cases[i][j].y){
                        cases[i][j].estDispo=false;
                    }
                    else {
                        cases[i][j].estDispo=true;
                    }
                    if (caseAdjacente.intersects(cases[i][j])) {
                        return false;
                    }

                }
            }
        }
        return true;
    }


    public void render(Graphics graphics){
        graphics.setColor(souris_color);

        graphics.fillRect(souris_x, souris_y, 16, 16);
    }




}
