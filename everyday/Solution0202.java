package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution0202 {


    static void main(String[] args) {
        new Solution0202().isHappy(2);
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    public boolean isHappy1(int n) {
        int temp = n;
        List<Integer> arr = new ArrayList<>();
        while (true) {

            while (temp > 0) {
                arr.add(temp % 10);
                temp /= 10;
            }

            int sum = 0;
            for (Integer integer : arr) {
                sum += integer * integer;
            }
            if (sum == 1) {
                return true;
            }
            arr.clear();
            temp = sum;
        }


    }
}
