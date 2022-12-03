package co.kas.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day134__1_BuySellStockTab5 {
	static int solveTab(int[] prices,int fee) {
		// base case if whole arr traversed
		// if(i == prices.length) return 0;

		int[] curr = new int[2];
		int[] next = new int[2];
		
		Arrays.fill(curr,0);
		Arrays.fill(next,0);
		
		for (int i = prices.length - 1; i >= 0; i--) {
			for (int buy = 0; buy <= 1; buy++) {

				int profit = 0;
				if (buy == 1) {
					int buyKro = -prices[i] + next[0];
					int skipKro = 0 + next[1];
					profit = Math.max(buyKro, skipKro);
				} else {
					int sellKro = prices[i] -fee + next[1];
					int skipKro = 0 + next[0];
					profit = Math.max(sellKro, skipKro);
				}
				curr[buy] = profit;
			}
			next = curr;
		}
		return next[1];
	}

	public static void main(String[] args) {
		// multiple time b->s allowed
		int[] prices = new int[] { 1,3,7,5,10,3}; // ans 6 , fee = 3
		int fee = 3;
		int[][] dp = new int[prices.length + 1][2];
		for (int i = 0; i <= prices.length; i++)
			Arrays.fill(dp[i], 0);
		System.out.println(solveTab(prices,fee));
	}
}
