package Hot100.array;
//给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
//请不要使用除法，且在 O(n) 时间复杂度内完成此题。你还可以在常数空间复杂度内完成这个题目吗？
public class No238_ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        //我的做法一:将元素左边的元素累乘结果保存在left，将元素右边的元素累乘保存在right，最后对应位置left*right即是结果
        //代码可简化：只需新建一个res[]，在第二个循环时res[i]*=R_temp即可，无需第三个循环
        int n= nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] res=new int[n];
        left[0]=1;
        right[n-1]=1;
        int L_temp=1;
        for (int i=1;i<n;i++){
            L_temp=nums[i-1]*L_temp;
            left[i]=L_temp;
        }
        int R_temp=1;
        for (int i=n-2;i>=0;i--){
            R_temp=nums[i+1]*R_temp;
            right[i]=R_temp;
        }
        for (int i=0;i<n;i++){
            res[i]=left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4};
        int[] res=productExceptSelf(nums);
        for (int v:res) {
            System.out.print(v+" ");
        }
    }
}
