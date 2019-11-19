package ua.edu.ucu.collections;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    private Queue initialQueue;

    @Before
    public void setup() {
        this.initialQueue = new Queue();
        initialQueue.enqueue(5);
        initialQueue.enqueue(10);
        initialQueue.enqueue(67);
    }
    
    @Test
    public void initialQueueTest() {
        assertEquals(initialQueue.peek(), 5);
    }

    @Test
    public void DequeueTest() {
        this.initialQueue.dequeue();
        this.initialQueue.enqueue(54);
        assertEquals(initialQueue.peek(), 10);
    }

    @Test
    public void EmptyQueueTest() {
        assertFalse(initialQueue.isEmpty());
        this.initialQueue.dequeue();
        this.initialQueue.dequeue();
        this.initialQueue.dequeue();
        assertEquals(-1, this.initialQueue.peek());
        this.initialQueue.dequeue();
        assertEquals(-1, this.initialQueue.peek());
//       our queue is out of range
    }
    
}
