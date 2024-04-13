//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2714 👎 0

package leetcode.editor.cn;

//Java：最长公共前缀
public class LongestCommonPrefixXXX14 {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefixXXX14().new Solution();
// TO TEST
        String[] a = {"flower","flow","flight"};
        String s = solution.longestCommonPrefix(a);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
//            return meth(strs,0,strs.length-1);
            if (strs.length == 0){
                return "";
            }
            String common_prefix = strs[0];
            for (String str: strs){
                while (str.indexOf(common_prefix) != 0) {
                    common_prefix = common_prefix.substring(0, common_prefix.length() - 1);
                    if (common_prefix.isEmpty())
                        return "";
                }
            }
            return common_prefix;
        }
        private String meth(String[] strs,int start,int end){
            if(start == end){
                return strs[start];
            }
            String leftStr = meth(strs,start,(start+end)/2);
            String rightStr = meth(strs,(start+end)/2+1,end);
            return getSameStr(leftStr,rightStr);
        }
        private String getSameStr(String l,String r){
            int len = l.length();
            if(r.length()<len) len= r.length();
            StringBuffer res =new StringBuffer();
            for(int i = 0;i<len;i++){
                if(l.charAt(i) != r.charAt(i)){
                    break;
                }
                res.append(l.charAt(i));
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}