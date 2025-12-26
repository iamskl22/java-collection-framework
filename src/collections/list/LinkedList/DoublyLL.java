public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void removeFirst(){
        if(size == 0){
            System.out.println("DLL is empty");
            return;
        } else if(size == 1){
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }
    public void removeLast(){
        if(size == 0){
            System.out.println("DLL is empty");
            return;
        } else if(size == 1){
            head = tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "<->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(2);    
        dll.addFirst(1);
        dll.addLast(3);
        dll.addLast(4);
        dll.print();  // 1<->2<->3<->4<->null
        dll.removeFirst();
        dll.print();  // 2<->3<->4<->null
        dll.removeLast();
        dll.print();  // 2<->3<->null

    }
}