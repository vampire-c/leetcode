package leetcode.problems;

class Solution1456 {

    static void main(String[] args) {
        // new Solution1456().maxVowels("leetcode", 3);
        new Solution1456().maxVowels("rhythms", 4);
    }

    public int maxVowels(String s, int k) {
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) vowel++;
            int left = i - k + 1;
            if (left < 0) continue;
            ans = Math.max(ans, vowel);
            if (ans == k) break;
            if (isVowel(s.charAt(left))) vowel--;
        }
        return ans;
    }

    public int maxVowels1(String s, int k) {
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += isVowel(s.charAt(i)) ? 1 : 0;
            ans = Math.max(temp, ans);
            if (ans == k) break;
        }
        for (int i = k; i < s.length(); i++) {
            temp += isVowel(s.charAt(i)) ? 1 : 0;
            temp += isVowel(s.charAt(i - k)) ? -1 : 0;
            ans = Math.max(temp, ans);
            if (ans == k) break;

        }
        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
