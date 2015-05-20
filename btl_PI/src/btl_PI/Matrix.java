package btl_PI;
/*
 * Class Matrix tao 1 matran vs kich thuoc m x n � cac phuong thuc tao gia tri cac phan tu cua ma tran 
 * va cac phuong thuc thuat toan an 2 diem
 */
public class Matrix {
	
	/*
	 * ham khoi tao ma tran
	 */
	private int[][] matrix;
	int row, col;
	public Matrix(int n, int m) {
		this.row = n;
		this.col = m;
		this.matrix = new int[row][col];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				this.matrix[i][j] = -1;
		}
	}
	public int[][] getMatrix() {
		return this.matrix;
	}

}
