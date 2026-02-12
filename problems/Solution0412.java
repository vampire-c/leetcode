package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/*
给你一个整数 n ，返回一个字符串数组 answer（下标从 1 开始），其中：
answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
answer[i] == "Fizz" 如果 i 是 3 的倍数。
answer[i] == "Buzz" 如果 i 是 5 的倍数。
answer[i] == i （以字符串形式）如果上述条件全不满足。
 */
class Solution0412 {

    static void main(String[] args) {
        new Solution0412().fizzBuzz(15);
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(i + "");
            }
        }
        return ans;
    }
}
