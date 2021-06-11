package Hot100.array;

import java.util.Arrays;

//给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
public class No75_SortColors {
    public static void sortColors(int[] nums) {
        //方法一，遍历一遍，0移到前面，2移到后面
//        for (int i=0;i< nums.length;i++){
//            if (nums[i]==0){
//                for (int j=i;j>0;j--){
//                    nums[j]=nums[j-1];
//                }
//                nums[0]=0;
//            }
//            if (nums[i]==2){
//                for (int j=i;j< nums.length-1;j++){
//                    nums[j]=nums[j+1];
//                }
//                nums[nums.length-1]=2;
//            }
//            System.out.println(Arrays.toString(nums));
//        }

        //方法二，暴力解，冒泡
//        for (int i=0;i< nums.length-1;i++){
//            for (int j=0;j< nums.length-1;j++){
//                if (nums[j]>nums[j+1]){
//                    //普通交换
////                    int temp=nums[j];
////                    nums[j]=nums[j+1];
////                    nums[j+1]=temp;
//                    //位运算交换
//                    nums[j]=nums[j]^nums[j+1];
//                    nums[j+1]=nums[j]^nums[j+1];
//                    nums[j]=nums[j]^nums[j+1];
//                }
//            }
//        }

        //方法三，计数排序，遍历一遍统计0,1,2各出现多少次，然后再遍历一遍修改原数组
        if (nums.length==1)
            return;
        int zero=0,one=0,two=0;
        for (int num : nums) {
            if (num == 0)
                zero++;
            if (num == 1)
                one++;
            if (num == 2)
                two++;
        }
        for (int i=0;i<zero;i++)
            nums[i]=0;
        for (int i=zero;i<zero+one;i++)
            nums[i]=1;
        for (int i=zero+one;i<nums.length;i++)
            nums[i]=2;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,0,2,1,1,0,1,2,0,2};
        System.out.println("before:"+Arrays.toString(nums));
        sortColors(nums);
        System.out.println("after:"+Arrays.toString(nums));
    }
}
