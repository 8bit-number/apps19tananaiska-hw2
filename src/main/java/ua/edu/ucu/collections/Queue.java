package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList list;

    public Queue() {
        list = new ImmutableLinkedList();
    }

    public Object peek() {
        if (!isEmpty()) {
            return list.getFirst();
        }
        return -1;
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Object el = list.getFirst();
            list = list.removeFirst();
            return el;
        }
        return -1;
    }

    public void enqueue(Object e) {
        list = list.addLast(e);
    }

    protected boolean isEmpty() {
        return list.size() == 0;
    }
}