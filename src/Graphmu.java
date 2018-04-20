/** Graph: Adjacency matrixArray */
class Graphmu implements Graph {
	private int[] matrixArray; // The edge matrixArray
	private int numEdge; // Number of edges//Number of
	public int[] Mark; // The mark array

	public Graphmu() {
	} // Constructors
	public Graphmu(int n) {
		Init(n);
	}

	public void Init(int n) {
		Mark = new int[n];
		matrixArray = new int[(n * (n + 1)) / 2];
		numEdge = 0;
	}
	public int n() {
		return Mark.length;
	} // # of vertices
	public int e() {
		return numEdge;
	} // # of edges

	/** @return v's first neighbor */
	public int first(int v) {
		// loop through columns on v's row
		for (int i = 0; i < Mark.length; i++) {
			int col = i;
			int row = v;
			// only search upper triangle
			if (i < v) {
				row = i;
				col = v;
			}
			// return location of first neighbor
			if (matrixArray[(n() * row) + col - ((row * (row + 1)) / 2)] != 0) {
				return i;
			}
		}
		// no neighbors return number of vertices
		return Mark.length; // No edge for this vertex
	}

	/** @return v's next neighbor after w */
	public int next(int v, int w) {
		// loop through columns on v's row starting after w
		for (int i = w + 1; i < Mark.length; i++) {
			int col = i;
			int row = v;
			// only search upper triangle
			if (i < v) {
				row = i;
				col = v;
			}
			// return location of next neighbor after w
			if (matrixArray[(n() * row) + col - ((row * (row + 1)) / 2)] != 0) {
				return i;
			}
		}
		return Mark.length; // No next edge;
	}

	/** Set the weight for an edge */
	public void setEdge(int col, int row, int wt) {
		// only use upper triangular to store undirected graph
		if (col < row) {
			int temp = row;
			row = col;
			col = temp;
		}
		// store weight of edge in the matrix array
		int locationInMatrixArray = (n() * row) + col - ((row * (row + 1)) / 2);
		if (matrixArray[locationInMatrixArray] == 0)
			numEdge++;
		matrixArray[locationInMatrixArray] = wt;

	}

	/** Delete an edge */
	public void delEdge(int i, int j) { // Delete edge (i, j)
		int col = i;
		int row = j;
		if (col < row) {
			int temp = row;
			row = col;
			col = temp;
		}
		if (matrixArray[(n() * row) + col - ((row * (row + 1)) / 2)] != 0)
			numEdge--;
		matrixArray[(n() * row) + col - ((row * (row + 1)) / 2)] = 0;
	}

	/** Determine if an edge is in the graph */
	public boolean isEdge(int i, int j) {
		int col = i;
		int row = j;
		if (col < row) {
			int temp = row;
			row = col;
			col = temp;
		}
		return matrixArray[(n() * row) + col - ((row * (row + 1)) / 2)] != 0;
	}

	/** @return an edge's weight */
	public int weight(int r, int c) {
		int col = c;
		int row = r;
		if (col < row) {
			int temp = row;
			row = col;
			col = temp;
		}
		return matrixArray[(n() * row) + col - ((row * (row + 1)) / 2)];
	}

	public void printMatrix() {
		System.out.print("   ");
		for (int i = 0; i < Mark.length; i++) {
			System.out.print("" + i + "  ");
		}
		System.out.println();
		for (int i = 0; i < Mark.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < Mark.length; j++) {
				int col = i;
				int row = j;
				// only search upper triangle
				if (i < j) {
					row = i;
					col = j;
				}
				System.out.print("[" + matrixArray[(n() * row) + col - ((row * (row + 1)) / 2)] + "]");
			}
			System.out.println();
		}
	}

	/** Set/Get the mark value for a vertex */
	public void setMark(int v, int val) {
		Mark[v] = val;
	}
	public int getMark(int v) {
		return Mark[v];
	}
}
