package graphs;
import java.util.*;
public class Graph {
	
	public static void printDFSHelper(int edges[][],int sv,boolean visited[]) {
		System.out.println(sv);
		visited[sv]= true;
		for(int i=0;i<edges.length;i++) {
			if((edges[sv][i]==1 && !visited[i])) {
				printDFSHelper(edges,i,visited);
			}
		}
	}
	public static void printDFS(int edges[][],int sv) {
		boolean visited[]= new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(!visited[i]) {
				printDFSHelper(edges,i,visited);
			}
		}
		
	}
	public static void printBFSHelper(int edges[][],int sv,boolean visited[]) {
		Queue <Integer> queue= new LinkedList<>();
		queue.add(sv);
		visited[sv]= true;
		while(!queue.isEmpty()) {
			int front = queue.poll();
			System.out.println(front);
			for(int i=0;i<edges.length;i++) {
				if(edges[front][i]==1 && !visited[i]) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
	}
	public static void printBFS(int edges[][],int sv) {
		boolean [] visited= new boolean[edges.length];
		for(int i=0;i<edges.length;i++) {
			if(!visited[i]) {
				printBFSHelper(edges,i,visited);
			}
		}
	}
    public static boolean hasHelperPath(int edges[][],boolean[] visited,int a ,int b) {
    	Queue <Integer> queue= new LinkedList<>();
		queue.add(a);
		visited[a]= true;
		while(!queue.isEmpty()) {
			int front = queue.poll();
			if(front==b) {
				return true;
			}
			for(int i=0;i<edges.length;i++) {
				if(edges[front][i]==1 && !visited[i]) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		return false;
	}
	public static boolean hasPath(int edges[][],int a,int b) {
		for(int i=a;i<edges.length;i++) {
			if(edges[a][i]==1 && i==b) {
				return true;
			}
		}
		boolean [] visited= new boolean[edges.length];
		return hasHelperPath(edges,visited,a,b);
		
}
	public static ArrayList<Integer> getPathDFSHelper(int edges[][],int a,int b,boolean visited[]) {
		if(a==b) {
			ArrayList<Integer> arr= new ArrayList<Integer>();
			arr.add(a);
			return arr;
		}
		visited[a]= true;
		for(int i=0;i<edges.length;i++) {
			if((edges[a][i]==1 && !visited[i])) {
				ArrayList<Integer> arr=getPathDFSHelper(edges,i,b,visited);
				if(arr != null) {
					arr.add(a);
					return arr;
			}
			
			}
		}
		return null;
		}
		

	
	public static ArrayList<Integer> getPathDFS(int edges[][],int a,int b) {
		
		boolean visited[]= new boolean[edges.length];
				return getPathDFSHelper(edges,a,b,visited);
	}
	 public static ArrayList<Integer> getHelperBFS (int[][] edges,int a,int b,boolean[] visited){
	        Queue<Integer> queue = new LinkedList<>();
	        HashMap<Integer,Integer> map= new HashMap<>();
	        if(a==b){
	            ArrayList<Integer> arr= new ArrayList<>();
	            arr.add(a);
	            return arr;
	        }
	       	queue.add(a);
	        visited[a]= true;
	        boolean pathFound= false;
	    	 while(!queue.isEmpty()){
	            int front = queue.poll();
	            for(int i=0;i<edges.length;i++) {
					if(edges[front][i]==1 && !visited[i]) {
						queue.add(i);
	                    map.put(i,front);
						visited[i]=true;
	                    if(i==b){
	                    	pathFound=true;
	                        break;
	                    }
					}
	            }
	            
	        }
	        if(pathFound) {
	        	ArrayList<Integer> path= new ArrayList<>();
	        	int currentVertex=b;
	        	while(currentVertex!=-1) {
	        	path.add(b);
	        	int parent=map.get(currentVertex);
	        	currentVertex=parent;
	        	}
	        	return path;
	        }
	        else {
	        	return null;
	        }
			
	 
	        
	    }
	 public static ArrayList<Integer> getBFSPath(int [][] edges,int a,int b){
	       
	        int n=edges.length;
	        boolean visited[]= new boolean [n];
	        return getHelperBFS(edges,a,b,visited);
	    }
	
	public static void main(String[] args) {

		
		Scanner sc= new Scanner(System.in);
		//no of vertices
			int n=sc.nextInt();
		// no of edges
			int m= sc.nextInt();
		int edges[][] = new int[n][n];
		for(int i=0;i<m;i++) {
			int fv=sc.nextInt();
			int sv=sc.nextInt();
			edges[fv][sv]=1;
			edges[sv][fv]=1;
		
	}
		int a= sc.nextInt();
		int b=sc.nextInt();
//		System.out.println("DFS");
//		printDFS(edges,0);
//		System.out.println("BFS");
//		printBFS(edges, 0);
		//System.out.println(hasPath(edges,a,b ));
		ArrayList<Integer> arr= getBFSPath(edges,a,b);
		if(arr!=null) {
		for(int i:arr) {
			System.out.print(i+" ");
		
		} 
		}
		sc.close();
		
	}
}
