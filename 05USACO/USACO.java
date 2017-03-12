public class USACO {

    public USACO() {
    }
    
    public int bronze(String filename) {
	Bronze lake = new Bronze(filename);
	return lake.V;
    }
    
    public int silver(String filename) {
	return 0;
    }

    public static void main(String[] args) {
	USACO x = new USACO();
	System.out.println(x.bronze("Test Files/makelake.10.in"));	
	//System.out.println(x.silver("testfile2"));
    }
	
}
