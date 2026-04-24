import java.util.Arrays;

/// A resizable array of integers.
public class IntArray {
    private int[] array;
    private int size;

    public IntArray(){
        array = new int[4];
        size = 0;
    }

    public IntArray(int []items){
        this();
        for (int item : items) {
            add(item);
        }
    }

    public int size() {
        return size;
    }

    public int get(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public int set(int index, int item){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        int old = array[index];
        array[index] = item;
        return old;
    }

    public void add(int item){
        if (size == array.length) {
            grow();
        }
        array[size++] = item;
    }

    private void grow() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void addAt(int index, int item){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == array.length) grow();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    public int remove(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        int old = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return old;
    }

    public int removeFirst(){ return remove(0); }

    public int removeLast(){ return remove(size - 1); }

    public boolean removeItem(int item){
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public int indexOf(int item){
        for (int i = 0; i < size; i++) {
            if (array[i] == item) return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        IntArray a = new IntArray();
        a.add(5);
        a.add(10);
        a.add(15);
        System.out.println("Size: " + a.size()); // Должно быть 3
        System.out.println("First element: " + a.get(0)); // Должно быть 5
        System.out.println("Array: " + a); // Должно быть [5, 10, 15]
    }
}