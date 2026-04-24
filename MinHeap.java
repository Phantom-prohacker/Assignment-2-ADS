public class MinHeap {
    private IntArray storage;

    public MinHeap() {
        storage = new IntArray();
    }

    public void insert(int item) {
        storage.add(item);
        bubbleUp(storage.size() - 1);
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (storage.get(index) < storage.get(parentIndex)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else break;
        }
    }

    private void swap(int i, int j) {
        int temp = storage.get(i);
        storage.set(i, storage.get(j));
        storage.set(j, temp);
    }

    public int extractMin() {
        if (storage.isEmpty()) throw new RuntimeException("Heap is empty");
        int min = storage.get(0);
        int lastItem = storage.removeLast();
        if (!storage.isEmpty()) {
            storage.set(0, lastItem);
            bubbleDown(0);
        }
        return min;
    }

    private void bubbleDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < storage.size() && storage.get(left) < storage.get(smallest)) smallest = left;
            if (right < storage.size() && storage.get(right) < storage.get(smallest)) smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    public boolean isEmpty() { return storage.isEmpty(); }
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(50);
        heap.insert(10);
        heap.insert(30);
        System.out.println("Min from heap: " + heap.extractMin()); // Должно вывести 10
    }
}