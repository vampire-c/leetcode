package leetcode.sort;

import java.util.Arrays;

public class Demo02Selection {

    public static void main(String[] args) {
        int[] ints = {4, 6, 2, 1, 7, 9, 5, 8, 3};
        int[] ints1 = new Demo02Selection().selectionSort1(ints);
        System.out.println(Arrays.toString(ints1));
    }

    public int[] selectionSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return arr;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Demo.swap1(arr, i, minIndex);
        }
        return arr;
    }

    public int[] selectionSort1(int[] arr) {
        int n = arr.length;
        if (n < 2) return arr;
        for (int i = 0; i < n - 1 - i; i++) {
            int minIndex = i, maxIndex = i;
            for (int j = i + 1; j < n - i; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
                if (arr[j] > arr[maxIndex]) maxIndex = j;
            }
            if (minIndex == maxIndex) break;
            Demo.swap1(arr, i, minIndex);
            if (maxIndex == i) maxIndex = minIndex;
            Demo.swap1(arr, n - i - 1, maxIndex);
        }
        return arr;
    }

}
