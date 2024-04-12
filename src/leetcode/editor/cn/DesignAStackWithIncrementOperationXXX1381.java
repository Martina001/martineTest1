//请你设计一个支持对其元素进行增量操作的栈。 
//
// 实现自定义栈类 CustomStack ： 
//
// 
// CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量。 
// void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。 
// int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。 
// void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。 
//
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["CustomStack","push","push","pop","push","push","push","increment",
//"increment","pop","pop","pop","pop"]
//[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
//输出：
//[null,null,null,2,null,null,null,null,null,103,202,201,-1]
//解释：
//CustomStack stk = new CustomStack(3); // 栈是空的 []
//stk.push(1);                          // 栈变为 [1]
//stk.push(2);                          // 栈变为 [1, 2]
//stk.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
//stk.push(2);                          // 栈变为 [1, 2]
//stk.push(3);                          // 栈变为 [1, 2, 3]
//stk.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
//stk.increment(5, 100);                // 栈变为 [101, 102, 103]
//stk.increment(2, 100);                // 栈变为 [201, 202, 103]
//stk.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
//stk.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
//stk.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
//stk.pop();                            // 返回 -1 --> 栈为空，返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= maxSize, x, k <= 1000 
// 0 <= val <= 100 
// 每种方法 increment，push 以及 pop 分别最多调用 1000 次 
// 
//
// Related Topics 栈 设计 数组 👍 98 👎 0

package leetcode.editor.cn;
//Java：设计一个支持增量操作的栈
public class DesignAStackWithIncrementOperationXXX1381{
public static void main(String[] args) {
//Solution solution = new DesignAStackWithIncrementOperationXXX1381().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class CustomStack {
    // 1。 直接使用双栈比较直接，就是保存一个元素总和，当递增的时候用备用栈倒出来，从倒到n-k的时候开始增加，然后再倒回去原来的栈

    // 2。 其实这道题考察的是模拟的思想，用数组表示栈，会更直接一点，每次incre就遍历0-k对数组执行++就行，这样incre的复杂度是Ok

    // 3。 有一个比较巧妙的方法就是使用前缀和数组的思想，用数组实现栈，保存一个addArr[i]表示在i位置需增加的值，这样每次increment只用增加addArr[k]位置的值
    // push保存一个栈顶索引，topIndex，pop的时候需要拿到stack[topIndex]+addArr[topIndex]的值
    // 又因为每次incre的时候只是增加了addArr[k],为了保证每次取到的值都是已经被加过的，所以每次pop以后，addArr[topIndex-1]位置也要增加addArr[topIndex]
    // 这样看似有点难理解，但是想清楚了就很妙了，可以保证incre的时候复杂度都是O1

    int [] stack;
    int addArr[];

    int topIndex;

    // 直接写一下前缀和方式
    public CustomStack(int maxSize) {
        addArr = new int[maxSize];
        stack = new int[maxSize];
        topIndex = -1;
    }
    
    public void push(int x) {
        if(topIndex == stack.length-1){
            return ;
        }
        stack[++topIndex] = x;
    }
    
    public int pop() {
        if(topIndex==-1){
            return -1;
        }

        int addVal = addArr[topIndex];
        int res = stack[topIndex]+addVal;

        // 更新最新top索引处的add值
        if(topIndex>=1){
            addArr[topIndex-1] += addVal;
        }
        // 记得还原addArr[topIndex] =0
        addArr[topIndex] =0;
        topIndex--;
        return res;
    }
    
    public void increment(int k, int val) {
        // 这里要用topIndex和K比较
        int actualK = Math.min(k,topIndex+1);
        if(actualK >=1){
            addArr[actualK-1] +=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}