package btl_PI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	private Image image;
	// Phuong thuc khoi tao cho nguon anh vao
    public ImagePanel(String image){
    	this(new ImageIcon(image).getImage());
    }
    // Phuong htuc khoi tao cho anh vao
	public ImagePanel(Image image) {
		this.image = image;
		// ta can lay kich thuoc anh
		
		Dimension size = new Dimension(this.image.getWidth(null), this.image.getHeight(null));
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
		this.setLayout(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(this.image, 0, 0, null);
	}
}