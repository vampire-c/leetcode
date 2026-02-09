package leetcode.problems;

import java.util.*;


class Solution0015 {

    static void main(String[] args) {
        System.out.println(new Solution0015().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int first = 0; first < length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            if (nums[first] + nums[first + 1] + nums[first + 2] > 0) break;
            if (nums[first] + nums[length - 2] + nums[length - 1] < 0) continue;
            int second = first + 1;
            int third = length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum > 0) {
                    third--;
                } else if (sum < 0) {
                    second++;
                } else {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    for (second++; second < third && nums[second] == nums[second - 1]; second++) ;
                    for (third--; third > second && nums[third] == nums[third + 1]; third--) ;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int first = 0; first < length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;

            int third = length - 1;
            int target = -nums[first];

            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;

                while (second < third && nums[second] + nums[third] > target) third--;

                if (second == third) break;

                if (nums[second] + nums[third] == target) {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] ints = {nums[i], nums[j], nums[k]};
                        Arrays.sort(ints);
                        String key = "" + ints[0] + ints[1] + ints[2];
                        map.put(key, Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
