//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
//
// Related Topics 双指针 字符串 👍 210 👎 0

package leetcode.editor.cn;
//Java：仅仅反转字母
public class ReverseOnlyLettersXXX917{
public static void main(String[] args) {
Solution solution = new ReverseOnlyLettersXXX917().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0,r = s.length()-1;
        while(l<r){
            while(l<r &&!Character.isLetter(chars[l])){
                l++;
            }
            while(l<r && !Character.isLetter(chars[r])){
                r--;
            }
            if (l >= r) { break; }
            swap(chars,l,r);
            l++;r--;
        }
        return String.copyValueOf(chars);
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}