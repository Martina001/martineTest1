//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8989 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharactersXXX3{
public static void main(String[] args) {
Solution solution = new LongestSubstringWithoutRepeatingCharactersXXX3().new Solution();
// TO TEST
    int i = solution.lengthOfLongestSubstring("abacca");
    System.out.println(i);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer> window = new HashMap<>();
        int len = 0,l = 0,r = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            r++;
            window.put(c,window.getOrDefault(c,0)+1);
            while(window.get(c)>1){
                char left = s.charAt(l);
                l++;
                window.put(left,window.getOrDefault(left,0)-1);
            }
            // 这一段要放在外面 以保证最后的无重复子串也能参与
            if(r-l >len){
                len = r-l;
            }
        }
        return len;
        // 滑动窗口
        /*HashSet<Character> set = new HashSet<>();
        int res = set.size();
        int len = s.length(),rk = -1;
        for(int i = 0;i<len;i++){
            if(i != 0){
                // 注意remove的时候是要remove具体的字符而不是remove(i-1)
                set.remove(s.charAt(i-1));
            }
            while(rk+1<len && !set.contains(s.charAt(rk+1))){
                set.add(s.charAt(rk+1));
                rk++;
            }
            res = Math.max(res,rk+1-i);
        }
        return  res;*/


        // indexOf
        /* int m = s.length();
         if(m==0) {
             return 0;
         }
         int num =1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
         int max =1;
         for(int i=1;i<m;i++){
             // indexOf(char,fromIndex)
             // 直接借助indexOf找在前面遍历过的字符串中是否有出现过该字符
             int index = s.indexOf(s.charAt(i),i-num);
             if(index<i) {
                 //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                 num = i-index;
             } else {
                 num = num+1;
             }
             max = Math.max(max,num);
         }
         return max;*/
        // 哈希集合，记录每个字符是否出现过
        /*HashSet<Character> set = new HashSet<>();
        int n =s.length();
        int res = set.size();
        int rightNode =-1;
        for(int i = 0;i<s.length();i++){
            if (i != 0) {
                // 左指针向右移动一格，移除左指针的前一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rightNode + 1 < n && !set.contains(s.charAt(rightNode + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rightNode + 1));
                ++rightNode;
            }
            res = Math.max(res, rightNode+1 - i);
        }
        return res;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}