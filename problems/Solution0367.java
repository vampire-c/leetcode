package leetcode.problems;

class Solution0367 {

    static void main(String[] args) throws Exception {
        new Solution0367().isPerfectSquare(16);
    }

    // public boolean isPerfectSquare(int num) {
    //     int i = Float.floatToIntBits(num);
    //     i = 0x5f3759df - (i >> 1);
    //     float y = Float.intBitsToFloat(i);
    //     y = y * (1.5f - (0.5f * num) * y * y);
    //     float ans = 1.0f / y;
    //     ans = Math.round(ans * 10.0f) / 10.0f;
    //     return (int) ans * (int) ans == num;
    // }

    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right * right == num;
    }

    public boolean isPerfectSquare3(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean isPerfectSquare2(int num) {
        int i = 1;
        int square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            i++;
            square = i * i;
        }
        return false;
    }

    public boolean isPerfectSquare1(int num) throws Exception {
        double d = Math.sqrt(num);
        int sqrt = (int) d;
        return sqrt * sqrt == num;
    }


}
