package swexpert;

import java.util.Scanner;

class test
{
    static long pow(int a, int b) {
        if( b == 1 )
            return a;
        long tmp = pow(a, b/2);
        if( b % 2 == 0 )
            return tmp * tmp % 1_000_000_007;
        else
            return tmp * tmp % 1_000_000_007 * a % 1_000_000_007;
    }
    public static void main(String[] args) {
        long[] nums = new long[1000001];
        for(int i = 1; i <= 1000000; i++) {
            nums[i] = (nums[i-1] + pow(i,i)) % 1_000_000_007;
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            System.out.println("#" + tc + " " + nums[N]);
        }
    }
}