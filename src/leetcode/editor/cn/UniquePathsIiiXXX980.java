//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
//
// Related Topics 位运算 数组 回溯 矩阵 👍 351 👎 0

package leetcode.editor.cn;

//Java：不同路径 III
public class UniquePathsIiiXXX980 {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIiiXXX980().new Solution();
        int[][] d = new int[][]{{1, 0}, {2, 0}};
//        int i = solution.uniquePathsIII(d);
        System.out.println(1 << 3);
        System.out.println(1 << -3);
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;

        public int uniquePathsIII(int[][] grid) {
//        因为四个方向都能走 所以不能再向62 63题"不同路径"一样用动态规划了
            // 直接使用回溯，注意结束的条件：当前索引不满足条件；当前已经走过；当前是障碍
//            时间复杂度：总节点数为m*n,可以看成是个3叉树，所以为O(3^{mn}) 空间复杂度 O(mn)
            m = grid.length;
            n = grid[0].length;
            int count = 0;
            int startX = 0, startY = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        count++;
                    } else if (grid[i][j] == 1) {
                        count++;
                        startX = i;
                        startY = j;
                    }
                }
            }
            return dfs(grid, startX, startY, count);
        }


        private int dfs(int[][] grid, int x, int y, int remainCnt) {
            if (unLegal(x, m) || unLegal(y, n) || grid[x][y] == -1) {
                return 0;
            }
            if (grid[x][y] == 2) {
                if (remainCnt == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            // mark
            grid[x][y] = -1;
            int res = 0;
            //记住这个写法，在网格矩阵中遍历
            int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                res += dfs(grid, nx, ny, remainCnt - 1);
            }
            // unmark
            grid[x][y] = 0;
            return res;
        }

        private boolean unLegal(int index, int max) {
            return index < 0 || index >= max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}