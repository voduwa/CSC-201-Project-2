import java.util.Collections;

public class Minheap <E extends Comparable> {
    private E[] heap;       //heap pointer
    private int size;       //heap size
    private int num;        //number of things in the heap

    public Minheap (){

    }
    public Minheap (E[] heap, int size, int num){
        this.heap = heap;
        this.size = size;
        this.num = num;
        buildHeap();
    }

    //getters
    public int heapSize() {return this.size;}

    public int getNum() {return this.num;}

    public E[] getHeap() {
        return heap;
    }

    public E getRoot (){
        return heap[0];
    }

    //Checks to see if position is a leaf node
    public boolean isLeaf(int pos){
        return (pos >= num/2) && (pos < num);
    }

    //Return position for left child of pos
    public int leftChild (int pos){
        if (pos >= num/2) {return -2;}
        return 2*pos + 1;
    }

    //Return position for right child of pos
    public int rightChild (int pos) {
        if (pos >= (num - 1)/2) {return -1;}
        return 2*pos + 2;
    }

    //Return position for parent
    public int parent (int pos) {
        if (pos <= 0) {return -1;}
        return (pos - 1)/2;
    }

    //Insert val into heap
    public void insert (E key){
        if (num >= size){
            System.out.println("Heap is full");
            return;
        }
        int curr = num++;
        heap[curr] = key;

        while ((curr !=0) && (heap[curr].compareTo(heap[parent(curr)]) < 0)) {
            //Swap.swap(heap, curr, parent(curr));
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    //Heapify contents of Heap
    public void buildHeap ()
    {for (int i = num/2-1; i>=0 ; i--) {siftDown(i);}}

    //Put element in its correct place
    public void siftDown(int pos) {
        if ((pos < 0) || (pos >=num)) {
            return; // illegal position
        }
        while (!isLeaf(pos)){
            int j = leftChild(pos);
            if ((j < (num-1)) && (heap[j].compareTo(heap[j+1]) > 0)){
                j++;
            }

            if (heap[pos].compareTo(heap[j]) <= 0) {return;}
            swap(pos, j);
            pos = j;
        }
    }

    //Remove and return maximum val
    public E removeMin () {
        if (num == 0) {return null;} //removing from empty heap
        swap(0, --num);
        E temp = heap[num];
        siftDown(0);
        return temp;
    }


    //Remove and return element at specified position
    public E remove (int pos) {
        if ((pos < 0) || (pos >= num)) {return null; }
        if (pos == (num -1)) {num--;}
        else {
            swap (pos, --num);
            update(pos);
        }
        return heap[num];
    }


    //Modify the value at the given position
    public void modify(int pos, E newVal) {
        if ((pos < 0) || (pos >= num)) { return; } // Illegal heap position
        heap[pos] = newVal;
        update(pos);
    }

    // The value at pos has been changed, restore the heap property
    public void update(int pos) {
        // If it is a big value, push it up
        while ((pos > 0) && (heap[pos].compareTo(heap[parent(pos)]) < 0)) {
            swap(pos, parent(pos));

            pos = parent(pos);
        }
        siftDown(pos); // If it is little, push down
    }

    private void swap(int fpos, int spos)
    {
        E tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    //add toString for debugging
}
