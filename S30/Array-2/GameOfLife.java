class Solution {
	public void gameOfLife(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		int liveNeighbor = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				liveNeighbor = liveNeighbors(board, i, j);
                // change from 0 to 1 -> 2
				if (board[i][j] == 0 && liveNeighbor == 3) {
					board[i][j] = 2;
				}
                // change from 1 to 0 -> -1
				if (board[i][j] == 1 && (liveNeighbor < 2 || liveNeighbor > 3)) {
					board[i][j] = -1;
				}
			}
		}

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
	}

	private int liveNeighbors(int[][] board, int i, int j) {
		int row = board.length;
		int col = board[0].length;

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

		int liveNeighbor = 0;

		for (int[] direction : directions) {
			int r = i + direction[0];
			int c = j + direction[1];


			if ((r >= 0 && r < row) && (c >= 0 && c < col)) {
				if (board[r][c] == -1 || board[r][c] == 1) {
					liveNeighbor += 1;
				}
			}
		}

		return liveNeighbor;
	}
}
