package lab3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QueueOfDistinctStrings {
// Overview: QueueOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// FIFO (First-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
//     The abstraction function represents the queue as a list that contains the front and end of the queue, 
//     as well as the set of elements in the queue.
//     
//     The implementation is done in the toString() method 
//
//     AF(c) = an abstract queue d   (where c is a Java QueueOfDistinctStrings object)
//                 where d.front = c.items.get(0);
//                       d.end = c.items.get(c.items.size()-1)
//                       d.collection = c.items
//
// The rep invariant is:
// b) Write the rep invariant here
//    The rep invariant is a condition that must hold for any representation of the queue. 
//    The rep invariant for the queue of distinct strings is as follows:
//
//    RI(c) = true if and only if all elements in the arraylist appear exactly once
//          = false otherwise 
//
//

//the rep
    private ArrayList<String> items;

// constructor
    public QueueOfDistinctStrings() {
// EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }

// MODIFIES: this
// EFFECTS: Appends the element at the end of the queue
// if the element is not in the queue, otherwise
// does nothing.
    public void enqueue(String element) throws Exception {
        if (element == null) {
            throw new Exception();
        }
        if (false == items.contains(element)) {
            items.add(element);
        }
    }

    public String dequeue() throws Exception {
// MODIFIES: this
// EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0) {
            throw new Exception();
        }
        return items.remove(0);
    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here

        Set<String> elements = new HashSet<>(items);
        return elements.size() == items.size();
// If the size of the set is equal to the size of the queue, it means that all elements in the queue are unique and the rep invariant holds. 
// If the size of the set is smaller than the size of the queue, it means that there are duplicate elements in the queue and the rep invariant does not hold

    }

    public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// queue, the front element and the end element.
// Implements the abstraction function.
// d) Write the code for the toString() here

        return "Collection: " + items + ", Front: " + items.get(0) + ", End: " + items.get(items.size() - 1);
    }

}

