package leetcode.problems;

class Solution3379 {

    static void main(String[] args) {
        new Solution3379().constructTransformedArray(new int[]{3,-2,1,1});
        new Solution3379().constructTransformedArray(new int[]{-1, 4, -1});
    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[((i + nums[i]) % n + n) % n];
        }
        return ans;
    }


}
