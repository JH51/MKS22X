public class MazeSolver {

    private Maze board;
    private boolean animate;

    public MazeSolver(String s) {
        board = new Maze(s);
        animate = false;
    }

    public MazeSolver(String s, boolean b) {
        board = new Maze(s);
        animate = b;
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
                board.set(l, 'E');
                while (l.getPrevious() != null) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                board.set(l, 'S');
                return;
            }
            board.set(l, '.');
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '?');
                s.add(new Location(l.getRow() - 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '?');
                s.add(new Location(l.getRow() + 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '?');
                s.add(new Location(l.getRow(), l.getCol() - 1, l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '?');
                s.add(new Location(l.getRow(), l.getCol() + 1, l, 0, 0, false));
            }
            if (animate) System.out.println(this.toString());
        }
    }

    public void BreadthFirst() {
        QueueFrontier q = new QueueFrontier();
        q.add(board.getStart());
        board.set(board.getStart(), '@');
        while (q.size() > 0) {
            Location l = q.next();
            if (l.getRow() == board.getEnd().getRow() && l.getCol() == board.getEnd().getCol()) {
                board.set(l, 'E');
                while (l.getPrevious() != null) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                board.set(l, 'S');
                return;
            }
            board.set(l, '.');
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '?');
                q.add(new Location(l.getRow() - 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '?');
                q.add(new Location(l.getRow() + 1, l.getCol(), l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '?');
                q.add(new Location(l.getRow(), l.getCol() - 1, l, 0, 0, false));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '?');
                q.add(new Location(l.getRow(), l.getCol() + 1, l, 0, 0, false));
            }
            if (animate) System.out.println(this.toString());
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
                board.set(l, 'E');
                while (l.getPrevious() != null) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                board.set(l, 'S');
                return;
            }
            board.set(l, '.');
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '?');
                q.add(new Location(l.getRow() - 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() - 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() - 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   false));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '?');
                q.add(new Location(l.getRow() + 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() + 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() + 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   false));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '?');
                q.add(new Location(l.getRow(),
                                   l.getCol() - 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() - 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() - 1)),
                                   false));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '?');
                q.add(new Location(l.getRow(),
                                   l.getCol() + 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() + 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() + 1)),
                                   false));
            }
            if (animate) System.out.println(this.toString());
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
                board.set(l, 'E');
                while (l.getPrevious() != null) {
                    board.set(l.getPrevious(), '@');
                    l = l.getPrevious();
                }
                board.set(l, 'S');
                return;
            }
            board.set(l, '.');
            if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
                board.set(l.getRow() - 1, l.getCol(), '?');
                q.add(new Location(l.getRow() - 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() - 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() - 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   true));
            }
            if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
                board.set(l.getRow() + 1, l.getCol(), '?');
                q.add(new Location(l.getRow() + 1,
                                   l.getCol(),
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow() + 1)) + Math.abs(board.getStart().getCol() - (l.getCol())),
                                   Math.abs(board.getEnd().getRow() - (l.getRow() + 1)) + Math.abs(board.getEnd().getRow() - (l.getCol())),
                                   true));
            }
            if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
                board.set(l.getRow(), l.getCol() - 1, '?');
                q.add(new Location(l.getRow(),
                                   l.getCol() - 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() - 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() - 1)),
                                   true));
            }
            if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
                board.set(l.getRow(), l.getCol() + 1, '?');
                q.add(new Location(l.getRow(),
                                   l.getCol() + 1,
                                   l,
                                   Math.abs(board.getStart().getRow() - (l.getRow())) + Math.abs(board.getStart().getCol() - (l.getCol() + 1)),
                                   Math.abs(board.getEnd().getRow() - (l.getRow())) + Math.abs(board.getEnd().getRow() - (l.getCol() + 1)),
                                   true));
            }
            if (animate) System.out.println(this.toString());
        }
        return;
    }

    public String toString() {
        return board.toString();
    }

    public String toString(boolean b) {
        return (b) ? board.colorize(this.toString()) : this.toString();
    }

    public String toString(int i) {
        return board.toString(i);
    }

}
