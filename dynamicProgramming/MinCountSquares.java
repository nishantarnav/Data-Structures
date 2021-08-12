package dynamicProgramming;

public class MinCountSquares {
 
	public static void main(String args[]) {
		int n=10;
		System.out.println(minCountM(n));
		System.out.println(minCountDP(n));
	}
	public static int minCountM(int n){
		int[] storage= new int[n+1];
       
        return minCountM(n,storage);
    }
    public static int minCountM(int n, int[] storage){
        if(n<=3){
            storage[n]=n;
            return storage[n];
        }
        if(storage[n]!=-1){
			return storage[n];
        }
        int res=n;
        for(int i=1;i<=Math.sqrt(n);i++){
        res = Math.min(res, 1 + minCountM(n - i*i,storage));
	    }
        storage[n]=res;
        return storage[n];
        }
	public static int minCountDP(int n) {
	// Write your code here
if(n<=3) 
	return n;
    int count[] = new int[n+1];
    count[1] = 1;
    count[2] = 2;
    count[3] = 3;

    for(int i = 4 ; i<=n ; i++)
    {
        int ans = i;
        for(int j = 1 ; j<= i/2 ; j++){
            int k = i - (j*j);
            if(k>=0)
            ans = Math.min(ans , count[k] + 1 );
        }
        count[i] = ans;
    }

    return count[n];
    }
    }

