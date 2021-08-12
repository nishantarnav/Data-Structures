package dynamicProgramming;
//Longest Common Subsequence
public class LCS {

	public static void main(String[] args) {
		String s1="adgeidajc";
		String s2="abegid ";
		System.out.println(lcsM(s1,s2));
		System.out.println(lcs(s1,s2));
		System.out.println(lcsDP(s1,s2));
		
	}
	public static int lcs(String s1,String s2) {
		if(s1.length()==0 || s2.length()==0) {
			return 0;
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			return 1+lcs(s1.substring(1),s2.substring(1));
		}
		else {
			//int opt1= lcs(s1.substring(1),s2.substring(1)); //no need of this lines as opt2 and 3 takes care of this case.
			int opt2= lcs(s1,s2.substring(1));
			int opt3= lcs(s1.substring(1),s2);
			return Math.max(opt2,opt3);
		}	
	}
	public static int lcsM(String s1, String s2) {
		int storage[][]= new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<s1.length()+1;i++) {
			for(int j=0;j<s2.length()+1;j++) {
				storage[i][j]=-1;
			}
		}
		return lcsM(s1,s2,storage);
	}
	private static int lcsM(String s1, String s2, int[][] storage) {
		int m=s1.length();
		int n=s2.length();
		if(m==0 || n==0) {
			storage[m][n]=0;
			return storage[m][n];
	}
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			storage[m][n] =1+lcsM(s1.substring(1),s2.substring(1),storage);
			return storage[m][n];
		}
		else {
			int opt1= lcsM(s1,s2.substring(1),storage);
			int opt2= lcsM(s1.substring(1),s2,storage);
			storage[m][n]= Math.max(opt1, opt2);
			return storage[m][n];
		}
	}
	public static int lcsDP(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		int[][] storage= new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			storage[i][0]=0;
		}
		for(int j=0;j<n+1;j++) {
			storage[0][j]=0;
		}
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(s1.charAt(m-i)==s2.charAt(n-j)) {
					storage[i][j] =1+ storage[i-1][j-1];
			}
				else {
					storage[i][j]=Math.max(storage[i-1][j], storage[i][j-1]);
				}
		}
	
	}
		return storage[m][n];
	}
}

