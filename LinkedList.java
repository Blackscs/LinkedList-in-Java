package dataStructure;

/**
 * A singly linked list implementation.
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    /**
     * Node class represents each element in the LinkedList.
     */
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    /**
     * Constructor to initialize the LinkedList with a single node.
     * @param data the data for the initial node.
     */
    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        tail = newNode;
        head = newNode;
    }

    /**
     * Prints the data of the tail node.
     */
    public void getTail() {
        if (this.tail == null) {
            System.out.println("Null list!");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    /**
     * Prints the data of the head node.
     */
    public void getHead() {
        if (this.head == null) {
            System.out.println("Null list!");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    /**
     * Prints the length of the list.
     */
    public void getLength() {
        System.out.println("Length list: " + this.length);
    }

    /**
     * Empties the list.
     */
    public void makeEmpty() {
        tail = null;
        head = null;
        length = 0;
    }

    /**
     * Removes the last node from the list.
     * @return the removed node.
     */
    public Node removeLast() {
        if (length == 0) return null;
        if (length == 1) {
            Node temp = head;
            tail = null;
            head = null;
            length = 0;
            return temp;
        }

        Node temp = this.head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        Node removedNode = tail;
        tail = temp;
        tail.next = null;
        length--;

        return removedNode;
    }

    /**
     * Prints the entire list.
     */
    public void print() {
        System.out.println("############################");
        if (head == null) {
            System.out.println("Empty list!");
        } else {
            Node temp = this.head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
        System.out.println("############################");
    }

    /**
     * Appends a node to the end of the list.
     * @param data the data for the new node.
     */
    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    /**
     * Prints the current status of the list including length, elements, head, and tail.
     */
    public void getStatusList() {
        getLength();
        print();
        getTail();
        getHead();
    }

    /**
     * Prepends a node to the start of the list.
     * @param data the data for the new node.
     */
    public void prepend(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * Removes the first node from the list.
     * @return the removed node.
     */
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    /**
     * Retrieves the node at a specific index.
     * @param index the index of the node.
     * @return the node at the specified index.
     */
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Inserts a node at a specific index.
     * @param index the index at which to insert the node.
     * @param data the data for the new node.
     * @return true if the node was inserted, false otherwise.
     */
    public boolean insert(int index, String data) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(data);
            return true;
        }
        if (index == length) {
            append(data);
            return true;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    /**
     * Updates the data of a node at a specific index.
     * @param index the index of the node to update.
     * @param data the new data for the node.
     * @return true if the node was updated, false otherwise.
     */
    public boolean set(int index, String data) {
        if (index < 0 || index >= length) {
            return false;
        }
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            return true;
        }
        return false;
    }

    /**
     * Removes a node at a specific index.
     * @param index the index of the node to remove.
     * @return the removed node.
     */
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null; // Desconectar o nó removido da lista

        length--;

        return temp;
    }

    /**
     * Main method to test the LinkedList.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList("value1");

        list.append("value2");
        list.append("value3");
        list.append("value4");
        list.remove(0);
        list.getStatusList();
    }
}
