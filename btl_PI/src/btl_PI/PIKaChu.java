package btl_PI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

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

public class PIKaChu extends JFrame {
	
	public JButton tieptuc;
	public int A[] = new int [72];
	public JButton btning[] = new JButton[72];
	
	public JPanel contentPane ;
	public Timer time;
	
	/* tao cac ứng dụng
	 * */
	 
	public int flag =0;
	public int bodem;
	public int map=0;
	public int lick1 ,click2;
	public JButton b1,b2;
	public Border slBorder = new LineBorder(Color.red , 3);
	public static int gamemap =0;
	public JMenuItem mntmNewGame = new JMenuItem("new Game");
	public int newgame =0;
	public long score =0;
	
	public JLabel scorelabel = new JLabel("Score = "+score);
	public JLabel timelabel = new JLabel("Time = "+bodem);
	public JLabel maplabel = new JLabel("Map"+score);
	
	Random ran = new Random();
	
	public JPanel panel = new JPanel();
	
	/*  main
	 * */
	 
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try
				{
					PIKaChu frame = new PIKaChu();
					frame.setVisible(true);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	public PIKaChu()
	{
		setResizable(true);
		setTitle("PiKaChu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
