//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1387 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class FindAllAnagramsInAStringXXX438 {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAStringXXX438().new Solution();
// TO TEST
        List<Integer> anagrams = solution.findAnagrams("aabaa", "aba");
        System.out.println(anagrams.size());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 和576题目的字符串排列差不多
        public List<Integer> findAnagrams(String s, String p) {
            HashMap<Character, Integer> validMap = new HashMap<>();

            for (Character c : p.toCharArray()) {
                validMap.put(c, validMap.getOrDefault(c, 0) + 1);
            }
            int i = 0, left = 0;
            HashMap<Character, Integer> window = new HashMap<>();
            List<Integer> res = new ArrayList<>();
            int valid = 0;
            while (i < s.length()) {
                char c = s.charAt(i);

                if (validMap.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(validMap.get(c))) {
                        valid++;
                    }
                }
                // 这里i要先加一，才能判断此时的window长度是否大于等于p
                i++;
                while (i - left >= p.length()) {
                    if (valid == validMap.keySet().size()) {
                        res.add(left);
                    }
                    char leftChar = s.charAt(left);
                    left++;
                    if (validMap.containsKey(leftChar)) {
                        // 备注，这里不能用== 要用equals
                        if (window.get(leftChar).equals(validMap.get(leftChar))) {
                            valid--;
                        }
                        window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}