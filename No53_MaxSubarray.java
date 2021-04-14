package Hot100;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
public class No53_MaxSubarray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE; //一开始写的是0，没有考虑最后最大值可能为负数
        //解法一，时间复杂度O(n^3)
//        int sum=0;
//        if (nums.length==1){
//            return nums[0];
//        }else {
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i; j < nums.length; j++) {
//                    for (int k=i;k<=j;k++){
//                        sum+=nums[k];
//                    }
//                    if (sum>max){
//                        max=sum;
//                    }
//                    sum=0;
//                }
//            }
//            return max;
        //解法二，时间复杂度O(n^2)
//        for (int i = 0; i < nums.length; i++) {
//            int sum=0;
//            for (int j = i; j < nums.length; j++) {
//                sum+=nums[j];
//                max=Math.max(max,sum);
//            }
//        }
//        return max;
        //解法三，动态规划，复杂度O(n)
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i=1;i< nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        for (int i=0;i<dp.length;i++){
            if (dp[i]>max)
                max=dp[i];
        }
        return max;
    }


    public static void main(String[] args) {
        int result = maxSubArray(new int[]{-2, 1});
        System.out.println(result);
    }
}
