package de.fuas.algorithms;

public class SLList<T> implements List<T> {

    private int size;
    private Node<T> first;

    public SLList() {
        this.first = null; // just for clearance. it's null anyway
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    public int naiveSize() {
        Node<T> current = this.first;

        int sizeCounter = 0;
        while (current != null) {
            current = current.next;
            sizeCounter++;
        }
        return sizeCounter;
    }

    public T get(int index) {
        indexOutOfBoundsException(index, this.size);
        return nodeAt(index).value;
    }

    public void add(int index, T value) {
        indexOutOfBoundsException(index, this.size + 1);
        if (index == 0) {
            this.first = new Node<T>(value, this.first);
        } else {
            Node<T> prevNode = nodeAt(index - 1);
            prevNode.next = new Node<T>(value, prevNode.next);
            /**
             * this could also be done in a single line nodeAt(index - 1).next = new
             * Node<T>(value, nodeAt(index)); but for that we would need to access nodeAt()
             * twice and it's hard to read. Therefore I figured it would be best to do it
             * this way.
             */
        }
        size++;
    }

    public T remove(int index) {
        indexOutOfBoundsException(index, this.size);
        Node<T> removedNode;
        if (index == 0) {
            removedNode = this.first;
            this.first = this.first.next;
        } else {
            Node<T> prevNode = nodeAt(index - 1);
            removedNode = prevNode.next;
            // could also be done with prevNode.next.next;
            prevNode.next = removedNode.next;
        }
        this.size--;
        return removedNode.value;
    }

    private Node<T> nodeAt(int index) {
        Node<T> currentNode = this.first;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private void indexOutOfBoundsException(int index, int upperBoundary) {
        if (index < 0 || index >= upperBoundary) {
            throw new IndexOutOfBoundsException("Index ist ungültig");
        }
    }
}