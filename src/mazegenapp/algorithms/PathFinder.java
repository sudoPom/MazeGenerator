package mazegenapp.algorithms;

import mazegenapp.datastructures.Cell;

import java.util.ArrayList;

public class PathFinder {

    private Cell start;
    private Cell end;

    public PathFinder(ArrayList<ArrayList<Cell>> cells){
        int sizeX = cells.size();
        int sizeY = cells.get(0).size();
        start = cells.get(0).get(0);
        end = cells.get(sizeX-1).get(sizeY-1);
        dijkstrasAlgorithm();
        setPath();
    }

    private void setPath(){
        end.addToPath();
        start.addToPath();
        stepBack(end);
    }

    private void stepBack(Cell currentCell){
        if(currentCell == start){
            return;
        }
        if(isPreviousCell(currentCell, currentCell.getNorthCell())){
            currentCell.getNorthCell().addToPath();
            stepBack(currentCell.getNorthCell());
        }
        else if(isPreviousCell(currentCell, currentCell.getEastCell())){
            currentCell.getEastCell().addToPath();
            stepBack(currentCell.getEastCell());
        }
        else if(isPreviousCell(currentCell, currentCell.getSouthCell())){
            currentCell.getSouthCell().addToPath();
            stepBack(currentCell.getSouthCell());
        }
        else if(isPreviousCell(currentCell, currentCell.getWestCell())){
            currentCell.getWestCell().addToPath();
            stepBack(currentCell.getWestCell());
        }
    }

    private boolean isPreviousCell(Cell currentCell, Cell previousCell){
        if(previousCell == null){
            return false;
        }
        return previousCell.getDistance() == currentCell.getDistance()-1;
    }

    private void dijkstrasAlgorithm(){
        start.setDistance(0);
        dijkstraStep(start);
    }

    private void dijkstraStep(Cell currentCell){
        if(!currentCell.isNorth()){
            nextStep(currentCell.getNorthCell(), currentCell.getDistance());
        }
        if(!currentCell.isEast()){
            nextStep(currentCell.getEastCell(), currentCell.getDistance());
        }
        if(!currentCell.isSouth()){
            nextStep(currentCell.getSouthCell(), currentCell.getDistance());
        }
        if(!currentCell.isWest()){
            nextStep(currentCell.getWestCell(), currentCell.getDistance());
        }
    }

    private void nextStep(Cell nextCell, double distance){
        if(nextCell.getDistance() > distance){
            nextCell.setDistance(distance+1);
            dijkstraStep(nextCell);
        }
    }
}
