
public class Matrix {

	public int x_shape, y_shape;
	public double[][] content;

	public Matrix(int x_shape, int y_shape, double[][] content) {
		this.x_shape = x_shape;
		this.y_shape = y_shape;
		this.content = content;
	}

	public Matrix(int x_shape, int y_shape) {
		this.x_shape = x_shape;
		this.y_shape = y_shape;
		this.content = new double[x_shape][y_shape];
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				content[i][j] = 0;
			}
		}
	}

	public Matrix(int x_shape, int y_shape, String s) {
		if (s.split(" ").length == x_shape * y_shape) {
			this.x_shape = x_shape;
			this.y_shape = y_shape;
			content = new double[x_shape][y_shape];
			int[] con = new int[x_shape * y_shape];
			for (int i = 0; i < s.split(" ").length; i++) {
				con[i] = Integer.parseInt(s.split(" ")[i]);
			}
			for (int x = 0; x < x_shape; x++) {
				for (int y = 0; y < y_shape; y++) {
					this.content[x][y] = con[x + x_shape * y];
				}
			}
		} else
			System.out.println("mistake");
	}

	public Matrix matmul(Matrix mat2) {
		Matrix result;
		if (this.x_shape == mat2.y_shape) {
			result = new Matrix(this.x_shape, mat2.y_shape);
			for (int x = 0; x < result.x_shape; x++) {
				for (int y = 0; y < result.y_shape; y++) {
					for (int i = 0; i < result.x_shape; i++) {
						result.content[x][y] += this.content[i][y] * mat2.content[x][i];
					}
				}
			}
		} else {
			System.out.println("Mistake	");
			return null;
		}

		return result;
	}

	public void printMatrix() {

		for (int j = 0; j < this.y_shape; j++) {
			for (int i = 0; i < this.x_shape; i++) {
				System.out.print(this.content[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
