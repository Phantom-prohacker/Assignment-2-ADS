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

    // Метод разворота списка (требуется в задании Section 2.2)
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
        IntList list = new IntList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Original: " + list);
        list.reverse();
        System.out.println("Reversed: " + list);
    }
}