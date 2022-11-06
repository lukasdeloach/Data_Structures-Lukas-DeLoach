/*
 * Purpose: Honors Data Structure and Algorithms Midterm
 * Status: Complete and thoroughly tested
 * Last update: 10/18/22
 * Submitted:  10/18/22
 * Comment: test suite and sample run attached
 * Comment: I declare that this is entirely my own work
 * @author: Lukas DeLoach
 * @version: 2022.18.10
 */
public class DEQ<T> extends QueueCRAB<T> implements ExtendedQueueInterface<T> {

    @Override
    /**
     * Method to add an item to the front of a queue
     */
    public void enqueueFront(T newItem) throws ExtendedQueueException {
        if(numItems==items.length) {
            resize();
        }
        front = (front+items.length-1)%items.length;
        items[front] = newItem;
        numItems++;
    }

    @Override
    /**
     * Method to remove item from back and return the removed item
     * @return T
     */
    public T dequeueBack() throws ExtendedQueueException {
        if(!isEmpty()) {
            back = (back+items.length-1)%items.length;
            T result = items[back];
            items[back] = null;
            numItems--;
            return result;
        }
        else {
            throw new ExtendedQueueException("DEQ is empty");
        }
    }

    @Override
    /**
     * Method to return item from the back of the queue
     * @return T
     */
    public T peekBack() throws ExtendedQueueException {
        if(numItems != 0) {
            T result;
            result = items[(back-1+items.length)%items.length];
            return result;
        }
        else {
            throw new QueueException("Queue is empty");
        }
    }
}

