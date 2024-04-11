package lc;

import java.util.Random;

/**
 * @author: Martina
 * @description:
 * @time: 2022/8/20
 */
public class Test {
    public static void main(String[] args) {
//        int[] arr = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        int[] arr = {3, 3, 4, 5, 3};
        Random random = new Random();
        for(int k=0;k<arr.length;k++){
            // random的nextInt左闭右开，生成0-参数之间的随机数
            int i = random.nextInt(arr.length-k);
            swap(arr,k,k+i);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(String.valueOf(arr));
    }
    private static void quickSort(int[] arr,int l,int r){
        // 递归结束条件别忘了
        if(l>=r) return;
        int p = biaPointsGetP(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    private static int getP(int nums[],int l,int h){
        int tempL = l;
        int p = nums[l];
        for(int i = l+1;i<=h;i++){
            // tempL指向的是距离i最近的那个小于p的索引
            // 如果当前值大于p，则继续
            // 如果小于等于p，就需要和tempL互换
            if(nums[i] <= p){
                tempL++;
                swap(nums,tempL,i);
            }
        }
        swap(nums,tempL,l);
        return tempL;
    }

    private static int getPFromH(int nums[],int l,int h){
        int p = nums[h];
        int tempH = l;
        for(int i = l;i<h;i++){
            if(nums[i]<=p){
                swap(nums,i,tempH);
                tempH++;
            }
        }
        swap(nums,tempH,h);
        return tempH;
    }

    /**
     * 双指针法获取Pivot
     *
     * @return
     */
    private static int biaPointsGetP(int nums[],int l,int r){
        int temp = nums[l];
        int i = l,j =r;
        while(i<j){
            while(i<j && nums[j]>=temp){
                j--;
            }
            while(i<j && nums[i]<=temp){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums,l,i);
        return i;
    }

    private static void swap(int nums[],int a,int b){
        int temp= nums[a];
        nums[a] = nums[b];
        nums[b] =temp;
    }
}
