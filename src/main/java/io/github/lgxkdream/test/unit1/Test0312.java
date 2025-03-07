package io.github.lgxkdream.test.unit1;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test0312
 * @description
 * @since 2020-03-12 19:37
 */
public class Test0312 {

    public static void main(String[] args) {

        System.out.println(Jump3(4));
        System.out.println(Jump4(4, 5));
    }

    public static int Jump3(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return 2 * Jump3(n - 1);
        }
    }

    public static int Jump4(int n,int m ) {
        //当大于m的时候是上面的公式
        if(n > m){
            return 2*Jump4(n-1, m)-Jump4(n-1-m, m);
        }
        //当小于等于m的时候就是和n级的相同了
        if (n <= 1) {
            return 1;
        } else {
            return 2 * Jump4(n - 1,n);
        }
    }

}
