package learn.interstingproblems;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private T[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = (T[]) new Object[capacity];
    }

    public void push(T entry) {
        if (top == stack.length) {
            T[] newStack = (T[]) new Object[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
            System.out.println("Resized to: " + stack.length);
        }
        stack[top++] = entry;
        print();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[--top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void print() {
        for (int i = top; i > 0; i--) {
            System.out.print(stack[i - 1] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.print();
    }
}
