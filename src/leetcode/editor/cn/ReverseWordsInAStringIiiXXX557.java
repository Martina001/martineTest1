//给定一个字符串
// s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 
// s 包含可打印的 ASCII 字符。 
// 
// s 不包含任何开头或结尾空格。 
// 
// s 里 至少 有一个词。 
// 
// s 中的所有单词都用一个空格隔开。 
// 
//
// Related Topics 双指针 字符串 👍 568 👎 0

package leetcode.editor.cn;
//Java：反转字符串中的单词 III
public class ReverseWordsInAStringIiiXXX557{
public static void main(String[] args) {
Solution solution = new ReverseWordsInAStringIiiXXX557().new Solution();
// TO TEST
    solution.reverseWords("take LeetCode contest");
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

        //或者用Spring的String[] sArr= s.split(' '),
        // 然后每个sArr都reverse一下即可

        // 自己写法
        char a[] =s.toCharArray();
        int l = 0,r = 0;
        while(r<=a.length){
            if(r == a.length || a[r] == ' '){
                reverseString(a,l,r-1);
                l = r+1;
            }
            r++;
        }
        return new String(a);
    }
    public void reverseString(char[] s,int left,int right) {
        while(left<right){
            swap(s,left,right);
            left++;
            right--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}