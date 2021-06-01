
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.ArrayList;

public class MazeSketcher extends Canvas{

    public static final int BORDER = 10;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    private final int cellHeight;
    private final int cellWidth;
    JFrame frame;
    ArrayList<ArrayList<Cell>> cells;

    public MazeSketcher(Maze maze){
        cells = maze.getCells();
        frame = new JFrame("Maze");
        setSize(WIDTH, HEIGHT);
        cellHeight = (HEIGHT - 2* BORDER)/cells.size();
        cellWidth = (WIDTH - 2* BORDER)/cells.get(0).size();
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
        Maze maze = new Maze(200,200);
        MazeSketcher mazeSketcher = new MazeSketcher(maze);
    }
}
