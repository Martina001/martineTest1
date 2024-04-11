//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1608 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
public class CombinationsXXX77{
public static void main(String[] args) {
Solution solution = new CombinationsXXX77().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(k>n) return res;
        /*if(k==n){
            List<Integer> list = new ArrayList<>();
            for(int i =1;i<=n;i++){
                list.add(i);
            }
            res.add(list);
            return res;
        }*/
        getCombine(n,1,k);
        return res;
    }

    List<Integer> track = new ArrayList<>();
    private void getCombine(int n,int start,int k){
        if(track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }
        if(track.size()>k){
            return;
        }

        for(int i =start;i<=n;i++){
            track.add(i);
            getCombine(n,i+1,k);
            track.remove(track.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}