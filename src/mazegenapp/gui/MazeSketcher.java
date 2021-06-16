package mazegenapp.gui;

import mazegenapp.datastructures.Cell;
import mazegenapp.mazes.BinaryTreeMaze;
import mazegenapp.mazes.GenericMaze;
import mazegenapp.mazes.SideWinderMaze;

import java.awt.*;
import javax.swing.JFrame;
import java.util.ArrayList;

public class MazeSketcher extends Canvas{

    public static final int BORDER = 10;
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1000;
    private final int cellHeight;
    private final int cellWidth;
    JFrame frame;
    ArrayList<ArrayList<Cell>> cells;

    public MazeSketcher(GenericMaze maze){
        cells = maze.getCells();
        int mazeHeight = cells.size();
        int mazeWidth = cells.get(0).size();
        frame = new JFrame("Maze");
        setSize(WIDTH, HEIGHT);
        int cellSize = Math.min((WIDTH-(2*BORDER))/mazeWidth, (HEIGHT-(2*BORDER))/ mazeHeight);
        cellHeight = cellSize;
        cellWidth = cellSize;
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g){
        int x = BORDER;
        int y = HEIGHT-BORDER;
        for (ArrayList<Cell> cell : cells) {
            for (Cell value : cell) {
                drawCell(value, g, x, y);
                x += cellWidth;
            }
            x = BORDER;
            y -= cellHeight;
        }
    }

    private void drawCell(Cell cell, Graphics g, int x, int y){
        if(cell.isPartOfPath()){
            g.setColor(Color.GREEN);
            g.fillRect(x,y-cellWidth,cellWidth,cellHeight);
            g.setColor(Color.BLACK);
        }
        if(cell.isWest()){
            g.drawLine(x,y,x,y-cellHeight);
        }
        if(cell.isSouth()){
            g.drawLine(x,y,x+cellWidth,y);
        }
        if(cell.isNorth()){
            g.drawLine(x,y-cellHeight,x+cellWidth,y-cellHeight);
        }
        if(cell.isEast()){
            g.drawLine(x+cellWidth,y,x+cellWidth,y-cellHeight);
        }
    }

    public static void main(String[] args) {
        GenericMaze maze = new SideWinderMaze(100,100);
        new MazeSketcher(maze);
    }
}
