package learn.udemy.dsalgo.sort;

import static learn.udemy.dsalgo.Utils.print;
import static learn.udemy.dsalgo.Utils.swap;

public class SelectionSort<T extends Comparable> {
    public static void main(String[] args) {
        Integer[] unsortedArr = {5, 3, 12, -10, 8, 10, -6};
        System.out.print("Input: ");
        print(unsortedArr);
        new SelectionSort<>().sort(unsortedArr);
        System.out.print("Result: ");
        print(unsortedArr);
    }

    public void sort(T[] array) {
        for (int unsortedMaxIdx = array.length - 1; unsortedMaxIdx > 0; unsortedMaxIdx--) {
            int largestValIdx = unsortedMaxIdx;
            for (int i = 0; i < unsortedMaxIdx; i++) {
                if (array[largestValIdx].compareTo(array[i]) == -1) {
                    largestValIdx = i;
                }
            }
            if (largestValIdx < unsortedMaxIdx) {
                swap(array, largestValIdx, unsortedMaxIdx);
            }
            System.out.print("UnsortedMaxIdx: " + unsortedMaxIdx + " | ");
            print(array);
        }
    }
}
