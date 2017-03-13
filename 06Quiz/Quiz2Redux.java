import java.util.*;

public class Quiz2Redux {
    
    public static ArrayList<String> combinations(String string) {
	ArrayList<String> words = new ArrayList<String>();
	words.add("");
	help(string, words);
	return words;
    }
    
    private static void help(String string, ArrayList<String> words) {
	if (string.length() == 0) return;
	int size = words.size();
	for (int i = 0; i < size; i += 1) {
	    words.add(words.get(i) + string.charAt(0));
	    words.add(words.get(i));
	    help(string.substring(1), words);
	}
	return;
    }

    public static void main(String[] args) {
	ArrayList<String> words = combinations("abcd");
	for (int i = 0; i < words.size(); i += 1) {
	    System.out.println(words.get(i));
	}
	System.out.println(words.size());
    }

}
