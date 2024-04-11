package lc;

import java.util.Random;

/**
 * @author: Martina
 * @description:
 * @time: 2024/2/20
 */
public class QSort1 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 1,4,5, 3, 2, 1, 2};
        sort(a, 0, a.length - 1);
        System.out.println(a.length);
    }

    private static final Random rand = new Random();
    private static void sort(int[] nums, int low, int high) {
        if (low >= high) return;
        int p = getPRandom(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    private static int getPRandom(int a[],int l,int r){
        int pivotIndex = l + rand.nextInt(r - l + 1);
        swap(a, pivotIndex, r);
        return getPFromL(a,l,r);
    }

    private static int getP(int[] a,int l,int r){
        // 单向 从r开始，如果从l开始也可以的，如下
        int p = a[r];
        int temp = l-1;
        for(int j = l;j<r;j++){
            if(a[j]<= p){
                temp++;
                // temp一直是小于等于p值的最大索引
                swap(a,temp,j);
            }
        }
        swap(a,temp+1,r);
        // 返回temp+1的位置
        return temp+1;
    }

    private static int getPFromL(int [] a,int l,int r){
        int p  = a[l];
        int temp = l;
        //注意是j<=r
        for(int j = l;j<=r;j++){
            // 这里开始比较，找出比p小的就互换，这样保证temp一直是小于p值的最大索引
            if(a[j]<p){
                temp++;
                swap(a,temp,j);
            }
        }
        swap(a,temp,l);
        return temp;
    }

    private static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
