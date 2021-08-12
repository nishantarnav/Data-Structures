package graphs;
import java.util.*;
//this is used to make a class of all the edges
class edge implements Comparable<edge>{
	int source;
	int dest;
	int weight;

	public int compareTo(edge o) {
		return this.weight - o.weight;
	}

}
public class Kruskal {
	
	public static void kruskals(edge input[],int n) {
		 Arrays.sort(input);
		 edge output[] = new edge[n-1];
		 int parent[] =  new int[n];
		 for(int i=0;i<n;i++) {
			 parent[i]=i;
		 }
		 int count=0;
		 int i=0;
		 while(count!=n-1) {
			 edge curr= input[i];
			 int sourceParent= findParent(curr.source,parent);
			 int destParent = findParent(curr.dest,parent);
			 if(sourceParent!=destParent) {
				 output[count]=curr;
				 count++;
				 parent[sourceParent]= destParent;
			 }
			 i++;			 
		 }
		 
		 	for(int j=0;j<n-1;j++) {
		 		if(output[j].source <output[j].dest) {
		 		System.out.println(output[j].source + " " + output[j].dest+ " " + output[j].weight);
		 		
		 	}
		 	else {
		 		System.out.println(output[j].dest + " " + output[j].source + " " + output[j].weight);
		 	}
		 	}
	}
	public static int findParent(int v, int[] parent) {
		 if(parent[v]==v) {
			 return v;
		 }
		 return findParent(parent[v],parent);
	}
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n= sc.nextInt();
		int e=sc.nextInt();
		
		edge input[] = new edge[e];
		
		for(int i=0;i<e;i++) {
			input[i]= new edge();
			input[i].source= sc.nextInt();
			input[i].dest = sc.nextInt();
			input[i].weight= sc.nextInt();
		}
		
		kruskals(input,n);
		sc.close();
	}
	

}
