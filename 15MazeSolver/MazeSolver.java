public class MazeSolver {

    private Maze board;

    public MazeSolver(String s) {
        board = new Maze(s);
    }

    public void solve() {
        solve(0);
        return;
    }

    public void solve(int i) {
        int r = board.getStart().getRow(), c = board.getStart().getCol();
        switch (i) {
            case 0:
            DepthFirst(r, c);
            break;
        }
        return;
    }

    public boolean DepthFirst(int r, int c) {
        //System.out.println(toString(10));
        if (r == board.getEnd().getRow() && c == board.getEnd().getCol()) return true;
        if (board.get(r, c) == ' ') {
            board.set(r, c, '@');
            boolean b =
            DepthFirst(r - 1, c) ||
            DepthFirst(r + 1, c) ||
            DepthFirst(r, c - 1) ||
            DepthFirst(r, c + 1);
            if (b) return true;
            else board.set(r, c, '.');
        }
        return false;
    }

    public String toString() {
        return board.toString();
    }

    public String toString(int i) {
        try {
            Thread.sleep(i);
        }
        catch(InterruptedException e) { }
        return "\033[2J" + board.toString();
    }

    public static void main(String[] args) {
        MazeSolver m = new MazeSolver("Tests/data2.txt");
        System.out.println(m);
        m.solve();
        System.out.println(m);
    }

}
