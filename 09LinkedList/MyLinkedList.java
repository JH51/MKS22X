import java.util.*;

public class MyLinkedList {

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
            if (this.next != null) {
                string += this.previous.value + ", " + this.value + ", " + this.next.value;
                LNode tempNode = this.next;
                while (this.next != null) {
                    string += this.previous.value + ", " + this.value + ", " + this.next.value;
                    tempNode = tempNode.next;
                }
            }
            return string;
        }
    }



    private LNode start, end;
    private int size;

    public MyLinkedList() {

    }

    public MyLinkedList(int[] data) {
        start = new LNode();
        end = new LNode();
        for (int i = 0; i < data.length; i += 1) {
            this.add(data[i]);
        }
        this.size = data.length;
    }

    public MyLinkedList(int[] data, int size) {
        for (int i = 0; i < size; i += 1) this.add(data[i]);
        this.size = size;
    }

    public int get(int index) {
        LNode tempNode = this.start;
        while (index > 0) {
            tempNode = tempNode.next;
            index -= 1;
        }
        return tempNode.value;
    }

    public LNode getNthNode(int index) {
	LNode tempNode = this.start;
	while (index > 0) {
	    tempNode = tempNode.next;
	    index -= 1;
	}
	return tempNode;
    }

    public int set(int index, int element) {
        int tempElement = this.get(index);
        LNode tempNode = start;
        while (index > 0) {
            tempNode = tempNode.next;
            index -= 1;
        }
        tempNode.value = element;
        return tempElement;
    }

    public boolean addToStart(int e) {
        this.start = new LNode(e, this.start);
        this.size += 1;
        return true;
    }

    public boolean add(int element) {
        if (this.size == 0) start = new LNode(element);
        else {
            LNode tempNode = start;
            while (tempNode.next != null) tempNode = tempNode.next;
            LNode newNode = new LNode(element, null);
            newNode.previous = tempNode;
            tempNode.next = newNode;
        }
        this.size +=  1;
        return true;
    }

    public int indexOf(int element) {
	LNode tempNode = start;
	int index = 0;
	while (index < size && tempNode.value != element) {
	    index += 1;
	    tempNode = tempNode.next;
	}
	return (index >= size) ? -1 : index;
    }

    public int remove(int index) {
        LNode tempNode = start;
        int element;
        while (index > 1) {
            tempNode = tempNode.next;
            index -= 1;
        }
        element = tempNode.value;
        tempNode.next = tempNode.next.next;
        this.size -= 1;
        return element;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        String string = "[";
        LNode tempNode = start;
        while (tempNode != null) {
            string += tempNode.value + ", ";
            tempNode = tempNode.next;
        }
        if (string.length() > 1) string = string.substring(0, string.length() - 2);
        return string + "]";
    }

    public String toStringDebug() {
	String string = "";
	LNode tempNode = start;
	while (tempNode != null) {
	    string += tempNode.toString();
	    tempNode = tempNode.next;
	    string += " | ";
	}
        if (string.length() > 1) string = string.substring(0, string.length() - 2);
        return string;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4};
        MyLinkedList l = new MyLinkedList(a);
        System.out.println();
        l.add(5);
        l.add(7);
        l.remove(3);
        l.set(1, 10);
        System.out.println(l);
	System.out.println(l.indexOf(10) + " : " + l.get(l.indexOf(10)));
        for (int i : a) System.out.print(i + ", ");
    }

}
