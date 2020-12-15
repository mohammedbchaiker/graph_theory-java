package com.company;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Espion extends Rectangle {


	private static final long serialVersionUID = 1L;
    int pac_x,pac_y;
    String direction;
    private final Color pac_color = Color.darkGray;

    public Espion(int pac_x, int pac_y){
        this.pac_x=pac_x;
        this.pac_y=pac_y;
    }

    public void tick() throws InterruptedException {

        int timeout = 100;
        Map map = Fenetre.map;
        int pas = 16;
        if(Objects.equals(direction, "Haut") && ProchaineCaseDispo(pac_x,pac_y - pas)){
            pac_y=pac_y- pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(direction, "Bas") && ProchaineCaseDispo(pac_x,pac_y + pas)){
            pac_y=pac_y+ pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(direction, "Gauche") && ProchaineCaseDispo(pac_x - pas,pac_y)){
            pac_x=pac_x- pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(direction, "Droite") && ProchaineCaseDispo(pac_x + pas,pac_y)){
            pac_x=pac_x+ pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        Rectangle p = new Rectangle(pac_x,pac_y,16,16);


        for(int i = 0; i < map.enemies.size() ; i++){

            if (p.intersects(map.enemies.get(i))){
                System.out.println("L'espion est attrapé");
            }
            }

        }





    private boolean ProchaineCaseDispo(int x,int y){

        Rectangle caseAdjacente = new Rectangle(x,y,16,16);
        Case[][] cases = Fenetre.map.cases;

        for (Case[] aCase : cases) {
            for (int j = 0; j < cases[0].length; j++) {
                if (aCase[j] != null && aCase[j].estMur) {
                    if (caseAdjacente.intersects(aCase[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public void render(Graphics graphics){
        graphics.setColor(pac_color);

        graphics.fillRect(pac_x,pac_y, 16, 16);
    }




}
