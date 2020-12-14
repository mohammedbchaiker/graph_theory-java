package com.company;

import java.awt.*;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Pacman extends Rectangle {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    int pac_x,pac_y;
    public boolean haut,bas,droite,gauche;
    String directiron;
    private boolean effetGellule;
    private Color pac_color = Color.yellow;
    private boolean estPuissant;



    public Pacman(int pac_x,int pac_y){
        this.pac_x=pac_x;
        this.pac_y=pac_y;
    }

    public void tick() throws InterruptedException {

        int timeout = 100;
        Conteneur conteneur = GestionEvenement.conteneur;
        int pas = 16;
        if(Objects.equals(directiron, "Haut") && ProchaineCaseDispo(pac_x,pac_y - pas)){
            pac_y=pac_y- pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(directiron, "Bas") && ProchaineCaseDispo(pac_x,pac_y + pas)){
            pac_y=pac_y+ pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(directiron, "Gauche") && ProchaineCaseDispo(pac_x - pas,pac_y)){
            pac_x=pac_x- pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        if(Objects.equals(directiron, "Droite") && ProchaineCaseDispo(pac_x + pas,pac_y)){
            pac_x=pac_x+ pas;
            TimeUnit.MILLISECONDS.sleep(timeout);
        }

        Rectangle p = new Rectangle(pac_x,pac_y,16,16);

        for (int i=0;i<conteneur.gellules.size();i++){
            if(p.intersects(conteneur.gellules.get(i))){
                if (conteneur.gellules.get(i).effet_gellule) {
                    effetGellule = true;
                    setEstPuissant();
                }
                conteneur.gellules.remove(i);
                break;
            }
        }
        if (conteneur.gellules.size()==0){
            System.out.println("Pac-Man a gagné");
        }
        for(int i = 0; i < conteneur.fantomes.size() ; i++){

            if (p.intersects(conteneur.fantomes.get(i))){
                System.out.println("Pac-Man est Mort");
            }
            if (estPuissant && p.intersects(conteneur.fantomes.get(i))){
                System.out.println("Fantome N° "+i+" est Mort");
                conteneur.fantomes.remove(i);
                break;
                }




            }

        }


    private void setEstPuissant() {

        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                estPuissant = false;
                pac_color = Color.yellow;
                System.out.println("Pac-Man pas puissant");
            }
        },5000);
        pac_color = new Color(153,10,255);
        estPuissant = true;
        System.out.println("Pac-Man puissant");





    }


    private boolean ProchaineCaseDispo(int x,int y){

        Rectangle caseAdjacente = new Rectangle(x,y,16,16);
        Case[][] cases = GestionEvenement.conteneur.cases;

        for (Case[] aCase : cases) {
            for (int j = 0; j < cases[0].length; j++) {
                if (aCase[j] != null) {
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
