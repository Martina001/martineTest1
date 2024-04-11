//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2539 👎 0

package leetcode.editor.cn;

import netscape.security.UserTarget;

import java.util.HashMap;
import java.util.Map;

//Java：最小覆盖子串
public class MinimumWindowSubstringXXX76 {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstringXXX76().new Solution();
// TO TEST
        String res= solution.getRes("ADOBECODEBANC","ABC");
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            /*if (null == s || null == t || s.isEmpty() || t.isEmpty()) return "";
            int resLen = Integer.MAX_VALUE;
            HashMap<Character, Integer> need = new HashMap();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            // 有效无重复字符数量
            int validLen = 0;
            int needLen = need.size();
            // 双指针
            int right = 0, left = 0;
            // 每次开始的起始索引
            int start = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (isValid(need, window, c)) {
                        validLen++;
                    }
                }
                // 注意这里是while 不是if。因为每次移出的字符可能有多个
                while (validLen == needLen) {
                    // 更新最终的结果
                    if (right - left < resLen) {
                        // start用于避免每次left都只能往后移动一次
                        start = left;
                        resLen = right - left;
                    }
                    // 缩小窗口
                    char temp = s.charAt(left);
                    left++;
                    if (need.containsKey(temp)) {
                        // 只有window中当前值的数量等于need中所需的数量的时候 validLen--；其他情况也只有window中temp的数量大于need中所需数量
                        if (isValid(need, window, temp)) {
                            validLen--;
                        }
                        window.put(temp, window.get(temp) - 1);
                    }
                }
            }
            return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);*/
            return getRes(s,t);
        }

        // 注意这里要用equals而不是==
        private boolean isValid(HashMap<Character, Integer> needMap, HashMap<Character, Integer> window, char c) {
            return window.get(c).equals(needMap.get(c));
        }

        private String getRes(String s, String t) {
            if (null == s || null == t || s.isEmpty() || t.isEmpty()) return "";
            int resLen = Integer.MAX_VALUE;
            HashMap<Character, Integer> need = new HashMap();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            int valid = 0;

            int right = 0, left = 0, start = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.getOrDefault(c,0).equals(need.get(c))) {
                        valid++;
                    }
                }

                while (valid == need.size()) {
                    if (right - left < resLen) {
                        start = left;
                        resLen = right - left;
                    }
                    char cc = s.charAt(left);
                    left++;
                    if (need.containsKey(cc)) {
                        if (window.getOrDefault(cc,0).equals(need.get(cc))) {
                            valid--;
                        }
                        window.put(cc, window.getOrDefault(cc, 0) - 1);
                    }
                }
            }
            return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}