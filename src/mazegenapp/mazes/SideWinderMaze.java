package mazegenapp.mazes;

import java.util.ArrayList;
import mazegenapp.datastructures.Cell;

public class SideWinderMaze implements Maze{

        private final ArrayList<ArrayList<Cell>> cells;
        private final int mazeWidth;
        private final int mazeHeight;

    public SideWinderMaze(int width, int height){
        cells = new ArrayList<>();
        mazeWidth = width;
        mazeHeight = height;
        fillMaze();
        setNeighbors();
        //breakWalls();
    }

    private void fillMaze(){
        Maze.fillMaze();
    }

    private void setNeighbors(){
        Maze.setNeighnors(mazeHeight, mazeWidth, cells);
    }
}
