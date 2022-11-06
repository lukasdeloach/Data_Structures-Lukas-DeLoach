public class DNode<T> {

    private DNode back;
    private T item;
    private DNode next;

    public DNode(T item) {
        this.item = item;
        back = next = this;
    }

    public DNode(T item, DNode back, DNode next){
            this.item = item;
            this.back = back;
            this.next = next;
    }

    public void setItem(T newItem)
    {
        item = newItem;
    } // end setItem

    public T getItem()
    {
        return item;
    } // end getItem

    public void setBack(DNode backNode){
             back = backNode;
    }

    public DNode getBack(){
            return back;
    }

    public void setNext(DNode nextNode)
    {
        next = nextNode;
    } // end setNext

    public DNode getNext()
    {
        return next;
    } // end getNext
} // end class Node
