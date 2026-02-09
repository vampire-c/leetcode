package leetcode.problems;

class Solution0050 {

    public static void main(String[] args) {
        double v = new Solution0050().myPow(2.1, 3);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        double ans = 1;
        long tmp = n;
        if (tmp < 0) {
            tmp = -tmp;
            x = 1 / x;
        }
        while (tmp != 0) {
            if ((tmp & 1) == 1) {
                ans = ans * x;
            }
            x = x * x;
            tmp = tmp >> 1;
        }
        return ans;
    }
}
