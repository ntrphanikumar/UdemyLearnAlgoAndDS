package learn.udemy.dsalgo;

public class MaxHeap {
    private int[] array;
    private int size;

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    public MaxHeap insert(int ele) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        array[size] = ele;
        adjustHeapAbove(size++);
        return this;
    }

    public int delete(int idx) {
        if (size <= idx) {
            throw new IndexOutOfBoundsException();
        }
        int parent = getParent(idx);
        int deletedVal = array[idx];
        array[idx] = array[size - 1];
        if (array[idx] > array[parent]) {
            adjustHeapAbove(idx);
        } else if (array[idx] < array[parent]) {
            adjustHeapBelow(idx, size - 1);
        }
        array[--size] = 0;
        return deletedVal;
    }

    private void adjustHeapBelow(int idx, int lastHeapIdx) {
        int childToSwap;
        while (idx < lastHeapIdx) {
            int leftChild = getChild(idx, true);
            int rightChild = getChild(idx, false);
            if (leftChild <= lastHeapIdx) {
                if (rightChild > lastHeapIdx) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = array[leftChild] > array[rightChild] ? leftChild : rightChild;
                }
                if (array[idx] < array[childToSwap]) {
                    int tmp = array[idx];
                    array[idx] = array[childToSwap];
                    array[childToSwap] = tmp;
                } else {
                    break;
                }
                idx = childToSwap;
            } else {
                break;
            }
        }
    }

    private void adjustHeapAbove(int idx) {
        int newVal = array[idx];
        int parentIdx = getParent(idx);
        while (idx > 0 && array[parentIdx] < array[idx]) {
            array[idx] = array[parentIdx];
            idx = parentIdx;
        }
        array[idx] = newVal;
    }

    public boolean isFull() {
        return array.length == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getParent(int idx) {
        return (idx - 1) / 2;
    }

    public int getChild(int idx, boolean left) {
        return 2 * idx + (left ? 1 : 2);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(80).insert(75).insert(60).insert(68).insert(55).insert(40).insert(52).insert(67);
        heap.print();
        heap.delete(0);
        heap.print();
    }
}
