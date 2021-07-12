package learn.interstingproblems;

import java.util.NoSuchElementException;

public class CircularArrayQueue<T> {
    private T[] array;
    private int front;
    private int back;
    private int size;

    public CircularArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T ele) {
        if (size == array.length) {
            T[] newArr = (T[]) new Object[2 * array.length];
            System.arraycopy(array, front, newArr, 0, array.length - front);
            System.arraycopy(array, 0, newArr, array.length - front, back);
            front = 0;
            back = size;
            array = newArr;
        }
        array[back++] = ele;
        if (back == array.length) {
            back = 0;
        }
        size++;
        print();
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T eleToRemove = array[front];
        array[front++] = null;
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        print();
        size--;
        return eleToRemove;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        System.out.print("Size: " + size() + ", Values:");
        if (back <= front && !isEmpty()) {
            for (int i = front; i < array.length; i++) {
                System.out.print(" " + array[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.print(" " + array[i]);
            }
        } else {
            for (int i = front; i < back; i++) {
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.add(4);
        queue.add(5);
        queue.remove();
        queue.add(6);
        queue.add(7);
        queue.add(8);
    }
}
