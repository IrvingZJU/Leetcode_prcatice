package Hot100.array;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class No283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        //思路1：未成功
//        int i=0;
//        int j=1;
//        while (i< nums.length || j< nums.length){
//            if (nums[i]==0){
//                i++;
//                j++;
//            }
//            if (nums[i]!=0 && nums[j]!=0){
//                j++;
//            }
//            if (nums[i]!=0 && nums[j]==0){
//                int temp=nums[i];
//                for (int k=i;k<j;k++){
//                    nums[k]=nums[k+1];
//                }
//                nums[j]=temp;
//                i++;
//            }
//        }
        //思路2：参考No27，移除指定元素val的思路，现在val==0，我们把非零元素筛选出来，其余元素赋值为0
//        int n= nums.length;
//        int start=0;
//        for (int i=0;i< n;i++){
//            if (nums[i]!=0){
//                nums[start]=nums[i];
//                start++;
//            }
//
//        }
//        //设0元素有m个，现在前n-m元素是结果的非零元素部分，后m个元素为原数组后m个元素（不管为多少，我们把它变为0既是所求结果）
//        for (int i=start;i<n;i++){
//            nums[i]=0;
//        }
        //思路3：双指针+快速排序
        int j=0;
        for (int i=0;i< nums.length;i++){
            if (nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int v:nums) {
            System.out.print(v+" ");
        }
    }
}
