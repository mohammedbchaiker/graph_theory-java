package com.company;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Fenetre extends Canvas implements Runnable, KeyListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Thread thread;
	private boolean isRunning = false;


    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    static final String TITRE ="Pac-Man";
    public static Espion espion;
    public static Tresor tresor;
    static Map map;

    public Fenetre() throws IOException {
        Dimension dimension = new Dimension(Fenetre.WIDTH, Fenetre.HEIGHT);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);
        addKeyListener(this);
        espion = new Espion(Fenetre.WIDTH/2, Fenetre.HEIGHT/2);
        map = new Map("/res/plan/plan.png");
    }

    public synchronized void start(){
        if(isRunning) return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()  {
        if(!isRunning) return;
        isRunning = false;
        try{
            thread.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    private void tick() throws InterruptedException {
        espion.tick();

    }

    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics graphics = bs.getDrawGraphics();
        graphics.setColor(Color.blue);
        graphics.fillRect(0,0, Fenetre.WIDTH, Fenetre.HEIGHT);

        map.render(graphics);
        espion.render(graphics);
        graphics.dispose();
        bs.show();

    }

    @Override
    public void run() {
        requestFocus();
        int fps = 0;
        double timer = System.currentTimeMillis();
        long LastTime = System.nanoTime();
        double targetTick = 60.0;
        double delta = 0;
        double ns = 1000000000/targetTick;

        while (isRunning){
            long now = System.nanoTime();
            delta +=(now-LastTime) / ns;
            LastTime = now;

            while (delta >= 1){
                try {
                    tick();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                render();
                fps++;
                delta--;
            }

            if(System.currentTimeMillis() - timer >= 1000){
                System.out.println(fps-60);
                fps=0;
                timer += 1000;
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if(key == KeyEvent.VK_DOWN) {
            espion.direction ="Bas";
            System.out.println("Espion direction :" + espion.direction);
        }
        if(key == KeyEvent.VK_UP) {
            espion.direction ="Haut";
            System.out.println("Espion direction :" + espion.direction);
        }
        if(key == KeyEvent.VK_LEFT){
            espion.direction ="Gauche";
            System.out.println("Espion direction :" + espion.direction);
            }
        if(key == KeyEvent.VK_RIGHT){
            espion.direction ="Droite";
            System.out.println("Espion direction :" + espion.direction);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if((key == KeyEvent.VK_DOWN) || (key == KeyEvent.VK_UP) || (key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)){
            espion.direction =null;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

   
}
