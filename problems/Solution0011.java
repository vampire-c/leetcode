package leetcode.problems;

/*
给定一个长度为 n 的整数数组 height。
有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
 */
class Solution0011 {

    public static void main(String[] args) {
        System.out.println(new Solution0011().maxArea1(new int[]{5, 4, 3, 2, 1, 4, 8, 3, 7}));
    }


    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int ares = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, ares);
            if (height[left] < height[right]) {
                while (left < right && height[++left] <= height[left - 1]) ;
            } else {
                while (left < right && height[--right] <= height[right + 1]) ;
            }
        }
        return ans;
    }

    public int maxArea1(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
