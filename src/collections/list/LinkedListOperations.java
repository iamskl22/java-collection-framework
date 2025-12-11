import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList2 {
    public static void main(String[] args) {
        //Create a LinkedList of Integer
        LinkedList<Integer> ll = new LinkedList<>();

       // 1. Add elements
       ll.add(1); //add end
       ll.add(2);
       ll.add(3);
       System.out.println("List after adding elements: "+ll);
    
        // 2. Add element at the first position
        ll.addFirst(0);
        System.out.println("After addFirst(0): "+ll);

        // 3. Add element at the last position
        ll.addLast(4);
        System.out.println("After addLast(4): "+ll);

        // 4. Insert element at a specific index
        ll.add(2, 9);
        System.out.println("After add(2, 9): "+ll);

        // 5. Remove elements
        ll.remove(); // remove first element
        System.out.println("After romove(): "+ll);

        ll.removeFirst(); //remove first
        System.out.println("After removeFirst(): "+ll);

        ll.removeLast(); //remove last
        System.out.println("After removeLast(): "+ll);

        ll.remove(Integer.valueOf(20)); // remove by value
        System.out.println("After remove(20): "+ll);

        // 6. Search for an element --> contains(Object o) check if element exists
        // indexOf(Object o) --> first occurrence
        // lastIndexOf(Object o) --> last occurrence
        // isEmpty() --> check if list is empty
        boolean contains9 = ll.contains(9);
        System.out.println("List contains 9? "+contains9);

        // 7. Get element by index --> get(int index), getFirst(), getLast()
        System.out.println("Element at index 1: "+ll.get(1));
        
        // 8. Iterate using for-each
        System.out.println("Iterating using for-each: ");
        for (int num : ll) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 9. Iterate using iterator
        System.out.println("Iterating using iterator: ");
        Iterator<Integer> it = ll.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 10. Size of LinkedList
        System.out.println("Size of the list: " + ll.size());

        // 11. Remove all elements
        //      ll.clear();

        // 12. Update element at specific index -->set(int index, E element)
        // ll.set(0, 10);
 
    }
}
