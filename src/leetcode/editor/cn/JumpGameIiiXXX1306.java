//这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - 
//arr[i]。 
//
// 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。 
//
// 注意，不管是什么情况下，你都无法跳到数组之外。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,2,3,0,3,1,2], start = 5
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案： 
//下标 5 -> 下标 4 -> 下标 1 -> 下标 3 
//下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3 
// 
//
// 示例 2： 
//
// 输入：arr = [4,2,3,0,3,1,2], start = 0
//输出：true 
//解释：
//到达值为 0 的下标 3 有以下可能方案： 
//下标 0 -> 下标 4 -> 下标 1 -> 下标 3
// 
//
// 示例 3： 
//
// 输入：arr = [3,0,2,1,2], start = 2
//输出：false
//解释：无法到达值为 0 的下标 1 处。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 5 * 10^4 
// 0 <= arr[i] < arr.length 
// 0 <= start < arr.length 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 👍 169 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：跳跃游戏 III
public class JumpGameIiiXXX1306{
public static void main(String[] args) {
Solution solution = new JumpGameIiiXXX1306().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReach(int[] arr, int start) {
        /*int n = arr.length;
        if(start>=n || start<0 || arr[start] == -1) return false;
        int val = arr[start];
        if(val == 0)return true;
        // 这种方式表示是否已经遍历过
        arr[start] = -1;
        return canReach(arr,start+val) || canReach(arr,start-val);*/
        boolean b = canR(arr, start);
        return b;
    }
    // 写一下类似于BFS搜索二叉树的代码，其实就是一样的
    private boolean canR(int []arr,int start){
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        boolean visited[]  = new boolean[n];
        q.offer(start);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i =0;i<sz;i++){
                Integer cur = q.poll();
                if(cur <0 || cur >=n) continue;
                if(visited[cur]) continue;
                if(arr[cur] ==  0){
                    return true;
                }

                visited[cur] =true;
                q.offer(cur+arr[cur]);
                q.offer(cur-arr[cur]);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}