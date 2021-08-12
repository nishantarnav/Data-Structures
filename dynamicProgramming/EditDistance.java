package dynamicProgramming;

public class EditDistance {

	public static void main(String[] args) {
		String s1="abc";
		String s2="dc";
		System.out.println(editDistance(s1, s2));
		System.out.println(editDistanceM(s1, s2));
		System.out.println(editDistanceDP(s1, s2));
	}
	
	public static int editDistance(String s1, String s2){
	int m = s1.length();
	int n = s2.length();
	//base case
	if(m==0 ) {
		return n;
	}
	if(n==0) {
		return n;
	}
	if(s1.charAt(0)==s2.charAt(0)) {
		return editDistance(s1.substring(1),s2.substring(1));
	}
	else {
	   int opt1= editDistance(s1,s2.substring(1));	                                     //insertion	
	  int   opt2=editDistance(s1.substring(1),s2);		                               	//deletion	
		int opt3=editDistance(s1.substring(1),s2.substring(1));                        //replacement
		return 1+Math.min(opt1, Math.min(opt2, opt3));
	}
	}
	public static int editDistanceM(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		//m+1*n+1 matrix
		int [][] storage= new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				storage[i][j]=-1;
			}
		}
		return editDistanceM(s1,s2,storage);
		
	
	}

	private static int editDistanceM(String s1, String s2, int[][] storage) {
		int m=s1.length();
		int n=s2.length();
		if(m==0 ) {
			storage[0][n]=n;
		}
		if(n==0) {
			storage[m][0]= m;
		}
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			storage[m][n]= editDistance(s1.substring(1),s2.substring(1));
			
		}
		else {
		   int opt1= editDistance(s1,s2.substring(1));	                                     //insertion	
		  int   opt2=editDistance(s1.substring(1),s2);		                               	//deletion	
			int opt3=editDistance(s1.substring(1),s2.substring(1));                        //replacement
			storage[m][n]= 1+Math.min(opt1, Math.min(opt2, opt3));
		}
		return storage[m][n];
	}
	private static int editDistanceDP(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		int [][] storage= new int[m+1][n+1];
		
	
		for(int i=0;i<n+1;i++) {
			storage[0][i]=i;
		}
		for(int j=1;j<m+1;j++) {
			storage[j][0]=j;
		}
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s1.charAt(m-i)==s2.charAt(n-j)) { 
					storage[i][j] = storage[i-1][j-1];
				}
				else {
					storage[i][j]=1+ Math.min(storage[i-1][j], Math.min(storage[i][j-1],storage[i-1][j-1]));
				}
			}
		}
		return storage[m][n];
		
	}
}
