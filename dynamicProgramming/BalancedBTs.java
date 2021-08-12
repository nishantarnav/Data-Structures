package dynamicProgramming;

public class BalancedBTs {

	
	public static int countBalancedBTs(int h){		
		int mod = (int)Math.pow(10, 9) + 7;
		return countBalancedBTs(h, mod);
	}
	
	public static int countBalancedBTs(int h, int mod){		
		
		if(h == 0 || h == 1){
			return 1;
		}
		
		int x = countBalancedBTs( h - 1);
		int y = countBalancedBTs(h - 2);
		long res1 = (long)x * x;
		long res2 = (long)x * y * 2; 
		int value1 = (int)(res1 % mod);
		int value2 = (int)(res2 % mod);
		return  (value1 + value2) % mod;
	}
	public static int balancedBTs(int height){
 		if(height == 0){
 			return 1;
 		}
 		int arr[] = new int[height + 1];
 		arr[0] = arr[1] = 1;
 		int mod = (int) Math.pow(10, 9) + 7;
 		for(int i = 2; i <= height; i++){

 			// Cast to long
 			long temp1 = (long) (arr[i- 1]) * arr[ i - 1];
		temp1 = temp1 % mod;
			
             // Cast to long
            
 			long temp2 = 2 * (long) (arr[i - 1]) * arr[ i - 2];
 			temp2 = temp2 % mod;
			
 			arr[i] = (int) (temp1 + temp2) % mod;
 		}
 		return arr[height];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int h = 7;
			long ans = countBalancedBTs(h);
			System.out.println(ans);
	}

}