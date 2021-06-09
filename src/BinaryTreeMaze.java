import java.util.ArrayList;
import java.util.Random;

public class BinaryTreeMaze {
    private final int mazeWidth;
    private final int mazeHeight;

    private final ArrayList<ArrayList<Cell>> cells;

    public BinaryTreeMaze(int width, int height){
        cells = new ArrayList<>();
        mazeWidth = width;
        mazeHeight = height;
        fillMaze();
        setNeighbors();
        breakWalls();
    }

    private void fillMaze(){
        for(int row = 0; row < mazeHeight; row++){
            cells.add(new ArrayList<>());
            for(int col = 0; col < mazeWidth; col++){
                cells.get(row).add(new Cell());
            }
        }
    }

    private void setNeighbors(){
        Cell north, east;
        for(int row = 0; row < mazeHeight; row++){
            for(int col = 0; col < mazeWidth; col++){
                if(row == mazeHeight-1){
                    north = null;
                }
                else{
                    north = cells.get(row+1).get(col);
                }
                if(col == mazeWidth-1){
                    east = null;
                }
                else{
                    east = cells.get(row).get(col+1);
                }
                cells.get(row).get(col).addNorthAndEastCells(north, east);
            }
        }
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


