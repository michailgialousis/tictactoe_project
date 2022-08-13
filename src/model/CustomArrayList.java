package model;

import java.io.Serializable;
import java.util.Arrays;

// :( This is our attempt to create a custom ArrayList class. Unfortunately due to errors we did not manage to make it work (But we really tried).
public class CustomArrayList<E> implements Serializable {
    public static final long serialVersionUID = 0L;
    private int size;
    private Object[] data;

    public CustomArrayList(int maxSize) {
        this.data = new Object[maxSize];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int capacity() {
        return this.data.length;
    }

    public void clear() {
        this.data = null;
        this.size = 0;

    }

    public int freeSpace() {
        return (this.capacity() - this.size);

    }

    public void add(E item) {
        if (this.freeSpace() != 0) {
            for (int i = this.capacity() - 1; i > 0; i--) {
                this.data[i] = this.data[i - 1];
            }
            this.data[0] = item;
            this.size++;
        } else {
            this.pop();
            this.data[0] = item;
        }
    }

    private void pop() {
        this.data[this.capacity() - 1] = null;
        for (int i = this.capacity() - 1; i > 0; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[0] = null;
    }

    public void checkBounds(int pos) {
        if (pos < 0 || pos > this.capacity()) {
            throw new ArrayIndexOutOfBoundsException(pos + "is not a valid position.");
        }
    }

    @SuppressWarnings("unchecked")
    public E getItem(int pos) {
        this.checkBounds(pos);
        return (E) this.data[pos];

    }

    public void remove(int pos) {
        this.checkBounds(pos);
        E dead = this.getItem(pos);
        if (dead == null) {
            return;
        }
        for (int i = pos; i > 0; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[0] = null;
        this.size--;
        return;

    }

    @SuppressWarnings("unchecked")
    public E[] toArray(E[] type) {
        return (E[]) Arrays.copyOf(this.data, size, type.getClass());
    }

    public void addAll(E[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                this.add(array[i]);
            }
        }
    }

}