public class StackLL {
    private Node top;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackLL() {
        top = null;
        size = 0;
    }

    // Push an element onto the stack
    public void push(Object element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Remove and return the top element
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Object poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }

    // Return the top element without removing it
    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the size of the stack
    public int size() {
        return size;
    }   

    // String representation of the stack
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        sb.append("[");
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackLL stack = new StackLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.size());
    }
}
