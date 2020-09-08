package com.cug.qiuzhao.ali;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    static BigInteger modBig = new BigInteger(String.valueOf(1000000007));
    static int modInt = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long ret = 0;
        for (int i = 0; i < (n / 2)+1; i++) {
            ret = (ret + (fastPower(m, n - i) + fastPower(m, i)) * C(n, i)) % modInt;
        }
        System.out.println(ret);
    }

    public static long fastPower(long a, long b) {
        long ans = 1;
        long base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = ans * base % modInt;
            }
            //权值增加
            base = base * base % modInt;
            b >>= 1;
        }
        return ans % modInt;
    }

    public static long jiecheng(long n) {
//        BigInteger m = BigInteger.ONE;
        long m = 1;
        for (long i = 1; i <= n; i++) {
            m = m * i % modInt;
        }
        return m;
    }

    public static long C(int n, int m) {
        if (m == 0)
            return 1;
        if (m == 1)
            return n;
        long ret = jiecheng(m) * jiecheng(m - n) % modInt;
        return jiecheng(n) / ret;
    }


}
