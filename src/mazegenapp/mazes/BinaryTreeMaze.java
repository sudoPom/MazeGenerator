package mazegenapp.mazes;

import mazegenapp.algorithms.PathFinder;
import mazegenapp.datastructures.Cell;

import java.util.ArrayList;
import java.util.Random;

public class BinaryTreeMaze extends GenericMaze{
    private final int mazeWidth;
    private final int mazeHeight;

    private final ArrayList<ArrayList<Cell>> cells;

    public BinaryTreeMaze(int width, int height){
        super(width, height);
        cells = new ArrayList<>();
        mazeWidth = width;
        mazeHeight = height;
        BinaryTreeMaze.fillMaze(mazeWidth,mazeHeight, cells);
        setNeighbors();
        breakWalls();
        new PathFinder(cells);
    }

    private void setNeighbors(){
        GenericMaze.setNeighbours(mazeHeight, mazeWidth, cells);
    }

    private void breakWalls(){
        for(int row = 0; row < mazeHeight; row++){
            for(int col = 0; col < mazeWidth; col++) {
                breakCellWall(row, col);
            }
        }
    }

    private void breakCellWall(int row, int col){
            if(row == mazeHeight -1 && col == mazeWidth -1){
                return;
            }
            if(row == mazeHeight -1){
                cells.get(row).get(col).destroyEastWall();
            }
            else if(col == mazeWidth -1){
                cells.get(row).get(col).destroyNorthWall();
            }
            else{
                Random rand = new Random();
                cells.get(row).get(col).destroyWall(rand.nextInt(2));
            }
    }

    public ArrayList<ArrayList<Cell>> getCells(){
        return cells;
    }
}


