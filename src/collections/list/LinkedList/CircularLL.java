public class CircularLL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node last;
    private int size;

    public CircularLL() {
        last = null;
        size = 0;
    }

    public void addToEmpty(int data) {
        if (last != null) return;
        Node newNode = new Node(data);
        last = newNode;
        newNode.next = last;
        size++;
    }

    public void addFront(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        size++;
    }

    public void addEnd(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void addAfter(int data, int item) {
        if (last == null) return;
        Node p = last.next;
        do {
            if (p.data == item) {
                Node newNode = new Node(data);
                newNode.next = p.next;
                p.next = newNode;
                if (p == last) last = newNode;
                size++;
                return;
            }
            p = p.next;
        } while (p != last.next);
        System.out.println(item + " The given node is not present in the list");
    }

    public void deleteNode(int key) {
        if (last == null) return;
        if (last.data == key && last.next == last) {
            last = null;
            size--;
            return;
        }
        Node temp = last;
        if (last.data == key) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
            size--;
            return;
        }
        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next != last && temp.next.data == key) {
            temp.next = temp.next.next;
            size--;
        }
    }

    public void traverse() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
        Node p = last.next;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        cll.addToEmpty(6);
        cll.addEnd(8);
        cll.addFront(2);
        cll.addAfter(10, 2);
        cll.traverse();  // 2 10 6 8
        cll.deleteNode(8);
        cll.traverse();  // 2 10 6
        System.out.println("Size: " + cll.getSize());
    }
}
