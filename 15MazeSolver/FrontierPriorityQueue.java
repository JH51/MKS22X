import java.util.*;

public class FrontierPriorityQueue implements Frontier {
    
    private PriorityQueue<Location> locations;
    
    public frontierPriorityQueue() {
	this.locations = new PriorityQueue<Location>();
    }

    public void add(Location l) {
	this.locations.add(l);
	return;
    }

    public Location next() {
	return this.locations.remove();
    }

    public class PriorityQueue implements Queue {
	
    }

}
