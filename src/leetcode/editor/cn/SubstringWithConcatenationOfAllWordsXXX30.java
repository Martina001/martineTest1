//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，
//"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1094 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：串联所有单词的子串
public class SubstringWithConcatenationOfAllWordsXXX30 {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWordsXXX30().new Solution();
// TO TEST
        List<Integer> barfoothefoobarman = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        System.out.println(barfoothefoobarman.size());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            HashMap<String, Integer> need = new HashMap<>(words.length);
            int wordSize = words[0].length();
            int len = words.length * wordSize;
            for (String w : words) {
                need.put(w, need.getOrDefault(w, 0) + 1);
            }

            int n = s.length();
            if (n < len) return res;

            // 这道题有三个点没有考虑到，1 就是在需要循环wordSize次进行单词分割
//            2 就是need不能--，只能window++  这样重新开始的时候need不用动，window直接clear就行（直接不用window而是用need--也可，但是理解上有点难度）
//            3 就是一定right要先加加，出窗口用window和need对比判断，用while而不用if，这样valid==0的时候窗口不用再缩小了

//           为啥循环wordSize次呢，因为循环到第wordSize+1次的时候，等价于i=0的时候情况
            for (int i = 0; i < wordSize; i++) {
                int right = i, left = i, valid = words.length;
                HashMap<String, Integer> window = new HashMap<>(words.length);
                // 如果right + wordSize已经大于n了 就说明right后的数量不足以构成word，直接结束
                while (right + wordSize <= n) {
                    String w = s.substring(right, right + wordSize);
                    right += wordSize;

                    if (need.containsKey(w)) {
                        // 入窗口
                        window.put(w, window.getOrDefault(w,0) + 1);
                        valid--;
                        // 用while循环出窗口，所以下面valid==0的时候就不用再滑出了
                        // 这个while循环不写在下面valid==0的判断里是因为需要用到w
                        while (window.getOrDefault(w, 0) > need.getOrDefault(w, 0)) {
                            String leftString = s.substring(left, left + wordSize);
                            window.put(leftString, window.get(leftString) - 1);
                            valid++;
                            left += wordSize;
                        }
                    } else {
                        // 如果当前单词不在words中，直接从下一个单词的起始点开始，window和valid记得初始化
                        left = right;
                        window.clear();
                        valid = words.length;
                        continue;
                    }

                    if (valid == 0) {
                        // 这里不用再滑出窗口，上面已经在while判读的时候滑出过了
                        res.add(left);

                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}