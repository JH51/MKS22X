public class Driver{
    
    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");        
        f.clearTerminal();
        f.setAnimate(true);
        f.solve();
	
        f.clearTerminal();
        System.out.println(f);
    }
    
}
