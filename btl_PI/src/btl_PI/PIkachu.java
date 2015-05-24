package btl_PI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.util.Random;
import java.awt.Color;

import javax.swing.JToggleButton;

public class PIkachu extends JFrame {

	public JButton tieptuc;
	public Matrix matrix = new Matrix(10, 17); // thuoc tinh la 1 mang la
												// [10][15]
	public int[][] A;
	public JButton btning[][] = new JButton[8][15];
	// tao ra 120 button tuong ung voi 120 pikachu

	public JPanel contentPane;
	public Timer time;

	/**
	 * Launch the application.
	 */
	public int flag = 0, bodem, map = 0;
	public Point point1, point2;
	public JButton b1, b2;
	public Border slBorder = new LineBorder(Color.RED, 3);
	public static int gamemap = 0;
	public JMenuItem mntmNewGame = new JMenuItem(" New Game");
	public JMenuItem huongdan = new JMenuItem(" Contruct");
	public int newgame = 0;
	public long score = 0;

	public JLabel scorelabel = new JLabel("Score = " + score);
	public JLabel timelabel = new JLabel("Time = " + bodem);
	public JLabel maplabel = new JLabel("Map = " + score);

	Random ran = new Random();

	public JPanel panel = new JPanel();

	/**
	 * Create the frame.
	 */
	public PIkachu() {

		setResizable(true);
		setTitle("PIkachu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 50, 1024, 680);// vi tri va thay doi kich thuoc
		contentPane = new ImagePanel(new ImageIcon("images\\bg.jpg").getImage());
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1024, 20);
		contentPane.add(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnhuongdan = new JMenu("Contruct");
		menuBar.add(mnhuongdan);
		huongdan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == huongdan) {
					JOptionPane.showMessageDialog(null,"Nhiệm vụ của bạn rất đơn giản ,chỉ cần tìm hai hình giống nhau "
											+ "và đường nối giữa chúng gấp khúc không quá 3 lần,click vào để loại bỏ chúng ");
				}
			}
		});

		mnhuongdan.add(huongdan);

		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == mntmNewGame) {

					score = 0;
					map = 0;
					scorelabel.setText("Score = " + score);
					maplabel.setText("Map = " + (map + 1));
					matrix.setMatrixmatrix();
					bodem = 500;
					A = matrix.getMatrix(); // gan ma tran vao A
					panel.removeAll();
					gamemap = 0;
					ActionListener aTime = new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							--bodem;
							timelabel.setText("Time = " + bodem);
							if (bodem == 0) {
								JOptionPane.showMessageDialog(null,"Het gio ban thua roi");
								time.stop();
								panel.removeAll();
							}

						}
					};
					time = new Timer(1000, aTime);
					time.start();
					panel.setBounds(100, 70, 750, 540);
					contentPane.add(panel);
					panel.setLayout(new GridLayout(8, 15, 0, 0));
					panel.setOpaque(false);

					scorelabel.setBounds(50, 32, 98, 14);
					contentPane.add(scorelabel);
					scorelabel.setForeground(Color.WHITE);

					timelabel.setBounds(200, 32, 98, 14);
					contentPane.add(timelabel);
					timelabel.setForeground(Color.GREEN);

					maplabel.setBounds(400, 32, 98, 14);
					contentPane.add(maplabel);
					maplabel.setForeground(Color.RED);

					for (int i = 1; i < 9; i++)       // dua anh len giao dien
						for (int j = 1; j < 16; j++) {
							btning[i - 1][j - 1] = new JButton();
							for (int k = 0; k < 36; k++) {
								String namehinh = "images//h";
								String b = null;
								b = String.valueOf(k); // chuyen dang so thanh Sttring														
								namehinh = namehinh.concat(b);
								namehinh = namehinh.concat(".jpg");
								if (A[i][j] == k)
									btning[i - 1][j - 1].setIcon(new ImageIcon(namehinh));
							}
							panel.add(btning[i - 1][j - 1]);
							btning[i - 1][j - 1].addActionListener(this);
						}
					panel.validate();
					// map 1
				}
				for (int i = 1; i < 9; i++)
					for (int j = 1; j < 16; j++) {
						if (e.getSource() == btning[i - 1][j - 1]) {

							if (flag == 0) {
								b1 = btning[i - 1][j - 1];
								b1.setBorder(slBorder);
								point1 = new Point(i, j);
								flag = 1;
								return;
							}
							if (flag == 1) {
								b2 = btning[i - 1][j - 1];
								b2.setBorder(slBorder);
								point2 = new Point(i, j);
								if (A[point1.x][point1.y] == A[point2.x][point2.y]) {
									if (b1 == b2) {
										flag = 0;
										b1.setBorder(null);
										b2.setBorder(null);
										b1 = null;
										b2 = null;
										return;

									}
									if (matrix.checkTwoPoint(point1, point2)) {
										flag = 0;
										A[point1.x][point1.y] = -1;
										A[point2.x][point2.y] = -1;
										b1.setBorder(null);
										b2.setBorder(null);
										b2.setVisible(false);
										b1.setVisible(false);
										b1 = null;
										b2 = null;
										score = score + 10;
										scorelabel.setText("Score = " + score);
										gamemap = gamemap + 1;
										if (gamemap == 10) {
											map = map + 1;
											if (map == 3) {
												time.stop();
												JOptionPane.showMessageDialog(null,"WINER NEW SCORE "+ score);
												panel.removeAll();
												score = 0;
												map = 0;
												gamemap = 0;
												return;
											}
											score = score + (10 * gamemap);
											scorelabel.setText("Score = "+ score);
											maplabel.setText("Map = "+ (map + 1));
											bodem = 500 - (map * 20);
											gamemap = 0;
											panel.removeAll();
											matrix.setMatrixmatrix();
											A = matrix.getMatrix();
											for (int i1 = 1; i1 < 9; i1++)
												for (int j1 = 1; j1 < 16; j1++)
												{
													btning[i1-1][j1-1] = new JButton();
													for (int k = 0; k < 36; k++) {
														String namehinh = "images//h";
														String b = null;
														b = String.valueOf(k); 
														namehinh = namehinh.concat(b);
														namehinh = namehinh.concat(".jpg");
														if (A[i1][j1] == k)
															btning[i1 - 1][j1 - 1].setIcon(new ImageIcon(namehinh));
													}
													panel.add(btning[i1 - 1][j1 - 1]);
													btning[i1 - 1][j1 - 1].addActionListener(this);
												}
											panel.validate();
										}
										return;
									} else {
										b1.setBorder(null);
										b2.setBorder(null);
										b1 = null;
										b2 = null;
										flag = 0;
										return;
									}
								} else {
									flag = 0;
									b1.setBorder(null);
									b2.setBorder(null);
									b1 = null;
									b2 = null;
									return;
								}
							}
						}
					}

			}
		});
		mnFile.add(mntmNewGame);
		// ket thuc ham action
		final JMenuItem mntmExitGame = new JMenuItem(" Exit");
		mntmExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		mnFile.add(mntmExitGame);

	}
}
