import java.util.Random;

public class Main {
	static Random rnd = new Random();

	public static void main(String[] args) {
		Matrix x = new Matrix(4, 1, "0 1 0 1");
		Matrix w = new Matrix(4, 4);
		for (int i = 0; i < w.x_shape; i++) {
			for (int j = 0; j < w.y_shape; j++) {
				w.content[i][j] = Math.pow(-1, rnd.nextInt()) * rnd.nextDouble();
			}
		}
		Matrix y = x.matmul(w);
		w.printMatrix();
		y.printMatrix();
	}

}
