public class Zig_ZagLL {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data= data;
            this.next=null;
        }
    }

    private Node head;
    private Node tail;

    public void add(int data){ //add last
        Node newNode = new Node(data);
        if (head==null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void zigZag(){
        // find mine node
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node head1 = head;
        Node head2 = prev;

        // alternate merge -> Zig-Zag merge
        Node next1;
        Node next2;
        while(head1 != null && head2 != null){
            next1 = head1.next;
            head1.next = head2;
            next2 = head2.next;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
       Zig_ZagLL ll = new Zig_ZagLL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

        ll.printList();
        ll.zigZag();
        ll.printList();
    }
}
