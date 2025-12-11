import java.util.LinkedList;

public class LinkedList_mergeSort {

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head==null) {
            head = tail = newNode;
            return;
        }
        newNode.next= head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if (head==null) {
            head = tail = newNode;
            return;
        }
        tail.next =newNode;
        tail = newNode;

    }

    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow;
    }

    public Node merge(Node left, Node right){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //Find mid
        Node mid = getMid(head);

        // left & right merge sort
        Node rightHead =mid.next;
        mid.next = null;
        
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }
    public void sort(){
        head = mergeSort(head);
    }

    public static void main(String[] args) {
        LinkedList_mergeSort ll = new LinkedList_mergeSort();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        // 4->3->2->1
        ll.sort();
        ll.print();
    }
}
