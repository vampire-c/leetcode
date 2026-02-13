package leetcode.problems;

/*
对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 */
class Solution0507 {

    static void main(String[] args) {
        new Solution0507().checkPerfectNumber(33550336);
    }

    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }

    public boolean checkPerfectNumber1(int num) {
        int sum = 1;
        for (int d = 2; d * d < num; d++) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }
}
