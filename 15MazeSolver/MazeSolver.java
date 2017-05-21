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
                DepthFirst();
                break;
            case 1:
                BreadthFirst();
                break;
            case 2:
                BestFirst();
                break;
            case 3:
                aStar();
                break;
        }
        return;
    }

    public void DepthFirst() {
        StackFrontier s = new StackFrontier();
        s.add(board.getStart());
        while (s.size() > 0) {
            Location l = s.next();
            if (l.getRow() == board.getEnd().getRow() && l.getCol() == board.getEnd().getCol()) {
                board.set(l, '@');
                while (l.getPrevious() != board.getStart()) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                return;
            }
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '.');
                s.add(new Location(l.getRow() - 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '.');
                s.add(new Location(l.getRow() + 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '.');
                s.add(new Location(l.getRow(), l.getCol() - 1, l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '.');
                s.add(new Location(l.getRow(), l.getCol() + 1, l, 0, 0, false));
            }
            System.out.println(this.toString(25));
        }
    }

    public void BreadthFirst() {
        QueueFrontier q = new QueueFrontier();
        q.add(board.getStart());
        board.set(board.getStart(), '@');
        while (q.size() > 0) {
            Location l = q.next();
            if (l.getRow() == board.getEnd().getRow() && l.getCol() == board.getEnd().getCol()) {
                board.set(l, '@');
                while (l.getPrevious() != board.getStart()) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                return;
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
            System.out.println(this.toString(25));
        }
        return;
    }

    public void BestFirst() {
        FrontierPriorityQueue q = new FrontierPriorityQueue();
        q.add(board.getStart());
        board.set(board.getStart(), '@');
        while (q.size() > 0) {
            Location l = q.next();
            if (l.getRow() == board.getEnd().getRow() && l.getCol() == board.getEnd().getCol()) {
                board.set(l, '@');
                while (l.getPrevious() != board.getStart()) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                return;
            }
            System.out.println(q.size());
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '.');
                q.add(new Location(l.getRow() - 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() - 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() - 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   false));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '.');
                q.add(new Location(l.getRow() + 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() + 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() + 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   false));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '.');
                q.add(new Location(l.getRow(),
                                   l.getCol() - 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() - 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() - 1)),
                                   false));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '.');
                q.add(new Location(l.getRow(),
                                   l.getCol() + 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() + 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() + 1)),
                                   false));
            }
            System.out.println(this.toString(250));
        }
        return;
    }

    public void aStar() {
        FrontierPriorityQueue q = new FrontierPriorityQueue();
        q.add(board.getStart());
        board.set(board.getStart(), '@');
        while (q.size() > 0) {
            Location l = q.next();
            if (l.getRow() == board.getEnd().getRow() && l.getCol() == board.getEnd().getCol()) {
                board.set(l, '@');
                while (l.getPrevious() != board.getStart()) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                return;
            }
            System.out.println(l);
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '.');
                q.add(new Location(l.getRow() - 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() - 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() - 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   true));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '.');
                q.add(new Location(l.getRow() + 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() + 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() + 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   true));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '.');
                q.add(new Location(l.getRow(),
                                   l.getCol() - 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() - 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() - 1)),
                                   true));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '.');
                q.add(new Location(l.getRow(),
                                   l.getCol() + 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() + 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() + 1)),
                                   true));
            }
            System.out.println(this.toString(500));
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
        m.solve(2);
        System.out.println(m);
    }

}
