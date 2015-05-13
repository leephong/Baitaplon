package btl_PI;

import java.awt.Point;
import java.util.Random;

public class Pikachu {
	private int[][] pikachu;
	int row, col;
	private int score = 0;

	/*
	 * Phuong thuc khoi tao tro choi Ma tran anh : m x n score luc bat dau = 0;
	 * Thoi gian dem nguoc count = 120;
	 */
	public Pikachu(int n, int m) {
		this.row = n;
		this.col = m;
		this.pikachu = new int[row][col];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				this.pikachu[i][j] = -1;
		}
		this.score = 0;
	}
}