package Hot100;
//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
//如果反转后整数超过 32 位的有符号整数的范围[−2^31,2^31− 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
class No7_ReverseInteger {
//    public int reverse(int x) {
//        int wei=0;
//        int sum=0;
//        if (x >= (-Math.pow(2, 31)) && x <= Math.pow(2, 31) - 1) {
//            int y=Math.abs(x);
//            for(int i=1;i<=32;i++){
//                if(y/(int) Math.pow(10,i)==0){ //Math.pow()返回的是double类型，需转换为int
//                    wei=i;
//                    break; //如果不break,更高位数也符合判断条件，循环将进行到底
//                }
//            }
//            for(int i=1;i<=wei;i++){
//                sum += y%(int)Math.pow(10,i)/(int)Math.pow(10,i-1)*(int)Math.pow(10,wei-i);
//            }
//            if (x>=0)
//                return sum;
//            return -sum;
//        } else return 0;
//    }
    //上面自己的代码，异常判断（溢出问题）没有解决
public int reverse(int x) {
    int res = 0;
    while(x!=0) {
        //每次取末尾数字
        int tmp = x%10;
        //判断是否 大于 最大32位整数
        if (res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && tmp>7)) {
            return 0;
        }
        //判断是否 小于 最小32位整数
        if (res<-Integer.MAX_VALUE/10 || (res==-Integer.MAX_VALUE/10 && tmp<-8)) {
            return 0;
        }
        res = res*10 + tmp;
        x /= 10;
    }
    return res;
}

    public static void main(String[] args) {
        No7_ReverseInteger test=new No7_ReverseInteger(); //不用对象的方法就把上面reverse方法加一个static
        int num = test.reverse(15342364);
        System.out.println("reverse num="+num);
    }
}
