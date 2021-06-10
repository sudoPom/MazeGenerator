package mazegenapp.mazes;

import java.util.ArrayList;
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
                if(rows == mazeHeight - 1 && cols == mazeWidth - 1){
                    break;
                }
                else if(rows == mazeHeight - 1){
                    currentCell.destroyEastWall();
                    continue;
                }
                else if(cols == mazeWidth - 1){
                    if(currentCells.size() > 0){
                        currentCells.get(rand.nextInt(currentCells.size())).destroyNorthWall();
                        currentCells.clear();
                        continue;
                    }
                    currentCell.destroyNorthWall();
                    continue;
                }
                currentCells.add(currentCell);
                if(rand.nextInt(2) == 0){
                    currentCell.destroyEastWall();
                }
                else{
                    currentCells.get(rand.nextInt(currentCells.size())).destroyNorthWall();
                    currentCells.clear();
                }
            }
        }
    }

    public ArrayList<ArrayList<Cell>> getCells(){
        return cells;
    }
}
