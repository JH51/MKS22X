import java.util.*;

public class StackFrontier implements Frontier {

    Stack<Location> locations;

    public StackFrontier() {
	this.locations = new Stack<Location>();
    }
    
    public void add(Location l) {
	this.locations.push(l);
	return;
    }

    public Location next() {
	return this.locations.pop();
    }
    
}
