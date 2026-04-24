public class IntList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public int size() { return size; }

    public void add(int item) {
        if (head == null) {
            head = new Node(item);
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new Node(item);
        }
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        return temp.data;
    }

    public int removeFirst() {
        if (head == null) throw new java.util.NoSuchElementException();
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) sb.append(", ");
            temp = temp.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        // Тест Списка
        IntList list = new IntList();
        list.add(1); list.add(2); list.add(3);
        System.out.println("Original list: " + list);
        list.reverse();
        System.out.println("Reversed list: " + list);

        // Тест Кучи (Heap)
        System.out.println("\n--- Testing MinHeap ---");
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        System.out.println("Min from heap (should be 5): " + heap.extractMin());
    }
}