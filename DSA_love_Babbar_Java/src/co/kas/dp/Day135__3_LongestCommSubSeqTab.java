package co.kas.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day135__3_LongestCommSubSeqTab {
	static int solveRecTab(String text1, String text2, int[][] dp) {
		for (int i = text1.length() - 1; i >= 0; i--) {
			for (int j = text2.length() - 1; j >= 0; j--) {
				int ans = 0;
				if (text1.charAt(i) == text2.charAt(j))
					ans = 1 + dp[i + 1][j + 1];
				else
					ans = 0 + Math.max(dp[i + 1][j], dp[i][j + 1]);

				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String text1 = "abcba", text2 = "abc"; // ans =3
		// String text1 = "abc", text2 = "def"; //ans =0
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i <= text1.length(); i++)
			Arrays.fill(dp[i], 0);
		System.out.println(solveRecTab(text1, text2, dp));
	}
}
