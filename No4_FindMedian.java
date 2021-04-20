package Hot100;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
class No4_FindMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //暴力解法，先合并再冒泡排序
        int len=nums1.length+nums2.length;
        int[] nums=new int[len];
        for (int i=0;i< nums1.length;i++){
            nums[i]=nums1[i];
        }
        for (int i=0;i< nums2.length;i++){
            nums[i+ nums1.length]=nums2[i];
        }
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if (nums[i]>nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        if (len%2==0)
            return (double)(nums[len/2-1]+nums[len/2])/2;
        if (len%2==1)
            return nums[len/2];
        return 0;

//        int len=nums1.length+nums2.length;
//        int[] nums=new int[len];
//        for (int i=0;i< nums1.length;i++){
//            nums[i]=nums1[i];
//        }
//        int len1=nums1.length;
//        for (int i=0;i< nums2.length;i++){
//            for (int j=0;j< len1;j++){
//                while (nums2[i]>=nums1[j] && nums2[i]<=nums1[j+1]){
//                    for (int k=0;k<j+1;k++){
//
//                    }
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        int[] a={0};
        int[] b={};
        No4_FindMedian test=new No4_FindMedian();
        double result=test.findMedianSortedArrays(a,b);
        System.out.println(result);
    }
}
