package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」 定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
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
