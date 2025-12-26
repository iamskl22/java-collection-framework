public class ReverseDoublyLL {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head;
    private Node tail;  
    private int size;

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void reverse() {
        Node curr = head;
        Node temp = null;
        Node oldHead = head;  // Save original head for tail

        while (curr != null) {
            // Swap next and prev
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // Move to the next node (which is prev due to swap)
            curr = curr.prev;
        }

        // Adjust head and tail
        if (temp != null) {
            head = temp.prev;
        }
        tail = oldHead;  // New tail is the original head
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "<->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ReverseDoublyLL dll = new ReverseDoublyLL();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.print();  // 1<->2<->3<->null

        dll.reverse();
        dll.print();  // 3<->2<->1<->null

        System.out.println("Size: " + dll.getSize()); // Size: 3
    }
}