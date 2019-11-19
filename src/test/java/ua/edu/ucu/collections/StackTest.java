package ua.edu.ucu.collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack initialStack;

    @Before
    public void setup() {
        this.initialStack = new Stack();
        initialStack.push(5);
        initialStack.push(10);
        initialStack.push(67);
    }

    @Test
    public void EmptyStackTest() {
        assertEquals(initialStack.top(), 67);
    }

    @Test
    public void PushTest() {
        this.initialStack.pop();
        this.initialStack.push(54);
        assertEquals(initialStack.top(), 54);
    }

    @Test
    public void EmptyStack() {
        assertFalse(initialStack.isEmpty());
        this.initialStack.pop();
        this.initialStack.pop();
        this.initialStack.pop();
        assertEquals(-1, this.initialStack.top());
        this.initialStack.pop();
        assertEquals(-1, this.initialStack.top());
//       our stack is out of range
    }

}
