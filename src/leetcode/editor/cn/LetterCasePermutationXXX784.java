//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 571 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：字母大小写全排列
public class LetterCasePermutationXXX784 {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutationXXX784().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            // 字母的大小写之间的ascii码就差32 所以转换大小写直接异或即可
            // 另 character直接有isLetter/isDigit的方法
            backTrack(s.toCharArray(),0);
            return res;
        }

        private void backTrack(char[] s, int index) {
            while (index < s.length && Character.isDigit(s[index])) { index++; }
            if(index == s.length){
                res.add(new String(s));
                return;
            }
            s[index] ^= 32;
            backTrack(s,index+1);
            s[index] ^= 32;
            backTrack(s,index+1);

            /*
            // 先遍历再更改遍历也可以
            backTrack(s,index+1);
            s[index] ^= 32;
            backTrack(s,index+1);
            s[index] ^= 32;
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}