package btl_PI;

import java.awt.Point;
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

	/*
	 * TH_2 : Xet duyet cac duong di theo chieu ngang, doc trong pham vi chu
	 * nhat
	 */
	
	/*
	 *    |                 _________
	 *    |________                  |
	 *             |                 |__________
	 *             |                 
	 */
	// Xet duyet duong di theo chieu ngang trong pham vi chu nhat
	private boolean checkRectX(Point p1, Point p2) {
		Point pMinY = p1;
		Point pMaxY = p2;
		if (p1.y > p2.y) {
			pMinY = p2;
			pMaxY = p1;
		}
		// Tim cot va x
		for (int i = pMinY.y; i <= pMaxY.y; i++) {
			if (i > pMinY.y && this.matrix[pMinY.x][i] != -1) {
				return false;
			}
			if ((this.matrix[pMaxY.x][i] == -1 || i == pMaxY.y)
					&& checkLineY(pMinY.x, pMaxY.x, i)
					&& checkLineX(i, pMaxY.y, pMaxY.x)) {
				return true;
			}
		}
		return false;
	}
	// Xet duyet duonng di theo chieu doc trong pham vi chu nhat
		private boolean checkRectY(Point p1, Point p2) {
			Point pMinX = p1;
			Point pMaxX = p2;
			if (p1.x > p2.x) {
				pMinX = p2;
				pMaxX = p1;
			}
			// tim hang va cot y
			for (int i = pMinX.x; i <= pMaxX.x; i++) {
				if (i > pMinX.x && this.matrix[i][pMinX.y] != -1) {
					return false;
				}
				if ((this.matrix[i][pMaxX.y] == -1 || i == pMaxX.x)
						&& checkLineX(pMinX.y, pMaxX.y, i)
						&& checkLineY(i, pMaxX.x, pMaxX.y)) {
					return true;
				}
			}
			return false;
		}

		/*
		 * TH_3 : Xet mo rong theo chieu ngang, chieu doc
		 *     ____________               |
		 *    |                           |     |
		 *    |_____                      |_____|
		 */

		// Xet mo rong theo chieu ngang type = 1 ( di ben phai) type = -1 (di ben
		// trai)
		private boolean checkMoreLineX(Point p1, Point p2, int type) {
			Point pMinY = p1, pMaxY = p2;
			if (p1.y > p2.y) {
				pMinY = p2;
				pMaxY = p1;
			}
			// Tim hang va y
			int y = pMaxY.y + type;
			int _row = pMinY.x;
			int colFinish = pMaxY.y;
			if (type == -1) {
				colFinish = pMinY.y;
				y = pMinY.y + type;
				_row = pMaxY.x;
			}

			// Tim cot ket thuc cua hang x

			// check more
			if ((this.matrix[_row][colFinish] == -1 || pMinY.y == pMaxY.y)
					&& checkLineX(pMinY.y, pMaxY.y, _row)) {
				while (this.matrix[pMinY.x][y] == -1
						&& this.matrix[pMaxY.x][y] == -1) {
					if (checkLineY(pMinY.x, pMaxY.x, y)) {
						return true;
					}
					y += type;
				}
			}
			return false;
		}
		// Xet mo rong theo chieu doc type = 1 ( di len tren) type = -1 (di xuong
				// duoi)
		private boolean checkMoreLineY(Point p1, Point p2, int type) {
			Point pMinX = p1, pMaxX = p2;
			if (p1.x > p2.x) {
				pMinX = p2;
				pMaxX = p1;
			}
			int x = pMaxX.x + type;
			int _col = pMinX.y;
			int rowFinish = pMaxX.x;
			if (type == -1) {
				rowFinish = pMinX.x;
				x = pMinX.x + type;
				_col = pMaxX.y;
			}
			if ((this.matrix[rowFinish][_col] == -1 || pMinX.x == pMaxX.x)
					&& checkLineY(pMinX.x, pMaxX.x, _col)) {
				while (this.matrix[x][pMinX.y] == -1
						&& this.matrix[x][pMaxX.y] == -1) {
					if (checkLineX(pMinX.y, pMaxX.y, x)) {
						return true;
					}
					x += type;
				}
			}
			return false;
		}
		/*
		 * Ham xu ly
		 */
		public boolean checkTwoPoint(Point p1, Point p2) {
			// Kiem tra voi hang x , cot y1,y2
			if (p1.x == p2.x) {
				if (this.checkLineX(p1.y, p2.y, p1.x))
					return true;
			}
			// Kiem tra voi cot y , hang x1,hang x2
			if (p1.y == p2.y) {
				if (this.checkLineY(p1.x, p2.x, p1.y))
					return true;
			}
			// Xet duong di theo chieu ngang
			if (this.checkRectX(p1, p2))
				return true;
			// Xet duong fi theo chieu doc
			if (this.checkRectY(p1, p2))
				return true;
			// xet du mo rong theo chieu ngang ben phai
			if (this.checkMoreLineX(p1, p2, 1))
				return true;
			// xet su mo rong theo chieu ngang ben trai
			if (this.checkMoreLineX(p1, p2, -1))
				return true;
			// Xet su mo rong theo chieu doc di len tren
			if (this.checkMoreLineY(p1, p2, 1))
				return true;
			// Xet su mo rong theo chieu doc di xuong duoi
			if (this.checkMoreLineY(p1, p2, -1))
				return true;
			return false; // tra ve false neu khong tìm thay duong di
		}
}
