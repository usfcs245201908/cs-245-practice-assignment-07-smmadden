public class LinkedList<T> implements List<T> {
    protected Node head;
    protected int size;

    public LinkedList(){
        head = null;
        size = 0;

    }

    class Node{
        T data;
        Node next;

        public Node(){ // constructor with no parameters
            data = null;
            next = null;
        }
        public Node(T item){ // constructor with data parameters
            data = item;
            next = null;
        }

        public T getData(){
            return data;
        }

        public Node getNext(){
            return next;
        }

        public void setData(T item){
            data = item;
        }

        public void setNext(Node n){
            next = n;
        }
    }

    public void add(T item){
        if(head == null){
            head =  new Node(item); // constructor has it setting the
            // data and the next to null
            size++;  // could just increase the size at the very end
        } else {
            Node node = new Node(item);
            Node prev = head;
            while(prev.next != null){
                prev = prev.next;
                // usually getNext bc of setters and getters
            }
            prev.next = node;
            size++;
        }

    }

    public void add(int pos, T item){

        Node node = new Node(item);

        if(pos == 0){
            // need do other stuff that looks like other stuff
            node.next = head;
            head = node;
            size++;
        } else {
            Node prev = head;
            for(int i = 0; i<pos-1; i++){
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
            ++size;
        }


    }

    public T get(int pos){
        Node node = head;
        for(int i=0; i<pos-1; i++){
            node = node.next;
        }
        return node.data;
    }

    public T remove(int pos){ // basic remove test
        Node node;
        if(pos == 0){
            node = head;
            head = head.next;
        } else {
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

    public int size(){
        return size;
    }

    public void display(){
        Node node = head;
        for(int i=0; i<size; i++){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
