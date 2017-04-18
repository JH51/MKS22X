import java.util.*;

public class MyLinkedList implements Iterable<Integer> {



    public class LinkedListIterator implements Iterator<Integer> {

        LNode node;

        public LinkedListIterator(MyLinkedList list) {
            this.node = list.getNthNode(0);
        }

        public boolean hasNext() {
            return this.node.next != null;
        }

        public Integer next() {
            if (this.node.previous == null && this.node.next != null) {
                this.node = this.node.next;
                return this.node.previous.value;
            }
            if (this.hasNext())
                this.node = this.node.next;
            if (this.node.next != null || this.node.previous != null)
                return this.node.value;
            else
                throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }



    private class LNode {

        int value;
        LNode previous, next;

        public LNode() {

        }

        public LNode(int value) {
            this.value = value;
        }

        public LNode(int value, LNode next) {
            this.value = value;
            this.next = next;
        }

        public String toString() {
            String string = "";
            if (this.previous == null) string += "-, ";
            else string += this.previous.value + ", ";
            string += this.value + ", ";
            if (this.next == null) string += "-";
            else string += this.next.value;
            return string;
        }

    }



    private LNode start, end;
    private int size;

    public MyLinkedList() {

    }

    public MyLinkedList(int[] data) {
        start = new LNode();
        for (int i = 0; i < data.length; i += 1) this.add(data[i]);
        end = start;
        while (end.next != null) end = end.next;
        this.size = data.length;
    }

    public MyLinkedList(int[] data, int size) {
        start = new LNode();
        for (int i = 0; i < size; i += 1) this.add(data[i]);
        end = start;
        while (end.next != null) end = end.next;
        this.size = size;
    }

    public int get(int index) {
        if (index >= this.size() || index < 0) throw new IndexOutOfBoundsException();
        LNode tempNode = this.start;
        while (index > 0) {
            tempNode = tempNode.next;
            index -= 1;
        }
        return tempNode.value;
    }

    public LNode getNthNode(int index) {
        if (index >= this.size() || index < 0) throw new IndexOutOfBoundsException();
        LNode tempNode = this.start;
        while (index > 0) {
            tempNode = tempNode.next;
            index -= 1;
        }
        return tempNode;
    }

    public int set(int index, int element) {
        if (index >= this.size() || index < 0) throw new IndexOutOfBoundsException();
        int tempElement = this.get(index);
        LNode tempNode = this.start;
        while (index > 0) {
            tempNode = tempNode.next;
            index -= 1;
        }
        tempNode.value = element;
        if (tempNode.previous != null) tempNode.previous.next = tempNode;
        if (tempNode.next != null) tempNode.next.previous = tempNode;
        return tempElement;
    }

    public boolean addToStart(int element) {
        this.start.next = this.start;
        this.start.value = element;
        this.size += 1;
        return true;
    }

    public boolean add(int element) {
        if (this.size == 0) this.start = new LNode(element);
        else {
            LNode tempNode = this.start;
            while (tempNode.next != null) tempNode = tempNode.next;
            LNode newNode = new LNode(element, null);
            newNode.previous = tempNode;
            tempNode.next = newNode;
        }
        this.size +=  1;
        return true;
    }

    public void add(int index, int element) {
        if (index == this.size()) {
            this.add(element);
            return;
        }
        if (index > this.size() || index < 0) throw new IndexOutOfBoundsException();
        if (this.size == 0) this.start = new LNode(element);
        else if (index == 0) {
            this.start.previous = new LNode(element);
            this.start.previous.next = start;
            this.start = start.previous;
        }
        else {
            LNode tempNode = this.start;
            while (index > 1) {
                tempNode = tempNode.next;
                index -= 1;
            }
            LNode newNode = new LNode(element);
            newNode.previous = tempNode;
            newNode.next = tempNode.next;
            tempNode.next.previous = newNode;
            tempNode.next = newNode;
        }
        this.size += 1;
    }

    public boolean addAfter(LNode location, LNode toBeAdded) {
        toBeAdded.previous = location;
        toBeAdded.next = location.next;
        location.next.previous = toBeAdded;
        location.next = toBeAdded;
        return true;
    }

    public int indexOf(int element) {
        LNode tempNode = this.start;
        int index = 0;
        while (index < size && tempNode.value != element) {
            tempNode = tempNode.next;
            index += 1;
        }
        return (index >= size) ? -1 : index;
    }

    public int remove(int index) {
        if (index >= this.size() || index < 0) throw new IndexOutOfBoundsException();
        LNode tempNode = this.start;
        int tempElement;
        if (index == 0 && this.size == 1) {
            tempElement = tempNode.value;
            this.start = new LNode();
        }
        else if (index == 0 && this.size >= 1) {
            tempElement = tempNode.value;
            this.start.next.previous = null;
            this.start = this.start.next;
        }
        else if (index >= this.size - 1) {
            while (tempNode.next != null) tempNode = tempNode.next;
            tempElement = tempNode.value;
            tempNode.previous.next = null;
        }
        else {
            while (index > 0) {
                tempNode = tempNode.next;
                index -= 1;
            }
            tempElement = tempNode.value;
            tempNode.previous.next = tempNode.next;
            tempNode.next.previous = tempNode.previous;
        }
        this.size -= 1;
        return tempElement;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        String string = "[";
        LNode tempNode = this.start;
        while (tempNode != null) {
            string += tempNode.value + ", ";
            tempNode = tempNode.next;
        }
        if (string.length() > 1) string = string.substring(0, string.length() - 2);
        return string + "]";
    }

    public String toStringDebug() {
        String string = "";
        LNode tempNode = this.start;
        while (tempNode != null) {
            string += tempNode.toString() + "  |  ";
            tempNode = tempNode.next;
        }
        if (string.length() != 0) string = string.substring(0, string.length() - 5);
        return string;
    }

    public LinkedListIterator iterator() {
        return new LinkedListIterator(this);
    }

    public static void main(String[] args) {
        /*
        int[] a = {0, 1, 2, 3, 4};
        MyLinkedList l = new MyLinkedList(a);
        l.add(0, 5);
        l.add(7);
        l.remove(0);
        l.remove(l.size() - 1);
        System.out.println(l.toStringDebug());
        System.out.println(l);
        for (Integer i : l) System.out.print(i + ", ");
        */

        MyLinkedList a= new MyLinkedList();
    	System.out.println(a.toString()+"\nSize: "+a.size());//[], size=0
    	for(int i=0; i<20; i++){
    	    a.add(i);
            System.out.println(a.toStringDebug());
    	    System.out.println(a + "  |  " + a.size());
    	    System.out.println(a.get(a.size() - 1));
    	    if(a.get(a.size()-1)%2==0) {
                System.out.println(a.remove(a.size()-1));
            }
    	    //System.out.println(a);//Check if all nums arent odd
    	}

    }

}
