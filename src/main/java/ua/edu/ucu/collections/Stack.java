package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst;

    public Stack() {
        lst = new ImmutableLinkedList();
    }

    public Object top() {
        if (!isEmpty()) {
            return lst.getLast();
        } else {
            return -1;
        }
    }

    public Object pop() {
        if (!isEmpty()) {
            Object val = lst.getLast();
            lst = lst.removeLast();
            return val;
        }
        return -1;
    }

    public void push(Object c) {
        lst = lst.addLast(c);
    }

    protected boolean isEmpty() {
        return lst.size() == 0;
    }


}
