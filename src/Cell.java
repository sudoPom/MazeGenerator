import java.util.ArrayList;

public class Cell {
    private boolean north, east, south, west;
    private Cell northCell;
    private Cell eastCell;

    public Cell(){
        north = true;
        east = true;
        south = true;
        west = true;
    }

    public void addNorthAndEastCells(Cell northCell, Cell eastCell){
        this.northCell = northCell;
        this.eastCell = eastCell;
    }

    public void destroyWall(int choice){
        switch (choice) {
            case 0 -> destroyNorthWall();
            case 1 -> destroyEastWall();
        }
    }

    public void destroyNorthWall(){
        this.north = false;
        if(this.northCell != null){
            this.northCell.destroySouthWall();
        }
    }

    public void destroyEastWall(){
        this.east = false;
        if(this.eastCell != null){
            this.eastCell.destroyWestWall();
        }
    }
    public void destroyWestWall(){
        this.west = false;
    }
    public void destroySouthWall(){
        this.south = false;
    }

    public boolean isEast() {
        return east;
    }

    public boolean isNorth() {
        return north;
    }

    public boolean isSouth() {
        return south;
    }

    public boolean isWest() {
        return west;
    }
}
