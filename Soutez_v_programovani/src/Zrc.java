import javax.swing.JFrame;

public class Zrc {
	JFrame f;

	public Zrc() {
		f = new JFrame();
		f.setSize(800, 600);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel p = new Panel();
		f.addMouseListener(p);
		f.add(p);
	}

	public static void main(String[] args) {
		new Zrc();
	}

}
