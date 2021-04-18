package Hot100;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai)。在坐标内画 n 条垂直线，垂直线 i的两个端点
//分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
class No11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        //自己的做法一
//        int max=0;
//        int area;
//        int len=height.length;
//        for (int i=0;i<len;i++){
//            for (int j=i+1;j<len;j++){
//                if (height[i]>height[j]){
//                    area=height[j]*(j-i);
//                } else {
//                    area=height[i]*(j-i);
//                }
//                if (area>max){
//                    max =area;
//                }
//            }
//        }
//        return max;
        //查看思路，做法二，双指针法
        int left=0,right=height.length-1;
        int max=0;
        while (left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            max = Math.max(area,max);
            if (height[left]<height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No11_ContainerWithMostWater test = new No11_ContainerWithMostWater();
        int num = test.maxArea(new int[]{1,1});
        System.out.println(num);
    }
}
