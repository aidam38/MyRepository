import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, MouseListener {
	Timer tim;
	int x1 = 0, y1 = 0, x2 = 500, y2 = 500;

	public Panel() {
		tim = new Timer(10, this);
		tim.start();
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillRect(0, 0, 500, 500);
		g.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(0, 0, 500, 500);
		g.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("ss");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x1 = e.getX();
		int y1 = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x2 = e.getX();
		int y2 = e.getY();
	}
}
