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
            case 1:
            BreadthFirst();
            break;
        }
        return;
    }

    public boolean DepthFirst(int r, int c) {
        System.out.println(toString(10));
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

    public void BreadthFirst() {
        QueueFrontier q = new QueueFrontier();
        q.add(board.getStart());
        board.set(board.getStart(), '@');
        while (q.size() > 0) {
            System.out.println(this.toString(10));
            Location l = q.next();
            if (l == board.getEnd()) {
                board.set(l, '@');
                while (l.getPrevious() != board.getStart()) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
            }
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '.');
                q.add(new Location(l.getRow() - 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '.');
                q.add(new Location(l.getRow() + 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '.');
                q.add(new Location(l.getRow(), l.getCol() - 1, l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '.');
                q.add(new Location(l.getRow(), l.getCol() + 1, l, 0, 0, false));
            }
        }
        return;
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
        //System.out.println(m);
        m.solve(1);
        //System.out.println(m);
    }

}
