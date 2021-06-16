package mazegenapp.mazes;

import java.util.ArrayList;

import mazegenapp.algorithms.PathFinder;
import mazegenapp.datastructures.Cell;
import java.util.Random;

public class SideWinderMaze extends GenericMaze{

        private final ArrayList<ArrayList<Cell>> cells;
        private final int mazeWidth;
        private final int mazeHeight;

    public SideWinderMaze(int width, int height){
        super(width, height);
        cells = new ArrayList<>();
        mazeWidth = width;
        mazeHeight = height;
        SideWinderMaze.fillMaze(width,height,cells);
        setNeighbors();
        breakWalls();
        new PathFinder(cells);
    }

    private void setNeighbors(){
        GenericMaze.setNeighbours(mazeHeight, mazeWidth, cells);
    }

    private void breakWalls(){
        ArrayList<Cell> currentCells = new ArrayList<>();
        Random rand = new Random();
        for(int rows = 0; rows < mazeHeight; rows++){
            for(int cols = 0; cols < mazeWidth; cols++){
                Cell currentCell = cells.get(rows).get(cols);
                currentCells.add(currentCell);
                if(handleEdgeCases(rows, cols, currentCell, currentCells, rand) == 1){
                    randomlyDestroyNorthOrEast(currentCell, currentCells, rand);
                }
            }
        }
    }

    private void randomlyDestroyNorthOrEast(Cell currentCell, ArrayList<Cell> currentCells, Random rand){
        if(rand.nextInt(2) == 0){
            currentCell.destroyEastWall();
        }
        else{
            destroyNorthWall(currentCells, currentCell, rand);
        }
    }

    private int handleEdgeCases(int rows, int cols, Cell currentCell, ArrayList<Cell> currentCells, Random rand){
        if(rows == mazeHeight - 1 && cols == mazeWidth - 1){
            return -1;
        }
        else if(rows == mazeHeight - 1){
            currentCell.destroyEastWall();
            return 0;
        }
        else if(cols == mazeWidth - 1){
            destroyNorthWall(currentCells, currentCell, rand);
            return 0;
        }
        return 1;
    }

    private void destroyNorthWall(ArrayList<Cell> currentCells, Cell currentCell, Random rand){
        currentCells.get(rand.nextInt(currentCells.size())).destroyNorthWall();
        currentCells.clear();
    }

    public ArrayList<ArrayList<Cell>> getCells(){
        return cells;
    }
}
