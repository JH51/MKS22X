import java.util.*;

public class QueueFrontier implements Frontier {

    private Queue<Location> locations;

    public QueueFrontier() {
        locations = new LinkedList<Location>();
    }

    public void add(Location l) {
        locations.add(l);
        return;
    }

    public Location next() {
        return locations.remove();
    }

    public int size() {
        return locations.size();
    }

    public String toString() {
        String s = "[";
        Queue<Location> q = locations;
        while (locations.size() > 0)
            s += locations.remove() + ", ";
        return s.substring(0, s.length() - 2) + "]";
    }

}
