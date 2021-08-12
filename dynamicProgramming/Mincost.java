package dynamicProgramming;

public class Mincost {

	public static void main(String[] args) {
		int input[][]= {{1,1,1},{4,5,2},{7,8,9}};
		System.out.println(minCostPath(input));
		System.out.println(minCostPathM(input));
		System.out.println(minCostPathDP(input));

	}
	public static int minCostPath(int[][] input) {
		return minCostPath(input,0,0);
	}
    public static int minCostPath(int[][] input,int i,int j) {
		int m=input.length;
        int n=input[0].length;
        if(i==m-1 && j==n-1){
			return input[m-1][n-1];
        }
        if(i>=m || j>=n) {
        	return Integer.MAX_VALUE;
        }
        int ans=Math.min(minCostPath(input,i+1,j),Math.min(minCostPath(input,i,j+1),minCostPath(input,i+1,j+1)));
        
        int res = input[i][j] + ans;
        return res;
    }
    public static int minCostPathM(int[][] input) {
    	int m=input.length;
        int n=input[0].length;
    	int[][] storage= new int[m][n];
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			storage[i][j] = -1;
    		}
    	}
    	return minCostPathM(input,0,0,storage);
    }
    public static int minCostPathM(int[][] input,int i,int j,int[][] storage) {
    	int m=input.length;
        int n=input[0].length;
        if(i==m-1 && j==n-1) {
        	storage[m-1][n-1]=input[i][j];
        	return storage[i][j];
        }
        if(i>=m || j>=n) {
        	return Integer.MAX_VALUE;
        }
        if(storage[i][j]!=-1) {
        	return storage[i][j];
        }
        storage[i][j]= input[i][j] + Math.min(minCostPathM(input,i+1,j,storage),Math.min(minCostPathM(input,i,j+1,storage),minCostPathM(input,i+1,j+1,storage)));
        return storage[i][j];
    }
    
	private static int minCostPathDP(int[][] input) {
		//we just need to make a storage matrix with all the values in places as their minCost
		int m=input.length;
        int n=input[0].length;
    	int[][] storage= new int[m][n];
    	// no need of MIN_VALUE as those are adjusted in the loop
    	 storage[m-1][n-1]=input[n-1][n-1];
    	 for(int j=n-2;j>=0;j--) {
    		 storage[m-1][j]= storage[m-1][j+1] + input[m-1][j];
    	 }
    	 for(int i=m-2;i>=0;i--) {
    		 storage[i][n-1]= storage[i+1][n-1]+input[i][n-1];
    	 }
    	 for(int i=m-2;i>=0;i--) {
    		 for(int j=n-2;j>=0;j--) {
    			 storage[i][j]=  input[i][j]+Math.min(storage[i+1][j], Math.min(storage[i+1][j+1],storage[i][j+1]));
    			
    		 }
    		 
    	 }
    	 return storage[m][n];
		
	}
    
    
}
