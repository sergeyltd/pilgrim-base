package org.pilgrim.leetcode.y2022;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/***
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the nine 3 x 3 sub-boxes
 * of the grid must contain the digits 1-9 without repetition. Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. Only the filled cells need to be validated according to the
 * mentioned rules.
 * 
 * 
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * Example 1:
 * 
 * 
 * Input: board = [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."] ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"] ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"] ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]] Output: true Example 2:
 * 
 * Input: board = [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."] ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"] ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"] ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]] Output: false Explanation: Same as
 * Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * 
 * 
 * Constraints:
 * 
 * board.length == 9 board[i].length == 9 board[i][j] is a digit 1-9 or '.'.
 * 
 * @author sergiy
 *
 */

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		ValidSudoku validator = new ValidSudoku();

		long start = System.currentTimeMillis();
		System.out.println(validator.isValidSudoku(board));
		System.out.println((System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		System.out.println(validator.isValidSudoku2(board));
		System.out.println((System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			validator.isValidSudoku(board);
		}
		System.out.println("My isValidSudoku = " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			validator.isValidSudoku2(board);
		}
		System.out.println("Optimal by memory isValidSudoku2 = " + (System.currentTimeMillis() - start));

	}

	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			// throw exception or return false
			return false;
		}

		// Validate by columns
		if (!this.isValidByColumn(board)) {
			return false;
		}

		// Validate by rows
		if (!this.isValidByRow(board)) {
			return false;
		}

		// Validate by sub boxes
		if (!this.isValidBySubBox(board)) {
			return false;
		}

		return true;
	}

	private boolean isValidByColumn(char[][] board) {
		// Set<Integer> values = null;
		for (int i = 0; i < 9; i++) {
			int[] val = new int[10];
			// values = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char ch = board[i][j];
				int n = (int) (ch - '0');
				if (n > 0 && n < 10) {
					if (val[n] == 1) {
						return false;
					}

					val[n] = 1;
				}
			}
		}

		return true;
	}

	private boolean isValidByRow(char[][] board) {
		// Set<Integer> values = null;
		for (int i = 0; i < 9; i++) {
			int[] val = new int[10];
			// values = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char ch = board[j][i];
				int n = (int) (ch - '0');
				if (n > 0 && n < 10) {
					if (val[n] == 1) {
						return false;
					}

					val[n] = 1;
				}
			}
		}

		return true;
	}

	private boolean isValidBySubBox(char[][] board) {
//        Set<Integer> values = null;
		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
//                values = new HashSet<>();
				int[] val = new int[10];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int in = c * 3 + i;
						int jn = r * 3 + j;
						char ch = board[in][jn];
						int n = (int) (ch - '0');
						if (n > 0 && n < 10) {
							if (val[n] == 1) {
								return false;
							}

							val[n] = 1;
						}
					}
				}
			}
		}

		return true;
	}

	// The most optimal solution
	public boolean isValidSudoku2(char[][] board) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					if (board[i][j] == '.') {
						continue;
					}

					if (j != k && board[i][j] == board[i][k]) {
						return false;
					}

					if (i != k && board[i][j] == board[k][j]) {
						return false;
					}

					int r = i / 3 * 3 + k / 3;
					int c = j / 3 * 3 + k % 3;
					if (r != i && c != j && board[i][j] == board[r][c]) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
