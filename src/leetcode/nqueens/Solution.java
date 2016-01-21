package leetcode.nqueens;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.totalNQueens(8));
	}

	public int totalNQueens(int n) {
		
		/** index means x-axis, value means y-axis*/
		int[] chessBoard = new int[n];
		Arrays.fill(chessBoard, -1);
		
		return searchBoard(chessBoard, 0);	

    }

	private int searchBoard(int[] chessBoard, int target) {
		int cou = 0;
		if(target >= chessBoard.length) {
			return 1;
		}
		for(int i = 0; i < chessBoard.length; i++) {
			chessBoard[target] = i;
			/** check there is any conflict or not */
			for(int j = 0; j < target; j++) {
				if(chessBoard[j] == i ||
						(i-target) == (chessBoard[j]-j) ||
						(i+target) == (chessBoard[j]+j) ) {
					chessBoard[target] = -1;
					break;
				}
			}
			if(chessBoard[target] == -1) {
				continue;
			}
			else {
				cou += searchBoard(chessBoard, target+1);
				chessBoard[target] = -1;
			}
		}
		return cou;
	}
}
