package leetcode.problems;

class Solution0011 {

    public static void main(String[] args) {
        System.out.println(new Solution0011().maxArea(new int[]{5, 4, 3, 2, 1, 4, 8, 3, 7}));
    }


    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int minLine = Math.min(height[left], height[right]);
            int ares = minLine * (right - left);
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
        int left = 0, right = height.length - 1;
        int ans = 0;
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
