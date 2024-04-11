//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics 数组 回溯 👍 691 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和 III
public class CombinationSumIiiXXX216{
public static void main(String[] args) {
Solution solution = new CombinationSumIiiXXX216().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
//        traverse(new ArrayList<>(),1,k,n);
        getCombine3(n,1,k);
        return res;
    }

    List<Integer> track = new ArrayList<>();
    private void getCombine3(int targetSum,int start,int k){
        if(track.size()>k){
            return;
        }
        if(track.size() == k){
            if(targetSum ==0){
                res.add(new ArrayList<>(track));
            }
            return;
        }
        for(int i =start;i<=9;i++){
            track.add(i);
            getCombine3(targetSum-i,i+1,k);
            track.remove(track.size()-1);
        }
    }


    private void traverse(List<Integer> track,int start,int k,int target){
        if(target <0 || track.size()>k) return;
        if(target == 0){
            if(track.size() == k){
                res.add(new ArrayList<>(track));
            }
            return;
        }
        // 这里从start开始，去除已经加入路径的数字
        for(int i = start;i<=9;i++){
            track.add(i);
            // 注意这里是i+1，去除已经加入路径的数字
            traverse(track,i+1,k,target-i);
            track.remove(track.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}