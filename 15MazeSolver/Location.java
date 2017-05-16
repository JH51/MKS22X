public class Location implements Comparable<Location>{
    
    private int row, col, distToGoal, distToStart;
    private Location previous;
    private boolean aStar;
    
    public Location(int row,
		    int col,
		    Location previous,
		    int distToStart,
		    int distToGoal,
		    boolean aStar) {
	this.row = row;
	this.col = col;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int getRow() {
	return this.row;
    }

    public int getCol() {
	return this.col;
    }

    public int getDistToGoal() {
	return this.distToGoal;
    }

    public int getDistToStart() {
	return this.distToStart;
    }

    public Location getPrevious() {
	return this.previous;
    }

}
