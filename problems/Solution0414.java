package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution0414 {
    static void main(String[] args) {
        new Solution0414().thirdMax(new int[]{2, 3, 1, 1, 3});
    }

    public int thirdMax(int[] nums) {
        List<Integer> list = Arrays
                .stream(nums).boxed().collect(Collectors.toSet())
                .stream().sorted().toList();
        // Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        // List<Integer> list = set.stream().sorted().toList();
        if (list.size() < 3) {
            return list.getLast();
        }
        return list.get(list.size() - 3);
    }

    public int thirdMax2(int[] nums) {
        Arrays.sort(nums);
        int x = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                x++;
            }
            if (x == 3) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public int thirdMax1(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        long max1 = Integer.MIN_VALUE;
        long max2 = Integer.MIN_VALUE;
        long max3 = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        if (set.size() < 3) {
            return (int) max1;
        }
        return (int) max3;
    }
}
