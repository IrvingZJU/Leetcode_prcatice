package Hot100;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。设无重复元素。
class No35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
//        自己尝试发现边界条件不容易解决，再下面是参考的代码
//        int left=0,right=nums.length-1;
//        while (left<right){
//            int mid=left+(right-left)/2;
//            if (nums[mid]<target)
//                left=mid;
//            if (nums[mid]>target)
//                right=mid;
//            if (nums[mid]==target || (nums[mid]>target && nums[mid-1]<target)) {
//                right=mid;
//                return mid;
//            }
//        }
//        return left;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left+(right-left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int result=searchInsert(new int[]{1,2,3,5,6,7},4);
        System.out.println(result);
    }
}
