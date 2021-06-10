package mazegenapp.mazes;

import mazegenapp.datastructures.Cell;

import java.util.ArrayList;

public interface Maze {

    ArrayList<ArrayList<Cell>> cells = null;
    int mazeWidth = 0;
    int mazeHeight = 0;

    static void setNeighnors(int mazeHeight, int mazeWidth, ArrayList<ArrayList<Cell>> cells) {
        Cell north, east;
        for(int row = 0; row < mazeHeight; row++){
            for(int col = 0; col < mazeWidth; col++){
                if(row == mazeHeight -1){
                    north = null;
                }
                else{
                    north = cells.get(row+1).get(col);
                }
                if(col == mazeWidth -1){
                    east = null;
                }
                else{
                    east = cells.get(row).get(col+1);
                }
                cells.get(row).get(col).addNorthAndEastCells(north, east);
            }
        }
    }

    static void fillMaze(){
        for(int row = 0; row < mazeHeight; row++){
            cells.add(new ArrayList<>());
            for(int col = 0; col < mazeWidth; col++){
                cells.get(row).add(new Cell());
            }
        }
    }

}
