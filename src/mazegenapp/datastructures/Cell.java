package mazegenapp.datastructures;

public class Cell {
    private boolean north, east, south, west;
    private Cell northCell;
    private Cell eastCell;
    private Cell westCell;
    private Cell southCell;
    private double distance;
    private boolean partOfPath;

    public Cell(){
        north = true;
        east = true;
        south = true;
        west = true;
        distance = Double.POSITIVE_INFINITY;
        partOfPath = false;
    }

    public void addNeighbors(Cell northCell, Cell eastCell, Cell southCell, Cell westCell){
        this.northCell = northCell;
        this.eastCell = eastCell;
        this.southCell = southCell;
        this.westCell = westCell;
    }

    public void destroyWall(int choice){
        switch (choice) {
            case 0 -> destroyNorthWall();
            case 1 -> destroyEastWall();
        }
    }

    public void destroyNorthWall(){
        this.north = false;
        if(this.northCell != null && this.northCell.isSouth()){
            this.northCell.destroySouthWall();
        }
    }

    public void destroyEastWall(){
        this.east = false;
        if(this.eastCell != null && this.eastCell.isWest()){
            this.eastCell.destroyWestWall();
        }
    }

    public void destroyWestWall(){
        this.west = false;
        if(this.westCell != null && this.westCell.isEast()){
            this.northCell.destroyEastWall();
        }
    }

    public void destroySouthWall(){
        this.south = false;
        if(this.southCell != null && this.southCell.isNorth()){
            this.southCell.destroyNorthWall();
        }
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Cell getNorthCell() {
        return northCell;
    }

    public Cell getEastCell() {
        return eastCell;
    }

    public Cell getSouthCell() {
        return southCell;
    }

    public Cell getWestCell() {
        return westCell;
    }

    public boolean isPartOfPath() {
        return partOfPath;
    }

    public void addToPath(){
        partOfPath = true;
    }
}
