/*
 * Purpose: Honors Data Structure and Algorithms Midterm
 * Status: Complete and thoroughly tested
 * Last update: 10/04/22
 * Submitted:  10/04/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Lukas DeLoach
 * @version: 2022.04.10
 */

public class List<T> implements ListInterface<T> {

    private DNode tail; // reference to linked list of items
    private int numItems;
    /**
     * Constructor for the class
     */
    public List() {
        tail = null;
        numItems = 0;
    }  // end default constructor

    /**
     * Checks to see if the collection is empty by calling the size method and seeing if it is == 0
     * @return boolean
     */
    public boolean isEmpty()
    {
        return numItems == 0;
    }  // end isEmpty

    /**
     * Traverses through the Linked structure to and counts the size.
     * Only does one check to see if the temporary variable holding a node is not null.
     * @return numItems - int value
     */
    public int size()
    {
        return numItems;
    }  // end size

    private DNode find(int index)
    {
        // --------------------------------------------------
        // Locates a specified node in a linked list.
        // Precondition: index is the number of the desired
        // node. Assumes that 0 <= index <= numItems
        // Postcondition: Returns a reference to the desired
        // node.
        //  --------------------------------------------------
        DNode curr = tail.getNext();
        int size = size();
        if(index < size/2) {
            for(int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
        } else {
            for(int i = size; i > index; i--) {
                curr = curr.getBack();
            }
        }
        return curr;
    } // end find  // end find

    public T get(int index)
    throws ListIndexOutOfBoundsException
    {
        if(index>=0 && index<numItems) {
            T result = (T) find(index).getItem();
            return result;
        }
        else {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on get");
        } // end if
    } // end get

    /**
     * Updated add method that first checks to see if the provided index is 0.
     * If it is then we add a new node.
     * Else we create a local variavle called prev and that holds the node before the provided index.
     * We then add a node at that index and have it reference the Node that was previously at that index
     */
    public void add(int index, T item)
    throws ListIndexOutOfBoundsException
    {
        if(index>=0 && index <= numItems) {
            if(numItems==0) {
                tail = new DNode(item);
                numItems++;
            }

            else {
                DNode curr = find(index%numItems); //Modular check if index == numItems find will get 0
                DNode newNode = new DNode(item, curr.getBack(), curr);
                curr.setBack(newNode);
                newNode.getBack().setNext(newNode);
                if(index==numItems) { //Check to see if tail needs to be updated
                    tail = newNode;
                }
                numItems++;
            }
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on add");
        } // end if
    }  // end add

    /**
     * Updated remove method for New Find B!
     * First does validation check.
     * If it is removes it by setting the head to the next node. Since the first node is now not referecning anything, it will be garbage collected.
     * Else, we find the previous node and update its reference to the index+1 node.
     * Again, now that the node at the index is not referencing anything, it will be garbge collected
     */
    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if(index>=0 && index<=numItems) {
            DNode curr = find(index);
            DNode next = curr.getNext();
            DNode prev = curr.getBack();
            prev.setNext(next);
            next.setBack(prev);
            if(index==numItems-1) {
                tail = prev;
            }
            numItems--;
        } else {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
    }   // end remove

    /**
     * Removes all of the items in a list by setting the tail to null
     */
    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        tail = null;
    } // end removeAll

    /**
     * toString method that iterates through the Linked structure and appends the item to the string builder.
     * Does only one check to make sure temp is not null.
     * @return string
     */
    public String toString() {
        DNode temp = tail;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < numItems; i++) {
            temp = temp.getNext();
            str.append(temp.getItem() + " ");
        }
        return str.toString();
    }

    /**
     * Reverse toString
     * @return str
     */
    public String toStringR() {
        DNode temp = tail;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < numItems; i++) {
            str.append(temp.getItem() + " ");
            temp = temp.getBack();
        }
        return str.toString();
    }
}

