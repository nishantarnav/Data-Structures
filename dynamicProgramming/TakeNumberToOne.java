package dynamicProgramming;

public class TakeNumberToOne {

	public static int countSteps(int n) {
		if(n==1) {
			return 0;
		}
		int opt1= countSteps(n-1);
		int min=opt1;
		if(n%2==0) {
			int opt2= countSteps(n/2);
			if(min>opt2) {
				min=opt2;
			}
		}
		if(n%3==0) {
			int opt3= countSteps(n/3);
			if(min>opt3) {
				min=opt3;
			}
		}
		return 1+min;
	}
	public static void main(String[] args) {
		
System.out.println(countStepsM(1000));
System.out.println(countStepDP(1000));
System.out.println(countSteps(1000));
	}
	public static int countStepsM(int n) {
		int[] storage= new int[n+1];
	
		return countStepsM(n,storage);
	}
	private static int countStepsM(int n, int[] storage) {
		if(n==1) {
			storage[n]=0;
			return storage[n];
		}
		if(storage[n]!=0) {
			return storage[n];
		}
		int opt1= countStepsM(n-1,storage);
		int min=opt1;
		if(n%2==0) {
			int opt2= countStepsM(n/2,storage);
			if(min>opt2) {
				min=opt2;
			}
		}
		if(n%3==0) {
			int opt3= countStepsM(n/3,storage);
			if(min>opt3) {
				min=opt3;
			}
		}
		storage[n]=min+1;
		return storage[n];
		
	}
	public static int countStepDP(int n) {
		int storage[]= new int[n+1];
		storage[1]=0;
		for(int i=2;i<=n;i++) {
			int min=storage[i-1];
			if(i%2==0) {
				if(min>storage[i/2]) {
					min=storage[i/2];
				}
			}
			if(i%3==0) {
				if(min>storage[i/3]) {
					min=storage[i/3];
					
				}
			}
			storage[i]=1+min;
			
		}
		return storage[n];
	}
	
}
