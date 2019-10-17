public class LinkedList<T> implements List<T> {
    protected Node head;
    protected int size;

    // constructor sets head to null and size of the linked list to 0
    public LinkedList(){
        head = null;
        size = 0;
    }

    // class Node
    class Node{
        T data;
        Node next;

        // constructor with no parameters, sets the data and next to null
        public Node(){
            data = null;
            next = null;
        }

        // constructor with parameters for class Node, sets the data of the node to item and the next to null
        public Node(T item){
            data = item;
            next = null;
        }

        // getters:
        public T getData(){
            return data;
        }

        public Node getNext(){
            return next;
        }

        // setters:
        public void setData(T item){
            data = item;
        }

        public void setNext(Node n){
            next = n;
        }
    }

    // adds item to the end of the linked list
    public void add(T item){
        // special case: if the linked list is empty then adding to the list sets the head
        if(head == null){
            head =  new Node(item);
        } else {
            // else need to find the end of the linked list, where the next is null, and set that to the new node
            Node node = new Node(item);
            Node prev = head;
            while(prev.next != null){ // starting at head, finds where the linked list ends
                prev = prev.next;
            }
            prev.next = node;
        }
        size++;
    }

    // adds an item to position pos
    public void add(int pos, T item){

        Node node = new Node(item);

        // special case: adding item to the head
        if(pos == 0){
            node.next = head;
            head = node;
        } else {
            // else need to find the previous node and set the correct next data without losing the rest of the linked list
            Node prev = head;
            for(int i = 0; i<pos-1; i++){
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        ++size;
    }

    // returns the data of the node at pos
    public T get(int pos){
        Node node = head;
        for(int i=0; i<pos-1; i++){ // starting at head, finds the correct node
            node = node.next;
        }
        return node.data;
    }

    // removes and returns the data of the node at pos
    public T remove(int pos){
        Node node; // stores node that is being removed
        // special case: if removing the head, need to set the node to head and the head to head.next
        if(pos == 0){
            node = head;
            head = head.next;
        } else {
            // need to find the previous node, set node to prev.next, and set the next data to skip over the removed node
            Node prev = head;
            for(int i=0; i<pos-1; i++){
                prev = prev.next;
            }
            node = prev.next; // one you want to delete
            prev.next = node.next;
        }
        --size;
        return node.data;
    }

    // returns the size of the linked list
    public int size(){
        return size;
    }
}
