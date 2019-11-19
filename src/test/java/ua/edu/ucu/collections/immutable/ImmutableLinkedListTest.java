package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    private ImmutableLinkedList emptyList;
    private ImmutableLinkedList oneElemList;
    private ImmutableLinkedList twoElemList;
    private ImmutableLinkedList sevenElemList;

    @Before
    public void setup() {
        Object[] emptyList = {};
        Object[] oneElemList = {5};
        Object[] twoElemList = {10, 2};
        Object[] sevenElemList = {1, 3, 7, 90, 123, 67, 4};

        this.emptyList = new ImmutableLinkedList(emptyList);
        this.oneElemList = new ImmutableLinkedList(oneElemList);
        this.twoElemList = new ImmutableLinkedList(twoElemList);
        this.sevenElemList = new ImmutableLinkedList(sevenElemList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void IndexesCheck() {
        emptyList.get(2);
        oneElemList.remove(5);
        twoElemList.set(45, 4);
        sevenElemList.set(12, 5);
    }


    @Test
    public void AdditionCheck() {
        ImmutableLinkedList list = sevenElemList.add(6);

        int expectedLenInit = 7;
        Object[] expectedItemsInit = {1, 3, 7, 90, 123, 67, 4};
        int actualLenInit = sevenElemList.size();
        Object[] actualItemsInit = sevenElemList.toArray();

        assertArrayEquals(expectedItemsInit, actualItemsInit);
        assertEquals(expectedLenInit, actualLenInit);

        int expectedLenChanged = 8;
        Object[] expectedItemsChanged = {1, 3, 7, 90, 123, 67, 4, 6};
        int actualLenChanged = list.size();
        Object[] actualItemsChanged = list.toArray();

        assertArrayEquals(expectedItemsChanged, actualItemsChanged);
        assertEquals(expectedLenChanged, actualLenChanged);

        Object[] newArr = {567, 17};
        ImmutableLinkedList list2 = sevenElemList.addAll(newArr);

        int expectedLenChanged2 = 9;
        Object[] expectedItemsChanged2 = {1, 3, 7, 90, 123, 67, 4, 567, 17};
        int actualLenChanged2 = list2.size();
        Object[] actualItemsChanged2 = list2.toArray();
        assertArrayEquals(expectedItemsChanged2, actualItemsChanged2);
        assertEquals(expectedLenChanged2, actualLenChanged2);


    }

    @Test
    public void settersTest() {
        ImmutableLinkedList list1 = twoElemList.addFirst(4);
        ImmutableLinkedList list2 = twoElemList.addLast(45);

        assertEquals(4, list1.getFirst());
        assertEquals(45, list2.getLast());
    }


    @Test
    public void emptyTest() {
        assertTrue(emptyList.isEmpty());
        assertFalse(oneElemList.isEmpty());
    }

    @Test
    public void toArrayTest() {
        assertArrayEquals(new Object[]{10, 2}, twoElemList.toArray());
    }

    @Test
    public void toStringTest() {
        assertEquals("[10, 2]", twoElemList.toString());

    }
}