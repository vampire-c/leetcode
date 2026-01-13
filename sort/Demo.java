package leetcode.sort;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        int[] ints = {4, 6, 2, 1, 7, 9, 5, 8, 3};
        swap1(ints, 0, 4);
        System.out.println(Arrays.toString(ints));
    }

    public static void swap1(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap2(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap3(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
