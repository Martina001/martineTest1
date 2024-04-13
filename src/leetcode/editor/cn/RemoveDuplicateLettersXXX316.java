//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 931 👎 0

package leetcode.editor.cn;

//Java：去除重复字母
public class RemoveDuplicateLettersXXX316{
public static void main(String[] args) {
Solution solution = new RemoveDuplicateLettersXXX316().new Solution();
// TO TEST
    String s = "bcabc";
    String s1 = solution.removeDuplicateLetters(s);
    System.out.println(s1);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        if(null == s || s.isEmpty()) return s;
        int len =  s.length();
        // 判断当前字符是否曾经出现过
        boolean visited[]= new boolean[26];
        int count[] = new int[26];
        for(int i =0;i<len;i++){
            // 记录每个字符出现的次数
            count[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder(len);
        for(int i =0;i<len;i++){
            char c = s.charAt(i);
            int index = c-'a';
            if(visited[index]){
                count[index]--;
                continue;
            }
            // 循环处理已经进入单调栈但是栈顶元素小于当前元素且后面还有栈顶元素的情况，就可以删除当前栈顶了
            // 傻 不要在循环的时候把循环的sb的size啥的提出来,因为循环内部有对sb的delete！
            // int size = sb.length();while(size>0 && sb.charAt(size){sb.deleteCharAt(xxx)})
            while(sb.length()>0 &&
                    sb.charAt(sb.length()-1)>c
                    && count[sb.charAt(sb.length()-1)-'a']>0){
                visited[sb.charAt(sb.length()-1) - 'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c);
            visited[index] = true;
            count[index]--;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}