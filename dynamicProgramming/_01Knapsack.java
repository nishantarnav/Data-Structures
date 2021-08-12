package dynamicProgramming;

public class _01Knapsack {

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		return knapsack(weights,values,n,maxWeight,0);
	}
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight,int i){
        if(maxWeight==0 || i==weights.length){
            return 0;
        }
        if(weights[i]<=maxWeight){
            return knapsack(weights,values,n,maxWeight,i+1);
        }
        else{
            	//include the weight
				int opt1= values[i]+ knapsack(weights,values,n,maxWeight-weights[i],i+1);
            	//not including the weight
            	int opt2= knapsack(weights,values,n,maxWeight,i+1);
            	 return Math.max(opt1,opt2);
        }
       
    }

	    public static int knapsackM(int[] weight, int[] value, int n, int maxWeight) {
			int storage[][]= new int[n][maxWeight+1];
			for(int i=0;i<n;i++) {
				for(int j=0;j<maxWeight+1;j++) {
					storage[i][j]=-1;
				}
			}
			return knapsackM(weight,value,n,maxWeight,0,storage);
		}
		private static int knapsackM(int[] weights, int[] values, int n, int maxWeight, int i, int[][] storage) {
			
	        if(maxWeight==0 || i==weights.length){
	            return 0;
	        	/*storage[i][maxWeight]=0;
	            return storage[i][maxWeight];*/
	        }
	        if(storage[i][maxWeight]!=-1) {
	        	return storage[i][maxWeight];
	        }
	        if(weights[i]>maxWeight){
	            storage[i][maxWeight]= knapsackM(weights,values,n,maxWeight,i+1,storage);
	            return storage[i][maxWeight];
	        }
	        else{
	            	//include the weight
					int opt1= values[i]+ knapsackM(weights,values,n,maxWeight-weights[i],i+1,storage);
	            	//not including the weight
	            	int opt2= knapsackM(weights,values,n,maxWeight,i+1,storage);
	            	storage[i][maxWeight] = Math.max(opt1,opt2);
	            	return storage[i][maxWeight];
	        }
	        
	       
	    }
	
	public static void main(String[] args) {
		int weights[]= {6,1,2,4,5};
		int values[]= {10,5,4,8,6};
		int maxWeight=5;
		System.out.println(knapsack(weights,values,weights.length,maxWeight));
		System.out.println(knapsackM(weights,values,weights.length,maxWeight));

	}

}
