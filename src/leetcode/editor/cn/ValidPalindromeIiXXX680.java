//给你一个字符串 s，最多 可以从中删除一个字符。 
//
// 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "abca"
//输出：true
//解释：你可以删除字符 'c' 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abc"
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 贪心 双指针 字符串 👍 629 👎 0

package leetcode.editor.cn;
//Java：验证回文串 II
public class ValidPalindromeIiXXX680{
public static void main(String[] args) {
Solution solution = new ValidPalindromeIiXXX680().new Solution();
// TO TEST
    boolean abab = solution.validPalindrome("aba");
    System.out.println(abab);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int l= 0,r = s.length()-1;
        while(l<r){
            if(s.charAt(l) !=s.charAt(r)){
                return validate(s,l+1,r) || validate(s,l,r-1);
            }
            l++;r--;
        }
        return true;
    }
    private boolean validate(String s,int l,int r){
        if(l<0 || r>=s.length()){
            return false;
        }
        while(l<r){
            if(s.charAt(l) !=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}