package leetcode.sort;

public class Demo01Bubble {
    public static void main(String[] args) {
        int[] ints = {4, 6, 2, 1, 7, 9, 5, 8, 3};
        bubbleSort(ints);
    }


    public static int[] bubbleSort(int[] arr) {
        int l = arr.length;
        if (l < 2) return arr;
        for (int i = 0; i < l - 1; i++) {
            boolean swaped = false;
            for (int j = 0; j < l - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Demo.swap1(arr, j, j + 1);
                    swaped = true;
                }
            }
            if (!swaped) break;
        }
        return arr;
    }


    public static int[] bubbleSort1(int[] arr) {

        if (arr.length < 2) return arr;
        int r = arr.length - 1;
        while (r > 0) {
            int l = 0;
            for (int i = 0; i < r; i++) {
                if (arr[i] > arr[i + 1]) {
                    Demo.swap1(arr, i, i + 1);
                    l = i + 1;
                }
            }
            r = l;
        }
        return arr;
    }
}
