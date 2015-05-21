package btl_PI;

import java.util.Random;

/*
 * Class Matrix tao 1 matran vs kich thuoc m x n  cac phuong thuc tao gia tri cac phan tu cua ma tran 
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

	/*
	 * Phuong thuc khoi tao ma tran random
	 */
	public void setMatrixmatrix() {
		Random rand = new Random();
		for (int i = 1; i < this.row - 1; i++)
			for (int j = 1; j < this.col - 1; j++) {
				this.matrix[i][j] = rand.nextInt(36);
			}
		// Tao cac cap giong nhau
		for (int i = 0; i < 36; i++) {
			if ((demPT(i) % 2) != 0)
				change(i);
		}
	}

	// Thay doi phan tu de thanh cac cap
	private void change(int m) {
		for (int i = 1; i < this.row - 1; i++)
			for (int j = 1; j < this.col - 1;) {
				if (this.matrix[i][j] == m)
					this.matrix[i][j]++;
				return;
						
			}

	}

	/*
	 * Dem so phan tu giong nhau
	 */
	
	private int demPT(int m) {
		int d = 0;
		for (int i = 1; i < this.row - 1; i++)
			for (int j = 1; j < this.col - 1; j++) {
				if (this.matrix[i][j] == m)
					d++;
			}

		return d;
	}
	


	/* Giai thuat DK thoa man tro choi */
	/*************************************************************************/
	/* TH_1 : Truong hop cung nam tren 1 hang hoac 1 cot */
	// Kiem tra voi hang x , cot y1,y2
	private boolean checkLineX(int y1, int y2, int x) {
		// Tim cot max va min
		int maxColum = Math.max(y1, y2);
		int minColum = Math.min(y1, y2);
		if ((minColum + 1) == maxColum)
			return true;
		// Run
		for (int i = minColum + 1; i < maxColum; i++) {
			if (this.matrix[x][i] != -1)
				return false; // khong thuc hien duoc
		}
		return true;
	}

	// Kiem tra voi cot y, hang x1,x2
	private boolean checkLineY(int x1, int x2, int y) {
		// Tim cot max va min
		int maxRow = Math.max(x1, x2);
		int minRow = Math.min(x1, x2);
		if ((minRow + 1) == maxRow)
			return true;
		// Run
		for (int i = minRow + 1; i < maxRow; i++) {
			if (this.matrix[i][y] != -1)
				return false; // khong thuc hien duoc
		}
		return true;
	}

	
}
