public class LinkedList {
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

    public void add(int index, int data){
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i=0;
        while(i<index-1 && temp != null){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next=newNode;

    }

    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int remove_first(){
        if(head == null){
            System.out.println("The LinkedList is Empty!");
            return Integer.MIN_VALUE;
        }else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

    public int remove_last(){
        if (head==null) {
            System.out.println("The LinkedList is Empty!");
            return Integer.MAX_VALUE;
        } 
        if(head == tail){
            int val =head.data;
            head=tail= null;
            return val;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = temp.next.data;
        tail = temp;
        temp.next=null;

        return val;
    }

    public int llSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if (temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public int recSearchHelper(int key, Node head){
        if(head==null){
            return -1;
        }

        if (key == head.data) return 0;
        int pos = recSearchHelper(key, head.next);
        if (pos == -1) return -1;
        return pos+1;
    }
    public int recSearch(int key){
        return recSearchHelper(key, head);
    }

    public void reverse(){
        Node prev = null; //Previous Node
        Node curr = head; //Current Node, tail node = head node
        tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void deleteNthfromEnd(int n){ //Find & Remove Nth node from End --> Iterative Approach
        //First Calculate Size of Linked List
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        //Remove first
        if (n == size) {
            head = head.next;
            if (head == null) tail = null;
                return;
        }
        // To delete from last --> i = size - n; (here 0 index base linkedlist)
        int iToFind = size-n;
        Node curr = head;
        for (int i = 1; i < iToFind; i++) curr = curr.next;
        curr.next = curr.next.next;
    }

    // Check if LL is Palindrome 
    // 1. Find mid --> Use Slow-Fast technique
    // 2. Reverse half LL after find mid node
    // 3. 1st half(left) == 2nd half(right) ....then it will be palindrome
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow;
    }

    public boolean checkLLisPalindrome(){
        if(head == null || head.next ==null) {
            return true;
        }

        //Step 1 Find mid
        Node midNode = findMid(head);
    
        //Step 2 Reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        
        //Step 3 Check left half & right half
        while(right != null){
            if (left.data != right.data) {
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    //Detect a Loop/Cycle in a LL
    // Using Floyd's finding algorithm (slow/fast pointer)
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //Remove a Loop/Cycle in a LL
    public void removeCycle(){
        // 1. Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast ) {
                cycle = true;
                break;
            }
        }
        if (!cycle) return;
        // 2. Find Meeting point   a) slow = head  b) slow + 1 //   fast +1
        // Find Start of Cycle 
        
        slow = head;
        //Case 1 start at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }

        //Case 2 normal cycle
        Node prev=null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // 3. Break cycle => last.next = null
        prev.next = null;   
    }

    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);

        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(7);

        //add specific index
        // ll.add(1, 9);
        
        // ll.print();
        // System.out.println(ll.remove_first());
        // System.out.println(ll.remove_last());
        // ll.print();
        // System.out.println(ll.llSearch(7));
        // System.out.println(ll.llSearch(9));

        // System.out.println(ll.recSearch(7));
        // System.out.println(ll.recSearch(10));

        // ll.reverse();
        // ll.print();

        // list = 1->9->2->3->4->5->7 
        // ll.deleteNthfromEnd(2);
        // ll.print();

        ///Check if LL is a palindrome?
        // LinkedList list = new LinkedList();
        // list.addLast(1);
        // list.addLast(2);
        // list.addLast(3);
        // list.addLast(2);
        // list.addLast(1);

        // list.print();
        // if(list.checkLLisPalindrome()){
        //     System.out.println("The LinkedList is Palindrome");
        // }else System.out.println("The LinkedList is not Palindrome");

        //Detect a Loop/Cyle in a LL
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // create cycle: 3 -> 1
        list.tail.next = list.head;

        System.out.println(list.isCycle());
        list.removeCycle();;
        System.out.println(list.isCycle());

    }
}
