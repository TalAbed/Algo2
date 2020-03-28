package bottlesProblem;

public class NeighborMatrix {
	
	private static int rowIndex (int i, int j, int n) {
		return (n+1)*i + j;
	}
	
	public static boolean[][] bulidMat (int m, int n){
		int x = (n+1)*(m+1);
		boolean [][] mat = new boolean [x][x];
		for (int i=0;i<=m;i++) {
			for (int j=0;j<=n;j++) {
				int index = rowIndex(i,j,n);
				mat[index][rowIndex(0,j,n)] = true;
				mat[index][rowIndex(i,0,n)] = true;
				mat[index][rowIndex(m,j,n)] = true;
				mat[index][rowIndex(i,n,n)] = true;
				int y = rowIndex(i+j-(Math.min(i+j, n)), Math.min(i+j, n), n);
				mat[index][y] = true;
				y = rowIndex(Math.min(i+j, m), i+j-Math.min(i+j, m), n);
				mat[index][y] = true;
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		boolean mat[][] = bulidMat(1,2);
		for (int i=0;i<mat.length;i++) {
			for (int j=0;j<mat[0].length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
