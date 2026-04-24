public class StackArray {
    private IntArray storage;

    public StackArray() {
        storage = new IntArray();
    }

    public void push(int item) {
        storage.add(item);
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return storage.removeLast();
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return storage.get(storage.size() - 1);
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public int size() {
        return storage.size();
    }
    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push(77);
        stack.push(88);
        System.out.println("Stack top: " + stack.pop()); // Должно вывести 88
    }
}