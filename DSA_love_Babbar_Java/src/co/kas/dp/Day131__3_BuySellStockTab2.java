package co.kas.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day131__3_BuySellStockTab2 {
	static int solveTab(int[] prices, int[][] dp) {
		// base case if whole arr traversed
		// if(i == prices.length) return 0;

		for (int i = prices.length - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {

				int profit = 0;
				if (buy == 1) {
					int buyKro = -prices[i] + dp[i + 1][0];
					int skipKro = 0 + dp[i + 1][1];
					profit = Math.max(buyKro, skipKro);
				} else {
					int sellKro = prices[i] + dp[i + 1][1];
					int skipKro = 0 + dp[i + 1][0];
					profit = Math.max(sellKro, skipKro);
				}
				dp[i][buy] = profit;
			}
		}
		return dp[0][1];
	}

	public static void main(String[] args) {
		// multiple time b->s allowed
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 }; // ans 7
		int[][] dp = new int[prices.length + 1][2];
		for (int i = 0; i <= prices.length; i++)
			Arrays.fill(dp[i], 0);
		System.out.println(solveTab(prices, dp));
	}
}
