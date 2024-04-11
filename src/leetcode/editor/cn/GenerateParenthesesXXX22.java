//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3195 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class GenerateParenthesesXXX22{
public static void main(String[] args) {
Solution solution = new GenerateParenthesesXXX22().new Solution();
// TO TEST
    List<String> strings = solution.generateParenthesis(3);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
//        backTrack("",0,0,n);
        generateBackTrack(new StringBuilder(),0,0,n);
        return res;
    }

    private void generateBackTrack(StringBuilder track,int l,int r,int len){
        if(track.length() == 2*len){
            res.add(track.toString());
            return;
        }
        if(l<len){
            generateBackTrack(track.append("("),l+1,r,len);
            track.deleteCharAt(track.length()-1);
        }
        if(r<l){
            generateBackTrack(track.append(")"),l,r+1,len);
            track.deleteCharAt(track.length()-1);
        }
    }
    private void backTrack(String track,int l,int r,int len){
        if(track.length() == 2*len){
            res.add(track);
            return;
        }
        if(l<len){
            backTrack(track+"(",l+1,r,len);
        }
        if(r<l){
            backTrack(track+")",l,r+1,len);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}