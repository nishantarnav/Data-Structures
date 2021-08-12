package backtracking;

public class Nqueens {

	public static void main(String[] args) {
		int n=4;
		int[][] board= new int[n][n];
		placeNQueens(n-1,board);

	}

	public static void placeNQueens(int n,int[][] board) {
		if(n==0) {
			
				for(int j=0;j<n;j++) {
					System.out.print(board[n][j]+" ");
				}
				System.out.println();
		}
			
			
		for(int j=0;j<board.length;j++) {
			if(!isAvailable(board.length,n,j,board) && board[n][j]!=1) {
				board[n][j]=1;
				placeNQueens(n - 1,board);
				board[n][j]=0;
			}
		}
		

}
	
	public static boolean isAvailable(int n,int x,int y,int[][] board) {
		for(int k=0;k<n;k++) {
			if(board[k][x]==1 || board[y][k]==1) {
				return true;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i+j==x+y || i-j ==x-y) {
					if(board[i][j]==1) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
