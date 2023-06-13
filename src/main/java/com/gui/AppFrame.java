/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gui;

import com.maze_solver.DepthFirstSearch;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author drekh
 */
public class AppFrame extends JFrame{
    private int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    List<Integer> path;
    public AppFrame() {
        path = new ArrayList<>();
        this.setTitle("Maze Solver");
        this.setSize(700, 450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirstSearch.searchPath(maze, 1, 1, path);
//        System.out.println(path);
    }

    @Override
    public void paint(Graphics g) {
        g.translate(150, 100);
        for(int i = 0; i < maze.length; i ++) {
            for(int j = 0; j < maze[0].length; j ++) {
                Color color;
                switch(maze[i][j]) {
                    case 1: color = Color.BLACK;
                    break;
                    case 9: color = Color.RED;
                    break;
                    default: color = Color.WHITE;
                    break;
                }
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                g.setColor(Color.GRAY);
                g.drawRect(30 * j, 30 * i, 30, 30);
                
            }
        }
        for(int i = 0; i < path.size(); i = i + 2) {
            int path_x = path.get(i);
            int path_y = path.get(i + 1);
            g.setColor(Color.GREEN);
            g.fillRect(30 * path_y, 30 * path_x, 20, 20);
        }
    }
    
}
