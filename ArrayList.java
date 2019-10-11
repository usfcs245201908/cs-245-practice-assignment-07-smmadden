public class ArrayList<T> implements List<T> {
    // need constructor
    protected T[] a;
    protected int size;

    public ArrayList(){
        a = (T[]) new Object[10];
        size = 0;
    }

    public void add(T item){
        if(size == a.length){
            grow_array();
        }
        a[size++] = item;
    }

    public void add(int pos, T item){

        if(size == a.length){
            grow_array();
        }
        for(int i = size-1; i > pos; i--){
            a[i+1] = a[i];
        }
        a[pos] = item;
        size++;
    }

    public T get(int pos){
        return a[pos];
    }

    public T remove(int pos){

        T temp = a[pos];

        for(int i = pos; i < size-1; i++){ // shifting all of the items after removing

            a[i] = a[i+1];
        }
        --size;
        return temp;

    }

    public int size(){
        return size;

    }

    private void grow_array(){
        int newSize = a.length*2;
        T[] new_a = (T[]) new Object[newSize];
        System.arraycopy(a, 0, new_a, 0, a.length);
        a = new_a;
    }

    public void display(){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }


    // return a null for throwing exceptions if you need to but don't need to throw exceptions or have an iterator
}
