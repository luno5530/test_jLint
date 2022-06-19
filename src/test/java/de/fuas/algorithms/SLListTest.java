package de.fuas.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class SLListTest {

    @Test
    public void testIsEmpty() {
        SLList<String> list = new SLList<String>();

        Assert.assertTrue(list.isEmpty());
        list.add(0, "a");

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        SLList<String> list = new SLList<String>();

        Assert.assertEquals(0, list.size());
        list.add(0, "a");

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void testNaiveSize() {
        SLList<String> list = new SLList<String>();

        Assert.assertEquals(0, list.naiveSize());
        list.add(0, "a");

        Assert.assertEquals(1, list.naiveSize());
    }

    @Test
    public void testAddGet() {
        SLList<String> list = new SLList<String>();
        list.add(0, "a");
        list.add(0, "b");

        Assert.assertEquals("a", list.get(1));
    }

    @Test
    public void testNull() {
        SLList<String> list = new SLList<String>();
        list.add(0, null);

        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(null, list.get(0));
    }

    @Test
    public void testGetIndexTooSmall() {
        SLList<String> list = new SLList<String>();

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void testGetIndexTooLarge() {
        SLList<String> list = new SLList<String>();
        list.add(0, "a");

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void testAddIndexTooSmall() {
        SLList<String> list = new SLList<String>();

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "a"));
    }

    @Test
    public void testAddIndexTooLarge() {
        SLList<String> list = new SLList<String>();

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "a"));
    }

    @Test
    public void testExceptionSize() {
        SLList<String> list = new SLList<String>();
        try {
            list.add(-1, "a");
        } catch (Exception e) {
            Assert.assertEquals(0, list.size());
        }
    }

    @Test
    public void testRemove() {
        SLList<String> list = new SLList<String>();
        list.add(0, "a");
        list.add(1, "b");
        list.add(2, "c");

        Assert.assertEquals("a", list.remove(0));
        Assert.assertEquals("b", list.get(0));
        Assert.assertEquals("c", list.remove(1));
        Assert.assertEquals(1, list.size());
    }
}