package org.example.asdc;

public class ProductLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        private Product data;
        private Node next;
        private Node prev;

        public Node(Product data) {
            this.data = data;
        }
    }

    public void add(Product data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(int id) {
        Product data = this.find(id);
        Node current = head;
        while(current != null) {
            if(current.data == data) {
                if(current == head) {
                    head = current.next;
                    head.prev = null;
                } else if(current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public Product find(int id) {
        Node current = head;
        while(current != null) {
            if(current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseAndPrint() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
