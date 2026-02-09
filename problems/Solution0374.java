package leetcode.problems;

import leetcode.GuessGame;


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
