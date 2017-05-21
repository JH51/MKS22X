import java.util.*;

public class StackFrontier implements Frontier {

    private Stack<Location> locations;

    public StackFrontier() {
        locations = new Stack<Location>();
    }

    public void add(Location l) {
        locations.push(l);
        return;
    }

    public Location next() {
        return locations.pop();
    }

    public int size() {
        return locations.size();
    }

}
