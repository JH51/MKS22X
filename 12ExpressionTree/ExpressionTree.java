
public class ExpressionTree {

    public double evaluate() {
        if (this.isValue()) return this.getValue();
        switch (this.getOp()) {
            case '*': return this.getLeft().evaluate() * this.getRight().evaluate();
            case '/': return this.getLeft().evaluate() / this.getRight().evaluate();
            case '+': return this.getLeft().evaluate() + this.getRight().evaluate();
            case '-': return this.getLeft().evaluate() - this.getRight().evaluate();
        }
        return 0.0;
    }

    public String toString() {
        if (this.isValue()) return this.getValue() + "";
        return "(" + this.getLeft().toString() + " " + this.getOp() + " " + this.getRight().toString() + ")";
    }

    public String toStringPostfix(){
        if (this.isValue()) return this.getValue() + "";
        return this.getLeft().toStringPostfix() + " " + this.getRight().toStringPostfix() + " " + this.getOp();
    }

    public String toStringPrefix(){
        if (this.isValue()) return this.getValue() + "";
        return this.getOp() + " " + this.getLeft().toStringPrefix() + " " + this.getRight().toStringPrefix();
    }

    private char op;
    private double value;
    private ExpressionTree left,right;

    public ExpressionTree(double value){
        this.value = value;
        op = '~';
    }
    public ExpressionTree(char op, ExpressionTree l, ExpressionTree r) {
        this.op = op;
        left = l;
        right = r;
    }

    public char getOp(){
        return op;
    }

    /* accessor method for Value, precondition is that isValue() is true.*/
    private double getValue(){
        return value;
    }
    /* accessor method for left, precondition is that isOp() is true.*/
    private ExpressionTree getLeft(){
        return left;
    }
    /* accessor method for right, precondition is that isOp() is true.*/
    private ExpressionTree getRight(){
        return right;
    }

    private boolean isOp(){
        return hasChildren();
    }
    private boolean isValue(){
        return !hasChildren();
    }

    private boolean hasChildren(){
        return left != null && right != null;
    }

    public static void main(String[] args){
        //ugly main sorry!
        ExpressionTree a = new ExpressionTree(4.0);
        ExpressionTree b = new ExpressionTree(2.0);

        ExpressionTree c = new ExpressionTree('+',a,b);
        System.out.println(c);
        System.out.println(c.toStringPostfix());
        System.out.println(c.toStringPrefix());
        System.out.println(c.evaluate());
        System.out.println();

        ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
        System.out.println(d);
        System.out.println(d.toStringPostfix());
        System.out.println(d.toStringPrefix());
        System.out.println(d.evaluate());
        System.out.println();

        ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
        System.out.println(ex);
        System.out.println(ex.toStringPostfix());
        System.out.println(ex.toStringPrefix());
        System.out.println(ex.evaluate());
        System.out.println();

        ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
        System.out.println(ex);
        System.out.println(ex.toStringPostfix());
        System.out.println(ex.toStringPrefix());
        System.out.println(ex.evaluate());
        System.out.println();

        ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
        System.out.println(ex);
        System.out.println(ex.toStringPostfix());
        System.out.println(ex.toStringPrefix());
        System.out.println(ex.evaluate());
        System.out.println();
    }

}
