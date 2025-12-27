import java.util.ArrayList;

public class Stack {
    private ArrayList<Object> elements;     

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(Object element) {
        elements.add(element);
    }

    public Object pop() {
        if (elements.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public Object peek() {
        if (elements.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }   

    @Override
    public String toString() {
        return elements.toString();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
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
