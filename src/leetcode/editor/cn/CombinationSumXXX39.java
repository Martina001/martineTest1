//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics 数组 回溯 👍 2511 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合总和
public class CombinationSumXXX39{
public static void main(String[] args) {
Solution solution = new CombinationSumXXX39().new Solution();
// TO TEST
    solution.combinationSum(new int[]{2,3,7},7);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(null == candidates || candidates.length == 0) return res;
//        traverse(candidates,new ArrayList<>(),0,target);
        getZuHe(candidates,0,target);
        return res;
    }
    List<Integer> track = new ArrayList<>();
    int sum =0;
    private void getZuHe(int nums[],int start,int target){
        if(sum >target){
            return;
        }
        if(sum == target){
            // 注意要new
            res.add(new ArrayList<>(track));
        }
        for(int i = start;i<nums.length;i++){
            track.add(nums[i]);
            sum += nums[i];
            // 无重复元素，可重复被选取
            // 如果是重复元素，那么就需要排序，然后这里判断如果当前值和i-1的值相等就跳过
            getZuHe(nums,i,target);
            sum-= nums[i];
            track.remove(track.size()-1);
        }
    }


    private void traverse(int[] nums,List<Integer> track ,int start,int tempSum){
        if(tempSum <=0){
            if(tempSum == 0){
                res.add(new ArrayList<>(track));
            }
            return;
        }
        // 如果start一直是0，就是找排列，而不是组合：【2，3】和【3，2】是同种组合，两种排列
        for(int i = start;i<nums.length;i++){
            track.add(nums[i]);
            traverse(nums,track,i,tempSum-nums[i]);
            track.remove(track.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}