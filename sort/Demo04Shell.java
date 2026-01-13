package leetcode.sort;

import java.util.Arrays;

public class Demo04Shell {

    public static void main(String[] args) {
        int[] ints = {4, 6, 2, 1, 7, 9, 5, 8, 3};
        int[] ints1 = new Demo04Shell().shellSortShell(ints);
        System.out.println(Arrays.toString(ints1));
    }

    public int[] shellSortShell(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;

        return arr;
    }


}
