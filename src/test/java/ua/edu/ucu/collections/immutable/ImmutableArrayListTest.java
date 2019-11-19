package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableArrayList emptyList;
    private ImmutableArrayList oneElemList;
    private ImmutableArrayList twoElemList;
    private ImmutableArrayList sevenElemList;

    @Before
    public void setup() {
        Object[] emptyList = {};
        Object[] oneElemList = {5};
        Object[] twoElemList = {10, 2};
        Object[] sevenElemList = {1, 3, 7, 90, 123, 67, 4};

        this.emptyList = new ImmutableArrayList();
        this.oneElemList = new ImmutableArrayList(oneElemList);
        this.twoElemList = new ImmutableArrayList(twoElemList);
        this.sevenElemList = new ImmutableArrayList(sevenElemList);
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
        ImmutableArrayList list = sevenElemList.add(6);

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

        ImmutableArrayList list2 =
                sevenElemList.addAll(new Object[]{6, 9, 764});
        int expectedLenChanged2 = 10;
        Object[] expectedItemsChanged2 = {1, 3, 7, 90, 123, 67, 4, 6, 9, 764};
        int actualLenChanged2 = list2.size();
        Object[] actualItemsChanged2 = list2.toArray();

        assertArrayEquals(expectedItemsChanged2, actualItemsChanged2);
        assertEquals(expectedLenChanged2, actualLenChanged2);
    }

    @Test
    public void toArrayTest() {
        assertArrayEquals(new Object[]{10, 2}, twoElemList.toArray());
    }

    @Test
    public void toStringTest() {
        assertEquals("[10, 2]", twoElemList.toString());

    }

    @Test
    public void AddAllTestPositioned() {
        ImmutableArrayList tenElem = this.sevenElemList.addAll(
                3, new Object[]{111, 3, 4});

        Object[] expectedArray = {1, 3, 7, 111, 3, 4, 90, 123, 67, 4};

        assertEquals(10, tenElem.size());
        assertArrayEquals(expectedArray, tenElem.toArray());
    }

    @Test
    public void RemoveByExistingIndex() {
        ImmutableArrayList sixElem = this.sevenElemList.remove(4);
        Object[] expectedArray =  {1, 3, 7, 90, 67, 4};
        assertArrayEquals(expectedArray, sixElem.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void RemoveByNonExistingIndex() {
        ImmutableArrayList sevenElem = this.sevenElemList.remove(40);
    }

    @Test
    public void TestSetters(){
        ImmutableArrayList sixElem = this.sevenElemList.set(4, 700);
        Object[] expectedArray =  {1, 3, 7, 90, 700, 67, 4};
        assertArrayEquals(expectedArray, sixElem.toArray());
    }
}
