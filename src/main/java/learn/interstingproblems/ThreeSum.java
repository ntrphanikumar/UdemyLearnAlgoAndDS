package learn.interstingproblems;

import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public boolean findSumOfThree(List<Integer> arr, int sum) {
        System.out.println(arr);
        arr.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(arr);
        for (int i = 0; i < arr.size() - 2; i++) {
            int sumToLookFor = sum - arr.get(i);
            if (findSumOfTwo(arr, sumToLookFor, i + 1, arr.size())) {
                return true;
            }
        }
        return false;
    }

    public boolean findSumOfTwo(List<Integer> arr, int sum, int fromIdx, int toIdx) {
        System.out.println("Looking for sum:" + sum);
        for (int i = fromIdx; i < toIdx - 1; i++) {
            for (int j = i + 1; j < toIdx; j++) {
                if (arr.get(i) + arr.get(j) == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3,7,1,2,8,4,5);
        System.out.println(new ThreeSum().findSumOfThree(input, 20));
        System.out.println(new ThreeSum().findSumOfThree(input, 21));
    }
}
