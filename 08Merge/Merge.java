public class Merge {
    
    static void mergesort(int[] a) {
	
    }

    static void merge(int[] a, int[] b, int[] dest) {
	dest = merge(a, b);
    }
    
    static int[] merge(int[] a, int[] b) {
	int[] dest = new int[a.length + b.length];
	int i = 0, j = 0, k = 0;
	while (i < dest.length &&
	       j < a.length &&
	       k < b.length) {
	    if (a[j] < b[k]) {
		dest[i] = a[j];
		j += 1;
	    }
	    else {
		dest[i] = b[k];
		k += 1;
	    }
	    i += 1;
	}
	if (j >= a.length) {
	    while (i < dest.length && k < b.length) {
		dest[i] = b[k];
		i += 1;
		k += 1;
	    }
	}
	else if (k >= b.length) {
	    while (i < dest.length && j < a.length) {
		dest[i] = a[j];
		i += 1;
		j += 1;
	    }
	}
	return dest;
    }
    
    public static void main(String[] args) {
	int[] a = {1, 3, 5, 6};
	int[] b = {2, 4, 6, 7, 8};
	for (int i : merge(a, b)) System.out.print(i + " ");	
    }

}
