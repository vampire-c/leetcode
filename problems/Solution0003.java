package leetcode.problems;

public class Solution0003 {
    public static void main(String[] args) {
        int lengthOfLongestSubstring = new Solution0003().lengthOfLongestSubstring("pwwkew");
        System.out.println(lengthOfLongestSubstring);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] ca = s.toCharArray();
        int l = s.length();
        int ans = 0;
        int left = 0;
        boolean[] cnt = new boolean[128];
        for (int right = 0; right < l; right++) {
            char c = ca[right];
            while (cnt[c]) {
                cnt[ca[left]] = false;
                left++;
            }
            cnt[c] = true;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        char[] ca = s.toCharArray();
        int l = s.length();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128];// 记录每个字符出现的次数
        for (int right = 0; right < l; right++) {
            char c = ca[right];
            cnt[c]++;
            while (cnt[c] > 1) {// 出现重复的字符
                cnt[ca[left]]--;// 重复字符串的个数减1
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


}
