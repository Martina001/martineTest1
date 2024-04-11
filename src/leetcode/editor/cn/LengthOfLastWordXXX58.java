//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为5。
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为4。
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为6的“joyboy”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
//
// Related Topics 字符串 👍 679 👎 0

package leetcode.editor.cn;
//Java：最后一个单词的长度
public class LengthOfLastWordXXX58{
public static void main(String[] args) {
Solution solution = new LengthOfLastWordXXX58().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        // 见之前的字符串反转之类的解法 不过这个在这里比较耗时
       /* String[] split = s.split("\\s+");
        String s1 = split[split.length - 1];
        return s1.length();*/

        // 简单一点的解法是直接从后往前数找两次空格之间的距离即可
        int right = s.length()-1;
        while(right>=0 && s.charAt(right) == ' ') right--;
        int left = right;
        while(left>=0 && s.charAt(left) != ' ') left--;
        return right-left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}