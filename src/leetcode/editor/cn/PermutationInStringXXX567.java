//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 924 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Java：字符串的排列
public class PermutationInStringXXX567 {
    public static void main(String[] args) {
        Solution solution = new PermutationInStringXXX567().new Solution();
// TO TEST
        String str = "ab";
        char[] chars = str.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('a');
        linkedList.add('b');
        System.out.println("String:" + str);
        System.out.println("chars :" + String.copyValueOf(chars));

        solution.checkInclusion("ab", "obaf");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1 == null || s1.isEmpty()) return true;
            if (s2 == null || s2.isEmpty()) return false;
            char[] arr = s1.toCharArray();
            // 方法1。暴力：求出所有全排列，然后轮询判断。会超时
/*            boolean[] used = new boolean[s1.length()];
            getAllSets(arr, new StringBuilder(), used);
            boolean res = checkIn(s2, arr, allSet);*/
            // 方法2 滑动窗口
            boolean res = slideCheck(s1, s2);
            return res;
        }

        // 此题和438 找到字符串的所有字母异位词相差无几
        private boolean slideCheck(String s1, String s2) {
            HashMap<Character, Integer> needMap = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : s1.toCharArray()) {
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }
            int left = 0, right = 0;
            int validLen = 0;
            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                if (needMap.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (isValid(needMap, window, c)) {
                        validLen++;
                    }
                }

                // 注意这里判断循环的条件是长度大于等于s1.length()，而不是validLen和needMap.size比较
                // 又因为每次只会移进移出一个字符，所以while和if都可以，这就是和76题的最小覆盖子串的区别
                while (right - left >= s1.length()) {
                    if (validLen == needMap.size()) return true;

                    char temp = s2.charAt(left);
                    left++;

                    if (needMap.containsKey(temp)) {
                        if (isValid(needMap, window, temp)) {
                            validLen--;
                        }
                        window.put(temp, window.getOrDefault(temp, 0) - 1);
                    }
                }
            }
            return false;
        }

        // 注意这里要用equals而不是==
        private boolean isValid(HashMap<Character, Integer> needMap, HashMap<Character, Integer> window, char c) {
            return window.get(c).equals(needMap.get(c));
        }

        private boolean checkIn(String s2, char[] arr, List<String> allSet) {
            int right = 0;
            StringBuilder window = new StringBuilder();
            while (right < s2.length()) {
                char c = s2.charAt(right);
                window.append(c);
                right++;
                if (window.length() == arr.length) {
                    String winStr = window.toString();
                    if (allSet.contains(winStr)) return true;
                    window.deleteCharAt(0);
                }
            }
            return false;
        }


        List<String> allSet = new ArrayList<>();

        /**
         * 获取全排列
         *
         * @param arr
         * @param track
         * @param used
         */
        private void getAllSets(char arr[], StringBuilder track, boolean[] used) {
            if (track.length() == arr.length) {
                allSet.add(track.toString());
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 做选择
                track.append(arr[i]);
                used[i] = true;
                // 下一层
                getAllSets(arr, track, used);
                // 撤销选择(移除最后一位上的字母)
                track.deleteCharAt(track.length() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}