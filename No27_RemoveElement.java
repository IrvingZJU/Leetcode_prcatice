package Hot100;
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
public class No27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[count]=nums[i];
                count+=1;
            }
        }
        // 另外显示一下最终的数组，发现其实没有把数组的5元素真的移除，只是保证前(数组长度-等于val的元素个数)个元素中不含有val，
        // 要真的移除的话，得新建数组int[] new_num=new int[result]; 然后循环中赋值new_num[i]=nums[i];
        for (int n:nums){
            System.out.print(n+" ");
        }
        System.out.println();
        return count;
    }

    public static void main(String[] args) {
        No27_RemoveElement test = new No27_RemoveElement();
        int result = test.removeElement(new int[]{1,4,5,5,5,2},5);
        System.out.println(result);
    }
}
