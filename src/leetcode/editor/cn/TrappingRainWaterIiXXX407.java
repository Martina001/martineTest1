//给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
//输出: 4
//解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
//输出: 10
// 
//
// 
//
// 提示: 
//
// 
// m == heightMap.length 
// n == heightMap[i].length 
// 1 <= m, n <= 200 
// 0 <= heightMap[i][j] <= 2 * 10⁴ 
// 
//
// 
//
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 721 👎 0

package leetcode.editor.cn;
//Java：接雨水 II
public class TrappingRainWaterIiXXX407{
public static void main(String[] args) {
Solution solution = new TrappingRainWaterIiXXX407().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trapRainWater(int[][] heightMap) {
        // 这道题没啥意思，其实就是跟42接雨水是一个逻辑，只不过从二维变成了四维，所以每个柱子可承接水的体积就是1*四周最低高度
        // 这时候可以用优先级队列直接得到最低高度的值
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}