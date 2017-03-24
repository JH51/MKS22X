import java.util.*;

public class Driver {
    
    public static void main(String[] args) {

	//a. Randomized; minVal to maxVal
	int score = 0;
	int[][] a = new int[new Random().nextInt(1000)][new Random().nextInt(1000)];
	for (int[] aa : a) {
	    for (int i = 0; i < aa.length; i += 1) {
		aa[i] = new Random().nextInt(1000);
	    }
	}
	for (int[] aa : a) {
	    if (Quick.isSorted(aa)) score += 1;
	}
	System.out.println(score + " / " + a.length);
	
	//b. Randomized; a to b
	
	
	//c. Same values
	
	
	//d. Sorted
	
	
	//e. Reverse-sorted
	
	
    }

}
