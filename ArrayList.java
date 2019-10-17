public class ArrayList<T> implements List<T> {
    protected T[] a;
    protected int size;

    // constructor creates the array for the arraylist and initializes the size of the arraylist to 0
    public ArrayList(){
        a = (T[]) new Object[10];
        size = 0;
    }

    // adds an item to the end of the arraylist and if needed, grows the array
    public void add(T item){
        if(size == a.length){
            grow_array();
        }
        a[size++] = item;
    }

    // adds an item to pos in the arraylist and if needed, grows the array
    public void add(int pos, T item){
        if(size == a.length){
            grow_array();
        }

        // shifts the items of the array to make space at pos for new item
        for(int i = size-1; i > pos; i--){
            a[i+1] = a[i];
        }
        a[pos] = item;
        size++;
    }

    // returns the item at the given position
    public T get(int pos){
        return a[pos];
    }

    // removes and returns the item at pos
    public T remove(int pos){

        T temp = a[pos]; // item we want to delete

        // shifts all of the other items to replace what was removed
        for(int i = pos; i < size-1; i++){
            a[i] = a[i+1];
        }
        --size;
        return temp;
    }

    // returns the size of the arraylist
    public int size(){
        return size;
    }

    // grows the array by creating a new array, doubling the size and copying the original content
    private void grow_array(){
        int newSize = a.length*2;
        T[] new_a = (T[]) new Object[newSize];
        System.arraycopy(a, 0, new_a, 0, a.length);
        a = new_a;
    }
}
