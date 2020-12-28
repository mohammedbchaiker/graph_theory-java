package com.company;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class CalculateurDeChemin {
    public static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY(){
            return y;
        }
    }

    public ArrayList<Node> chemin=new ArrayList<>();
    public int[][] map;
    private final int Debut_X;
    private final int Debut_Y;
    private final int Dest_X;
    private final int Dest_Y;
    private final int[] Direction_X = {1,0,-1,0};
    private final int[] Direction_Y = {0,1,0,-1};

    public CalculateurDeChemin(int[][] map, int Debut_X, int Debut_Y, int Dest_X, int Dest_Y) {
        this.map = map;
        this.Debut_X = Debut_X/16;
        this.Debut_Y = Debut_Y/16;
        this.Dest_X = Dest_X/16;
        this.Dest_Y = Dest_Y/16;
    }
    public void print(int[][] map) {
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%4d", ints[j]);
            }
            System.out.println();
        }
    }
    //Breadth first traverse to find the shortest path of all points in the maze, x, y are the starting points
    public void bfs() {
        Deque<Node> nodes = new ArrayDeque<Node>();
        //Store the predecessor node of each point to facilitate printing of the shortest path route
        int[][] pre = new  int[this.map.length][this.map[0].length];
        //Store the shortest path of each point
        int[][] dis = new  int[this.map.length][this.map[0].length];
        for(int i=0; i<dis.length; i++) {
            for(int j=0; j<dis[0].length; j++) {
                dis[i][j] = 100;
            }
        }
        //Enter the starting point, set the distance of the starting point to 0 and mark it as visited
        var add = nodes.add(new Node(this.Debut_X, this.Debut_Y));
        dis[this.Debut_X][this.Debut_Y] = 0;
        map[this.Debut_X][this.Debut_Y] = 2;
        Node temp;
        //Breadth first traverse all accessible points, and note down the shortest path and predecessor node of each point
        while(!nodes.isEmpty()) {
            temp = nodes.poll();
            //Try the four directions of each point
            for(int i=0; i<4; i++) {
                int tx = temp.x + Direction_X[i];
                int ty = temp.y + Direction_Y[i];
                //If the point has not been visited, enqueue the point and mark it as visited
                if(map[tx][ty] == 0) {
                    //Only one step at a time in the maze, so the distance is increased by one
                    dis[tx][ty] = dis[temp.x][temp.y] + 1;
                    pre[tx][ty] = i;
                    map[tx][ty] = 2;
                    nodes.add(new Node(tx, ty));
                }
            }
        }//The shortest path is stored in dis here, and the path is printed using the pre array below

        int a = this.Dest_X;
        int b = this.Dest_Y;
        System.out.printf("Le chemin le plus court de (%d,%d) à (%d,%d) est : %d,est le chemin suivant :\n", this.Debut_X, this.Debut_Y, a, b, dis[a][b]);
        //Reverse access to the shortest path route and merge into the stack
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(a, b));
        while(a != this.Debut_X || b != this.Debut_Y) {
            int da = Direction_X[pre[a][b]];
            int db = Direction_Y[pre[a][b]];
            a = a - da;
            b = b - db;
            stack.add(new Node(a, b));
        }
        //The order of stacking is the route from the start to the end
        while(!stack.isEmpty()) {
            Node p = stack.pop();
            chemin.add(new Node(p.x, p.y));
            System.out.printf("(%d,%d)->",p.x,p.y);

        }
    }


}





