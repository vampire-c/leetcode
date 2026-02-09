package leetcode.problems;

class Solution3637 {

    static void main(String[] args) {
        new Solution3637().isTrionic(new int[]{1, 3, 5, 4, 2, 6});
    }

    public boolean isTrionic(int[] nums) {
        if (nums[0] >= nums[1]) {
            return false;
        }
        int cnt = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if ((nums[i - 2] < nums[i - 1]) != (nums[i - 1] < nums[i])) {
                cnt++;
            }
        }
        return cnt == 3;
    }

    public boolean isTrionic1(int[] nums) {
        int l = nums.length;
        int index1 = 1;
        while (index1 < l && nums[index1 - 1] < nums[index1]) {
            index1++;
        }
        if (index1 == 1) {
            return false;
        }
        int index2 = index1;
        while (index1 < l && nums[index1 - 1] > nums[index1]) {
            index1++;
        }
        if (index1 == index2 || index1 == l) {
            return false;
        }
        while (index1 < l && nums[index1 - 1] < nums[index1]) {
            index1++;
        }
        return index1 == l;
    }
}
