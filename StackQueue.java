public class StackQueue {
    private QueueList queue = new QueueList();

    public void push(int item) {
        int size = queue.size();
        queue.enqueue(item);
        for (int i = 0; i < size; i++) {
            queue.enqueue(queue.dequeue());
        }
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return queue.dequeue();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        System.out.println("Stack Pop: " + sq.pop()); // Должно быть 2
    }
}