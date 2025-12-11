import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        // Instantiate an object of HashSet
        HashSet<Integer> hs = new HashSet<>();

      	// Adding elements 
        hs.add(1);
        hs.add(2);
        hs.add(1);

        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
    }
}
