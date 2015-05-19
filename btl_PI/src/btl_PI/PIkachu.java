package btl_PI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
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



public class PIkachu extends JFrame {
	
	
	public JButton tieptuc;
	
	public int A[] = new int [72];
	public JButton btning[] = new JButton[72];
	
	public JPanel contentPane;
	public Timer time;

	/**
	 * Launch the application.
	 */
	public int flag = 0, bodem, map = 0;
	public int click1, click2;
	public JButton b1, b2;
	public Border slBorder = new LineBorder(Color.RED, 3);
	public static int gamemap = 0;
	public JMenuItem mntmNewGame = new JMenuItem(" New Game");	
	public JMenuItem huongdan = new JMenuItem(" Contruct");
	public int newgame = 0;
	public long score = 0;
	
	public JLabel scorelabel = new JLabel("Score = "+score);
	public JLabel timelabel = new JLabel("Time = "+bodem);
	public JLabel maplabel = new JLabel("Map = "+score);
	
	Random ran = new Random();
	
	
	
	public JPanel panel = new JPanel();


	/**
	 * Create the frame.
	 */
	public PIkachu() 
	{
		
		setResizable(true);
		setTitle("PIkachu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 80, 1024, 640);//vi tri va thay doi kich thuoc
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
			public void actionPerformed(ActionEvent e) 
			{
					
				if(e.getSource()==huongdan)
				{ 
					JOptionPane.showMessageDialog(null,"Nhiệm vụ của bạn rất đơn giản ,chỉ cần tìm hai hình giống nhau "
							+ "và đường nối giữa chúng gấp khúc không quá 2 lần,clich vào để loại bỏ chúng ");
				}
			}
		});
		mnhuongdan.add(huongdan);

		mntmNewGame.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e) 
		{
				
			if(e.getSource()==mntmNewGame)
			{ 

				score = 0;
				map = 0;
				scorelabel.setText("Score = "+score);
				maplabel.setText("Map = "+(map+1));
				bodem = 500;
				//checkRandom();
				panel.removeAll();
				gamemap = 0;
				ActionListener aTime = new ActionListener() {
				      public void actionPerformed(ActionEvent e) {
				    	  --bodem;
				    	   timelabel.setText("Time = "+bodem);
				    	   if(bodem == 0)
				    	   {
				    		   JOptionPane.showMessageDialog(null, "Het gio ban thua roi");
				    		   time.stop();
				    		   panel.removeAll();
				    	   }
				    	   
				      }
				    };
				time = new Timer(1000, aTime);
				time.start();
				
				panel.setBounds(100, 50, 795,520);
				contentPane.add(panel);
				panel.setLayout(new GridLayout(8, 15, 0, 0));
				panel.setOpaque(false);
				
				scorelabel.setBounds(10, 32, 98, 14);
				contentPane.add(scorelabel);
				scorelabel.setForeground(Color.WHITE);
				
				timelabel.setBounds(200, 32, 98, 14);
				contentPane.add(timelabel);
				timelabel.setForeground(Color.GREEN);
				
				maplabel.setBounds(400, 32, 98, 14);
				contentPane.add(maplabel);
				maplabel.setForeground(Color.RED);
				
				for(int i = 0; i <120; i++) 
				{				
					btning[i]= new JButton(); 
					for(int j = 0;j<36 ;j++)
					{
						String namehinh = "images//h";
						String b = null;
						b = b.valueOf(j);
						namehinh = namehinh.concat(b);
						namehinh = namehinh.concat(".jpg");
						if(A[i] ==j)btning[i].setIcon(new  ImageIcon(namehinh));
					}

					
					panel.add(btning[i]);
					btning[i].addActionListener(this);

				}panel.validate();
				
			}//dung ham for
			

		}

	});
		 mnFile.add(mntmNewGame);
		//ket thuc ham action
		final JMenuItem mntmExitGame = new JMenuItem(" Exit");
		mntmExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);					
			}
		});
		
		mnFile.add(mntmExitGame);
		
	}
	
	public void checkRandom()
	{
		//check random
		
		for(int i = 0; i < 120;i++)
		{
			int r = ran.nextInt(35);
			A[i] = r;
			
		}
		
		for(int i = 0; i < 36; i++)
		{
				
			if(DemPT(i) % 2 != 0)
			{
				Chuyen(i);
					
					
			}	
		}
	}
	
	
	
	

	public int DemPT(int m)
	{
		int d=0;
		for(int i=0;i<120;i++)
		{
			if(m == A[i])
			{
				d++;
			}
		}
		return d;	
	}
	
	
	
	public void Chuyen(int m)
	{
		for(int i = 0; i < 120; i++)
		{
			if(A[i] == m)
			{
				A[i]++;
				return;
			}
		}
		
		
	}
	}
