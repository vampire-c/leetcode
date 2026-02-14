package leetcode.problems;

/*
斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给定 n ，请计算 F(n) 。
 */
class Solution0509 {

    static void main(String[] args) {
        new Solution0509().fib(10);
    }

    public int fib(int n) {
        /*
        F(n)=F(n−1)+F(n−2)
        特征方程: f(x)=x^2-x-1
        x1=(1+sqrt(5))/2 , x2=(1-sqrt(5))/2

         */

        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    public int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(q, n - 1);
        return res[0][0];
    }

    private int[][] matrixPower(int[][] ints, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, ints);
            }
            n >>= 1;
            ints = multiply(ints, ints);
        }
        return ret;
    }

    private int[][] multiply(int[][] ints1, int[][] ints2) {
        int[][] ret = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ret[i][j] = ints1[i][0] * ints2[0][j] + ints1[i][1] * ints2[1][j];
            }
        }
        return ret;
    }


    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public int fib1(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }
}
