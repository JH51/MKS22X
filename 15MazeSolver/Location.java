public class Location implements Comparable<Location>{
    
    private int row, col, distToGoal, distToStart;
    private Location previous;
    private boolean aStar;
    
    public Location(int row,
		    int col,
		    Location previous,
		    int distToStart,
		    boolean aStar) {
	this.row = row;
	this.col = col;
	this.previous = previous;
	this.distToStart = distToStart;
	this.aStar = aStar;
    }

    public int getRow() {
	return this.row;
    }

    public int getCol() {
	return this.col;
    }

}
