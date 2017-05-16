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
    
    public Location(int distToStart,
		    int distToGoal,
		    boolean aStar) {
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

    public boolean getAStar() {
	return this.aStar;
    }

    public int compareTo(Location l) {
	if (this.aStar && l.getAStar())
	    return ((this.distToStart + this.distToGoal) - (l.getDistToStart() - l.getDistToGoal()));
	else
	    return (this.distToStart - l.getDistToStart());
    }

    public static void main(String[] args) {
	Location a = new Location(1, 0, true),
	    b = new Location(1, 2, true);
	System.out.println(a.compareTo(b));
    }

}