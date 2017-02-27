public class Maze{

    private char[][]maze;
    private boolean animate;

    public Maze(String filename, boolean ani){
        //COMPLETE CONSTRUCTOR
    }

    public void setAnimate(boolean b){
        animate = b;
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startx=0,starty=0;
            //Initialize startx and starty with the location of the S. 
            maze[startx][starty] = ' ';//erase the S, and start solving!
            return solve(startx,starty);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        return false; //so it compiles
    }

}
