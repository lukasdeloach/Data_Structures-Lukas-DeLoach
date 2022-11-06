import java.util.Queue;

public class QueueCRAB<T> implements QueueInterface<T> {

    protected T[] items;
    protected int front;
    protected int back;
    protected int numItems;

    public QueueCRAB() {
        this.front = this.back = this.numItems = 0;
        items = (T[]) new Object[3];
    }

    @Override
    /**
     * Checks to see if Queue is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return numItems==0;
    }

    @Override
    /**
     * Adds item to back of the queue
     */
    public void enqueue(T item) throws QueueException {
        if(numItems==items.length) {
            resize();
        }
        items[back] = item;
        back = (back+1)%items.length;
        numItems++;
    }

    @Override
    /**
     * Removes item from front of the queue and returns it
     * @return T
     */
    public T dequeue() throws QueueException {
        T result = items[front];
        items[front] = null;
        front = (front+1)%items.length;
        numItems--;
        return result;
    }

    @Override
    /**
     * Returns item from front of the queue
     * @return T
     */
    public T peek() throws QueueException {
        if(numItems != 0) {
            T result;
            result = items[front];
            return result;
        }
        else {
            throw new QueueException("Queue is empty");
        }
    }

    @Override
    /**
     * Removes all items from queue
     */
    public void dequeueAll() {
        items = (T[]) new Object[3];
        this.numItems = this.front = this.back = 0;
    }

    /**
     * Resizes the array by twice the amount.
     * Copies elements over and adjusts values.
     */
    protected void resize() {
        T[] temp = (T[]) new Object[1<<items.length];
        for(int i = 0; i < numItems; i++) {
            temp[i] = items[(front+i) % items.length]; //in circular fasion
        }
        items = temp;
        front = 0;
        back = numItems;
    }

    /**
     * Iterates through queue and appends items to String builder
     * @return String
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < numItems; i++) {
            str.append(items[(front+i)%items.length] + " ");
        }
        return str.toString();
    }
}
