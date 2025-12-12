package leetcode.everyday;

class Solution0042 {


    static void main(String[] args) {
        // new Solution0042().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        new Solution0042().trap(new int[]{4, 2, 0, 3, 2, 5});
    }

    public int trap(int[] height) {
        int ans = 0;
        int l = height.length;

        int left = 0, right = l - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }
        }
        return ans;
    }


    public int trap1(int[] height) {
        int ans = 0;
        int l = height.length;
        int[] preMax = new int[l];
        preMax[0] = height[0];
        int[] sufMax = new int[l];
        sufMax[l - 1] = height[l - 1];
        for (int i = 1; i < l; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        for (int i = l - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }

        return ans;
    }
}
