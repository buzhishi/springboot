package cn.jihui.ssm.computer;

/**
 *
 * 假设有一个数组 A ，int[] A = { 1 , 3 , -1 ,0 , 2 , 1 , -4 , 2 , 0 ,1 ...  N};
 * 原来是需要查出大于0的数组，但是由于传参错误或者其他原因，导致查出0和负数了，
 * 现在要求在不使用新数组和新集合的情况下（即只使用这个A数组，因数组数据比较大，且只能用一次循环）
 * 实现正数放到数组的前面，小于等于0的数放到数组的末尾
 *
 */

public class SelectArrTest {
    public static void main(String[] args) {
        int[] A = { 1 , 3 , -1 ,0 , 2 , 1 , -4 , 2 , 0 ,1};
        // 不使用额外数组，直接使用头结点和尾结点来做处理|
        int num = 0;
        int temp ;
        int length = A.length;
        for (int i = 0; i <length ; i++) {
            if(A[i]<0){
                temp =  A[A.length-1-num];
                A[A.length-1-num] = A[i];
                A[i] = temp;
                num++;
             }
        }


        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+",");
        }
    }
}
