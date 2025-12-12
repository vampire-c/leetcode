package leetcode.testdemo;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        twoSum(new int[] { 2, 7, 11, 15 }, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, xi = x;
        while (true) {
            double xi_1 = 0.5 * (xi + C / xi);
            if (xi - xi_1 < 0.000001) {
                break;
            }
            xi = xi_1;
        }
        return (int) xi;
    }

    public static int mySqrt1(int x) {
        int left = 0, right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
        return left;
    }

    public static int peakIndexInMountainArray3(int[] arr) {
        int left = 1, right = arr.length - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int peakIndexInMountainArray2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return 0;
    }

    public static int peakIndexInMountainArray1(int[] arr) {
        int left = 0;
        int right = arr.length - 2;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static int vowelStrings(String[] words, int left, int right) {
        String vowels = "aeiou";
        int count = 0;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            if (vowels.indexOf(s.charAt(0)) != -1 &&
                    vowels.indexOf(s.charAt(s.length() - 1)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int vowelStrings1(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            switch (words[i].charAt(0)) {
                case 'a', 'e', 'i', 'o', 'u':
                    break;
                default:
                    continue;
            }
            switch (words[i].charAt(words[i].length() - 1)) {
                case 'a', 'e', 'i', 'o', 'u':
                    count++;
                    break;
            }
        }
        return count;
    }

    public static int maxScore(String s) {
        char[] ca = s.toCharArray();
        int n = s.length();
        int cnt1 = 0;
        int delta = 0;
        int maxDelta = -n;
        for (int i = 0; i < n - 1; i++) {
            cnt1 += ca[i] - '0';
            delta += ca[i] == '0' ? 1 : -1;
            maxDelta = Math.max(maxDelta, delta);
        }
        return maxDelta + cnt1 + (ca[n - 1] - '0');
    }

    public static int maxScore2(String s) {
        char[] ca = s.toCharArray();
        int score = 0;
        for (char c : ca) {
            score += c - '0';
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += ca[i] == '0' ? 1 : -1;
            ans = Math.max(ans, score);
        }
        return ans;
    }

    public static int maxScore1(String s) {
        char[] ca = s.toCharArray();
        int right1 = 0;
        for (char c : ca) {
            right1 += c - '0';
        }
        int ans = 0;
        int left0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ca[i] == '0') {
                left0++;
            } else {
                right1--;
            }
            ans = Math.max(ans, left0 + right1);
        }
        return ans;
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[i * 2] = nums[i];
            res[i * 2 + 1] = nums[i + n];
        }
        return res;
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            product *= i;
            sum += i;
            n /= 10;
        }
        return product - sum;
    }

    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static String toLowerCase(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int length = arr.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Integer value : map.values()) {
            count += value * (value - 1) / 2;
        }
        return count;
    }

}
