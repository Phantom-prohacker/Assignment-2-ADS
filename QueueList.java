public class QueueList {
    private IntList storage;

    public QueueList() {
        storage = new IntList();
    }

    public void enqueue(int item) {
        storage.add(item);
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return storage.removeFirst();
    }

    public boolean isEmpty() {
        return storage.size() == 0;
    }

    public int size() {
        return storage.size();
    }

    public static void main(String[] args) {
        QueueList q = new QueueList();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Queue Dequeue: " + q.dequeue()); // Должно быть 10
    }
}