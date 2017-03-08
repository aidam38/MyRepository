import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main implements MouseWheelListener, KeyListener {
	long startTime, time;
	JLabel lab;
	long[] a = new long[256];

	public Main() {
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setSize(200, 100);
		f.addMouseWheelListener(this);
		f.addKeyListener(this);
		f.setLocationRelativeTo(null);
		lab = new JLabel(String.valueOf(time));
		f.add(lab, JLabel.CENTER);
	}

	public static void main(String[] args) {
		new Main();
	}

	int i = 0, n = 0;
	long sum;
	boolean start = true;

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getUnitsToScroll() == 3 || e.getUnitsToScroll() == -3) {
			if (start) {
				startTime = System.currentTimeMillis();
				start = false;
			} else {
				long nowTime = System.currentTimeMillis();
				time = nowTime - startTime;
				startTime = nowTime;
				lab.setText(String.valueOf(time));
				a[i] = time;
				i++;
				while (a[n] != 0) {
					sum += a[n];
					n++;
				}
				System.out.println(sum / (double) n);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			sum = 0;
			n = 0;
			i=0;
			start = true;
			for (int i = 0; i < a.length; i++) {
				a[i] = 0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
