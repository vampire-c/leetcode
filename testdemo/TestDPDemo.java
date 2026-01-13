package leetcode.testdemo;

public class TestDPDemo {
    public static void main(String[] args) {
        System.out.println(new TestDPDemo().fib1(5));
        System.out.println(new TestDPDemo().fib(5));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

}
