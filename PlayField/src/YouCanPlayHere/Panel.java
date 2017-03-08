package YouCanPlayHere;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements MouseListener, ActionListener {
	Random rnd;
	Color c;
	Timer tim;
	JLabel lab, lab2;
	JButton but, but2;

	public Panel() {
		tim = new Timer(1, this);
		tim.start();
		rnd = new Random();
		c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
		this.setLayout(new GridLayout(2, 2, 10, 10));
		lab = new JLabel("ahoj");
		lab.setText("ahojdaaaqa");
		this.add(lab);
		lab2 = new JLabel("ahoj");
		lab2.setText("ahojdaaaqa");
		this.add(lab2);
		but = new JButton("hi");
		this.add(but);
		but2 = new JButton("hii");
		this.add(but2);

	}

	public void paint(Graphics g) {
		g.setColor(c);
		g.fillRect(0, 0, 400, 300);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() < 400 && e.getY() < 300)
			c = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
