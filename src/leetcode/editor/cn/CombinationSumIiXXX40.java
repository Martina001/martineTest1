//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1362 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
public class CombinationSumIiXXX40 {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIiXXX40().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (null == candidates || candidates.length == 0) return res;
            // 排序和下面的判断nums[i-1] == nums[i] 是为了去除由于nums中的重复数据导致的结果重复
            Arrays.sort(candidates);
            getCombine2(candidates, 0, target);
            return res;
        }

        List<Integer> track = new ArrayList<>();

        private void getCombine2(int[] nums, int start, int target) {
            if (target == 0) {
                res.add(new ArrayList<>(track));
                return;
            }
            if (target < 0) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                track.add(nums[i]);
                getCombine2(nums, i + 1, target - nums[i]);
                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}