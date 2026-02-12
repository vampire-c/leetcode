package leetcode.problems;

import leetcode.GuessGame;

/*
我们正在玩猜数字游戏。猜数字游戏的规则如下：
我会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。（我选的数字在整个游戏中保持不变）。
如果你猜错了，我会告诉你，我选出的数字比你猜测的数字大了还是小了。
你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有三种可能的情况：
-1：你猜的数字比我选出的数字大 （即 num > pick）。
1：你猜的数字比我选出的数字小 （即 num < pick）。
0：你猜的数字与我选出的数字相等。（即 num == pick）。
返回我选出的数字。
 */
public class Solution0374 extends GuessGame {

    static void main(String[] args) {
        new Solution0374().guessNumber(10, 6);
    }

    public int guessNumber(int n, int guess) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid, guess) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public int guessNumber1(int n, int guess) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid, guess) == -1) {
                right = mid;
            } else if (guess(mid, guess) == 1) {
                left = mid + 1;
            } else if (guess(mid, guess) == 0) {
                return mid;
            }
        }
        return left;
    }
}
