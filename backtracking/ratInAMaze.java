package backtracking;

public class ratInAMaze {

	public static void main(String[] args) {
		int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};
		ratInAMaze(maze);
//		boolean pathPossible= ratInAMaze(maze);
//		System.out.println(pathPossible);
	}

	public static void ratInAMaze(int[][] maze) {
		int n=maze.length;
		int[][] path= new int[n][n];
		printAllPaths(maze, 0, 0, path);
//		return solveMaze(maze,0,0,path);
		
	}
	public static void printAllPaths(int[][] maze,int i,int j,int path[][]) {
		//check if i,j is valid or not
				int n=maze.length;
				if(i<0 || i>=n ||  j<0 ||j>=n || maze[i][j]==0 || path[i][j]==1) {
					return ;	
				}
				//include the cell in current path
				path[i][j]=1;
				
				////destination cell
				if(i==n-1 && j==n-1) {
					for(int r=0;r<n;r++) {
						for(int c=0;c<n;c++) {
							System.out.print(path[r][c]+ " ");
						}
						System.out.println();
					}
					System.err.println();
					//resetting then final path
					path[i][j]=0;
				}
				//explore in all directions
				//left
				printAllPaths(maze,i-1,j,path);
				//top
				printAllPaths(maze,i,j+1,path);
				//right
				printAllPaths(maze,i+1,j,path);
				//down
				printAllPaths(maze,i,j-1,path);
				
				//resetting the path
				path[i][j]=0;
	}
	public static boolean solveMaze(int[][] maze,int i,int j,int path[][]) {
		//check if i,j is valid or not
		int n=maze.length;
		if(i<0 || i>=n ||  j<0 ||j>n || maze[i][j]==0 || path[i][j]==1) {
			return false;	
		}
		//include the cell in current path
		path[i][j]=1;
		
		////destination cell
		if(i==n-1 && j==n-1) {
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					System.out.print(path[r][c]+ " ");
				}
				System.out.println();
			}
			return true;
		}
		//explore in all directions
		if(solveMaze(maze,i-1,j,path)) {
			return true;
		}
		if(solveMaze(maze,i,j+1,path)) {
			return true;
		}
		if(solveMaze(maze,i+1,j,path)) {
			return true;
		}
		if(solveMaze(maze,i,j-1,path)) {
			return true;
		}
		return false;
	}
}

