package Hot100;
//给定一个n*n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转90度。你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
public class No48_RotateImage {
    public void rotate(int[][] matrix){
        //我的做法一：先把矩阵分为四个方块，然后先把一象限与四象限按90度旋转的值交换，把二象限与三象限交换，
        // 这样一三象限的值已搞定，最后处理二四象限，再交换一次即可。奇偶得分一下
        int n= matrix.length;
        int num = (n+1)/2; //一、三象限小方块的边长
        if (n%2==0) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) { //一四象限交换，搞定一
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = temp;
                }
            }
            for (int i = num; i < n; i++) {
                for (int j = num; j < n; j++) { //二三象限交换，搞定三
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = temp;
                }
            }
            for (int i = 0; i < num; i++) {
                for (int j = num; j < n; j++) { //二四象限交换，搞定二四
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j]=temp;
                }
            }
        }else {
            for (int i = 0; i < num-1; i++) {
                for (int j = 0; j < num; j++) { //一四象限交换
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = temp;
                }
            }
            for (int i = num; i < n; i++) {
                for (int j = num-1; j < n; j++) { //三二象限交换
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = temp;
                }
            }
            for (int i = 0; i < num; i++) {
                for (int j = num; j < n; j++) { //二四交换
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//        int[][] matrix = new int[][]{{1}};
        int n= matrix.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        No48_RotateImage test=new No48_RotateImage();
        test.rotate(matrix);
        System.out.println("旋转后：");
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
