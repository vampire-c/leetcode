package leetcode.sort;

import java.util.Arrays;

public class Demo03Insertion {

    public static void main(String[] args) {
        int[] ints = {4, 6, 2, 1, 7, 9, 5, 8, 3};
        int[] ints1 = new Demo03Insertion().insertionSort(ints);
        System.out.println(Arrays.toString(ints1));
    }

    public int[] insertionSort(int[] arr) {
        if (arr.length < 2) return arr;
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i], j = i - 1;
            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
        return arr;
    }


    public int[] insertionSort1(int[] arr) {
        if (arr.length < 2) return arr;
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            while (index > 0 && arr[index - 1] > arr[index]) {
                Demo.swap1(arr, index - 1, index);
                index--;
            }
        }
        return arr;
    }
}
