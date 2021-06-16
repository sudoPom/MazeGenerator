package mazegenapp.mazes;

import mazegenapp.datastructures.Cell;

import java.util.ArrayList;

public class GenericMaze {

    private static ArrayList<ArrayList<Cell>> cells;

    public GenericMaze(int width, int height) {
        cells = new ArrayList<>();
        fillMaze(width, height, cells);
    }


    public static void fillMaze(int mazeWidth, int mazeHeight, ArrayList<ArrayList<Cell>> cells){
        for(int row = 0; row < mazeHeight; row++){
            cells.add(new ArrayList<>());
            for(int col = 0; col < mazeWidth; col++){
                cells.get(row).add(new Cell());
            }
        }
    }

    static void setNeighbours(int mazeHeight, int mazeWidth, ArrayList<ArrayList<Cell>> cells) {
        Cell north, east, south, west;
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
                if(row == 0){
                    south = null;
                }
                else{
                    south = cells.get(row-1).get(col);
                }
                if(col == 0){
                    west = null;
                }
                else{
                    west = cells.get(row).get(col-1);
                }
                cells.get(row).get(col).addNeighbors(north, east, south, west);
            }
        }
    }



    public ArrayList<ArrayList<Cell>> getCells(){
        return cells;
    }
}
