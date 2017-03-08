package YouCanPlayHere;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Window extends JFrame {
	Panel p = new Panel();
	JLabel lab, lab2;
	JButton but, but2;
	BufferedImage img;

	public Window() {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addMouseListener(p);
		this.add(p, null);
		img = null;
		try{
		img = ImageIO.read(new File("C:\\Test\\bit.png"));
		} catch (IOException e){
		}
		System.out.println(img.getRGB(0, 0) >> 8);
	}

	public static void main(String[] args) {
		new Window();
	}

}
