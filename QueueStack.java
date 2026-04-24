public class QueueStack {
    private StackArray stack1 = new StackArray();
    private StackArray stack2 = new StackArray();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int item = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return item;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        QueueStack qs = new QueueStack();
        qs.enqueue(5);
        qs.enqueue(15);
        System.out.println("Queue Dequeue: " + qs.dequeue()); // Должно быть 5
    }
}