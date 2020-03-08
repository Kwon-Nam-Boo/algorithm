package swexpert;

public class test2 {
	
	 public static void main(String[] args) {
	        long[] nums = new long[1000001];
	        for(int i = 1; i <= 1000000; i++) {
	            nums[i] = (nums[i-1] + pow(i,i)) % 1_000_000_007;
	        }
	        System.out.println(nums[1000]);

	    }
	 
	 public static long pow(int a, int n) {
			if(n==1) 
				return a;
			if(n%2==0) 		
				return pow(a,n/2)*pow(a,n/2)% 1_000_000_007;		// 재귀를 매번 두번씩 ..
			else				
				return pow(a,n/2)*pow(a,n/2)% 1_000_000_007* a % 1_000_000_007;
	}
	 
	public static long pow(int a, int b) {
	        if( b == 1 )
	            return a;
	        long tmp = pow(a, b/2);									// 재귀는 한번만
	        if( b % 2 == 0 )
	            return tmp * tmp % 1_000_000_007;					// 변수로 사용
	        else
	            return tmp * tmp % 1_000_000_007 * a % 1_000_000_007;
	}
	
}
