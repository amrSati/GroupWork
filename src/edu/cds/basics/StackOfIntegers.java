package edu.cds.basics;

class StackOfIntegers {

    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    /* Construct a stack with default capacity */
    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    /* Construct a stack with specified capacity */
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    /* Push a new element into the top of the stack */
    public void push(int val) {
        // Resize if size is bigger than length
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }

        elements[size++] = val;
    }

    /*  Return and Remove the top element of the stack */
    public int pop() {
        return elements[--size];
    }

    /* Return the top element of the stack */
    public int peek() {
        return elements[size - 1];
    }

    /* Test if empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Return number of elements in the stack */
    public int size() {
        return size;
    }
}
